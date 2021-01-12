import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Router } from '@angular/router';
import { Intern } from '../interns/interns.component';
import { Project } from './projects.component';

@Injectable({
  providedIn: 'root'
})
export class ProjectsService {

  constructor(private http: HttpClient,
              private router: Router,) { }

  public getAllProjects(): Observable<any>{
    return this.http.get<any>('http://localhost:8080/project');
  }

  public getProject(projectId): Observable<any> {
    const url = `${'http://localhost:8080/projects'}/${projectId}`;
    return this.http.get<any>(url);
  }

  public getProjectTeam(projectName): Observable<any> {
    const url = `${'http://localhost:8080/interns-by-project'}/${projectName}`;
    return this.http.get<any>(url);
  }

  public deleteMember(InternId: string): Observable<any> {
    const url = `${'http://localhost:8080/interns-project'}/${InternId}`;
    return this.http.delete<any>(url);
  }

  public getAllTeams(): Observable<any>{
    return this.http.get<any>('http://localhost:8080/all-team-names');
  }


}
