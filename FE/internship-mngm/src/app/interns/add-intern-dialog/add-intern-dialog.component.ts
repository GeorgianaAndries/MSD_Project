import { Component, OnInit } from '@angular/core';
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
  selector: 'app-add-intern-dialog',
  templateUrl: './add-intern-dialog.component.html',
  styleUrls: ['./add-intern-dialog.component.scss']
})

export class AddInternDialogComponent implements OnInit {

  fromDialog: Intern = {
    _id: '',
    nume: '',
    prenume: '',
    oras: '',
    role: '',
    mail: '',
    tel: '',
    team: '',
    project: '',
    paid: '',
    start: new Date(),
    end: new Date(),
  };

  constructor(
    public dialogRef: MatDialogRef<AddInternDialogComponent>,
    public router: Router,
    ) {}

  teams = ['Team 1', 'Team 2', 'Team 3', 'Team 4'];
  projects = ['Project 1', 'Project 2', 'Project 3', 'Project 4'];
  roles = ['FE Developer', 'Tester', 'BE developer', 'Analyst'];
  paid = ['Yes', 'No'];

  ngOnInit(): void {
  }

  public onSendDialog() {
    console.log(this.fromDialog);
    window.location.reload();
    this.dialogRef.close();

  }
  public onCloseDialog(): void {
    this.dialogRef.close();
  }

}
