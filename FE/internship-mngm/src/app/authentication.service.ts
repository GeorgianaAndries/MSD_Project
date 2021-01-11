import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';

import { Credentials } from './login/login.component';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient, private router: Router) { }

  public login(user: Credentials): Observable<any> {
    const url = `${'users-validation'}/${user.mail}/${user.password}`;
    const base = this.http.post(url, user);
    const request = base.pipe(
      map((data: Credentials) => {
        if (data.mail && data.password) {
          console.log("logged in");
        }
        return data;
      })
    );
    return request;
  }
}
