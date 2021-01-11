import { Component, OnInit } from '@angular/core';
import { Intern } from '../interns/interns.component';
import { ProjectsService } from './projects.service';

export interface Project {
  id: Number;
  projectName: string;
  startDate: Date;
  endDate: Date;
  team: string;
  client: string;
  salary: string;
}

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.scss']
})
export class ProjectsComponent implements OnInit {
projectCurent: Project;

 display: boolean = false;
  projects: Project[];
constructor( private projectService: ProjectsService
            ){ }

ngOnInit(): void {
  this.projectService.getAllProjects().subscribe(projectsList => {
    this.projects = projectsList;
  });
}
onPress(project) {
  
  //if you want the component to show and hide on click pressed, use use this line 
 this.display = true;
  console.log(project)
  this.projectService.getProject(project.id).subscribe(project => {
    this.projectCurent = project;
  });
}
}
