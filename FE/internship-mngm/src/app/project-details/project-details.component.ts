import { Component, OnInit, Input } from '@angular/core';
import {MatDialog } from '@angular/material/dialog';
import { Project } from '../projects/projects.component';
import { AddInternProjectComponent } from './add-intern-project/add-intern-project.component';
import { Intern } from '../interns/interns.component';
import { ProjectsService } from '../projects/projects.service';

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.scss']
})
export class ProjectDetailsComponent implements OnInit {
  
  interns : Intern[];

  @Input() project: Project;
  constructor(private dialog: MatDialog,
              private projectService: ProjectsService) { }

  ngOnInit(): void {
    this.projectService.getProjectTeam(this.project.projectName).subscribe(internsList => {
      this.interns = internsList;
    });
  }
  onAddMemberClick(project){
    this.dialog.open(AddInternProjectComponent, {width: '500px',
    backdropClass: 'custom-dialog-backdrop-class',
      panelClass: 'custom-dialog-panel-class',
    data: {
      pageValues: project
    }});
    console.log('detalii: ', project);
  }

  onDeleteMember(member){
    this.projectService.deleteMember(member.id).subscribe();
    window.location.reload();
  }

}
