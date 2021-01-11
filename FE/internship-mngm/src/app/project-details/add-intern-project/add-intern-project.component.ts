import { Component, OnInit, Inject, Optional, } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Project } from 'src/app/projects/projects.component';
import { Intern } from '../../interns/interns.component';
import { InternsService } from '../../interns/interns.service';
import { ProjectsService } from '../../projects/projects.service';

@Component({
  selector: 'app-add-intern-project',
  templateUrl: './add-intern-project.component.html',
  styleUrls: ['./add-intern-project.component.scss']
})
export class AddInternProjectComponent implements OnInit {
  DATA: Intern[];
  fromPage: Project;
  constructor(private internService: InternsService,
    public dialogRef: MatDialogRef<AddInternProjectComponent>,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: any
    ) {
      this.fromPage = data.pageValues;
    }

  ngOnInit(): void {
    this.internService.getAllInterns().subscribe(internsList => {
      this.DATA = internsList;
    });
  }

  onAddClick(intern){
    intern.project = this.fromPage.projectName;
    this.internService.editIntern(intern).subscribe();
  }

  public onCloseDialog(): void {
    this.dialogRef.close();
  }

}
