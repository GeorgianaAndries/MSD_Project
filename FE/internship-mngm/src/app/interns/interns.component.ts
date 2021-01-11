import { Component, OnInit, OnDestroy, ViewChild, ChangeDetectorRef } from '@angular/core';
import { Observable } from 'rxjs';
import {MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { AddInternDialogComponent } from './add-intern-dialog/add-intern-dialog.component';
import { EditInternDialogComponent } from './edit-intern-dialog/edit-intern-dialog.component';
import { SearchInternPipe } from './search-intern.pipe';
import { InternsService } from './interns.service';

export interface Intern {
  id: Number;
  name: string;
  city: string;
  role: string;
  mail: string;
  telNo: string;
  team: string;
  project: string;
  paid: Boolean;
  startDate: Date;
  endDate: Date;
}

@Component({
  selector: 'app-interns',
  templateUrl: './interns.component.html',
  styleUrls: ['./interns.component.scss']
})
export class InternsComponent implements OnInit, OnDestroy {
  DATA: Intern[];
  searchText: string;

      @ViewChild(MatPaginator) paginator: MatPaginator;
      obs: Observable<any>;
      dataSource: MatTableDataSource<Intern>;

  constructor( private dialog: MatDialog,
    private changeDetectorRef: ChangeDetectorRef,
    private internService: InternsService ) { }

  ngOnInit(): void {
    this.internService.getAllInterns().subscribe(internsList => {
      this.DATA = internsList;
      this.dataSource = new MatTableDataSource<Intern>(this.DATA);
      this.changeDetectorRef.detectChanges();
      this.dataSource.paginator = this.paginator;
      this.obs = this.dataSource.connect();
    });
  }

  public openAddInternDialog(): void {

    this.dialog.open(AddInternDialogComponent, {width: '500px'
   });
  }

  public openEditDialog(details): void {
    this.dialog.open(EditInternDialogComponent, {width: '500px',
    backdropClass: 'custom-dialog-backdrop-class',
      panelClass: 'custom-dialog-panel-class',
    data: {
      pageValues: details
    }});
    console.log('detalii: ', details);
  }

  public onClickDelete(reqId) {
    this.internService.deleteIntern(reqId).subscribe();
    window.location.reload();
  }
  ngOnDestroy() {
    if (this.dataSource) {
      this.dataSource.disconnect();
    }
  }

}
