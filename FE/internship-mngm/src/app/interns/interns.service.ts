import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Router } from '@angular/router';
import { Intern } from './interns.component';

@Injectable({
  providedIn: 'root'
})
export class InternsService {

  constructor(private http: HttpClient,
              private router: Router,) { }

  public getAllInterns(): Observable<any>{
    return this.http.get<any>('http://localhost:8080/intern');
  }

  public postIntern(details: Intern): Observable<any> {
    return this.http.post<any>('http://localhost:8080/interns', details);
  }

  public editIntern(details: Intern): Observable<Intern> {
    const url = 'http://localhost:8080/intern_update';
    return this.http.put<Intern>(url, details);
  }

  public deleteIntern(InternId: string): Observable<any> {
    const url = `${'http://localhost:8080/interns'}/${InternId}`;
    return this.http.delete<any>(url);
  }
}
