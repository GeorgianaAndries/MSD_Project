import { Component, OnInit,  ViewChild, ChangeDetectorRef } from '@angular/core';
import { Observable } from 'rxjs';
import {MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { AddInternDialogComponent } from './add-intern-dialog/add-intern-dialog.component';
import { EditInternDialogComponent } from './edit-intern-dialog/edit-intern-dialog.component';
import { SearchInternPipe } from './search-intern.pipe';

export interface Intern {
  _id: string;
  nume: string;
  prenume: string;
  oras: string;
  role: string;
  mail: string;
  tel: string;
  team: string;
  project: string;
  paid: string;
  start: Date;
  end: Date;
}

@Component({
  selector: 'app-interns',
  templateUrl: './interns.component.html',
  styleUrls: ['./interns.component.scss']
})
export class InternsComponent implements OnInit {
  DATA: Intern[];
  searchText: string;

  interns: Intern[] = [{ 
    _id: "123",
    nume: "geor",
    prenume: "andr",
    oras: "iasi",
    role: "developer",
    mail: "asd@mdg.com",
    tel: "12345678",
    team: "buff",
    project: "blaaa",
    paid: "yes",
    start: new Date(12-3-2020),
    end: new Date(10-1-2021) },
    { 
      _id: "345",
      nume: "gussss",
      prenume: "taaab",
      oras: "iasi",
      role: "ml ceva",
      mail: "asd@mdg.com",
      tel: "12345678",
      team: "buff",
      project: "blaaa",
      paid: "yes",
      start: new Date(12-3-2020),
      end: new Date(10-1-2021) }];

      @ViewChild(MatPaginator) paginator: MatPaginator;
      obs: Observable<any>;
      dataSource: MatTableDataSource<Intern>;

  constructor( private dialog: MatDialog,
    private changeDetectorRef: ChangeDetectorRef, ) { }

  ngOnInit(): void {
    this.DATA = this.interns;
    this.dataSource = new MatTableDataSource<Intern>(this.DATA);
    this.changeDetectorRef.detectChanges();
    this.dataSource.paginator = this.paginator;
    this.obs = this.dataSource.connect();
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


}
