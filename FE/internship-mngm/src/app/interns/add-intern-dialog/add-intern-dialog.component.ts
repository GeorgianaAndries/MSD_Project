import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { InternsService } from '../interns.service';
import { Intern } from '../interns.component'; 
import { ProjectsService } from '../../projects/projects.service';
import { Project } from '../../projects/projects.component';

@Component({
  selector: 'app-add-intern-dialog',
  templateUrl: './add-intern-dialog.component.html',
  styleUrls: ['./add-intern-dialog.component.scss']
})

export class AddInternDialogComponent implements OnInit {

  fromDialog: Intern = {
    id: new Number(),
    name: '',
    city: '',
    role: '',
    mail: '',
    telNo: '',
    team: '',
    project: '',
    startDate: new Date(),
    endDate: new Date(),
    paid: new Boolean(),
  };

  constructor(
    public dialogRef: MatDialogRef<AddInternDialogComponent>,
    public router: Router,
    private projectsService: ProjectsService,
    public internService: InternsService,
    ) {}

  teams: String[];
  projects: Project[];
  roles = ['FrontEnd Developer', 'Tester', 'BackEnd Developer', 'Analyst'];
  paidv = [true, false];

  ngOnInit(): void {
    this.projectsService.getAllTeams().subscribe(teamsList => {
      this.teams = teamsList;
    });
    this.projectsService.getAllProjects().subscribe(projectsList => {
      this.projects = projectsList;
    });
  }

  public onSendDialog() {
    console.log(this.fromDialog);
    this.internService.postIntern(this.fromDialog).subscribe();
    window.location.reload();
    this.dialogRef.close();

  }
  public onCloseDialog(): void {
    this.dialogRef.close();
  }

}
