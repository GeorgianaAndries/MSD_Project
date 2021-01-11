import { Component, OnInit, Inject, Optional, } from '@angular/core';
import { Router } from '@angular/router';

import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { InternsService } from '../interns.service';
import { Intern } from '../interns.component';
import { ProjectsService } from '../../projects/projects.service';
import { Project } from '../../projects/projects.component';

@Component({
  selector: 'app-edit-intern-dialog',
  templateUrl: './edit-intern-dialog.component.html',
  styleUrls: ['./edit-intern-dialog.component.scss']
})
export class EditInternDialogComponent implements OnInit {
  
  teams: String[];
  projects: Project[];
  roles = ['FrontEnd Developer', 'Tester', 'BackEnd Developer', 'Analyst'];
  paid = [true, false];

  fromPage: Intern;

  constructor(
    public dialogRef: MatDialogRef<EditInternDialogComponent>,
    private router: Router,
    private projectsService: ProjectsService,
    public internService: InternsService,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: any
    ) {
      this.fromPage = data.pageValues;
    }

  ngOnInit(): void {
    this.projectsService.getAllTeams().subscribe(teamsList => {
      this.teams = teamsList;
    });
    this.projectsService.getAllProjects().subscribe(projectsList => {
      this.projects = projectsList;
    });
  }
  public onCloseDialog(): void {
    this.dialogRef.close();
  }
  public onSaveChanges() {
    console.log(this.fromPage);
    this.internService.editIntern(this.fromPage).subscribe();
    this.dialogRef.close();
  }

}
