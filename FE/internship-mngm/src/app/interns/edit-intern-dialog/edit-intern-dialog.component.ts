import { Component, OnInit, Inject, Optional, } from '@angular/core';
import { Router } from '@angular/router';

import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

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
  selector: 'app-edit-intern-dialog',
  templateUrl: './edit-intern-dialog.component.html',
  styleUrls: ['./edit-intern-dialog.component.scss']
})
export class EditInternDialogComponent implements OnInit {
  
  teams = ['Team 1', 'Team 2', 'Team 3', 'Team 4'];
  projects = ['Project 1', 'Project 2', 'Project 3', 'Project 4'];
  roles = ['FE Developer', 'Tester', 'BE developer', 'Analyst'];
  paid = ['Yes', 'No'];

  fromPage: Intern;
  ceva: string;


  constructor(
    public dialogRef: MatDialogRef<EditInternDialogComponent>,
    private router: Router,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: any
    ) {
      this.fromPage = data.pageValues;
    }

  ngOnInit(): void {
  }
  public onCloseDialog(): void {
    this.dialogRef.close();
  }
  public onSaveChanges() {
    console.log(this.fromPage);
    //this.requestsService.editRequest(this.fromPage).subscribe();
    this.dialogRef.close();
  }

}
