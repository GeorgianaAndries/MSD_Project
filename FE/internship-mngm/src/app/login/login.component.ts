import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';

export interface Credentials {
  mail: string;
  password: string;
}
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  credentials: Credentials = {
    mail: '',
    password: ''
  }
  constructor( private router: Router, private auth: AuthenticationService) { }

  ngOnInit(): void {
  }

  login() {
    if (this.credentials.mail && this.credentials.password) {
      this.auth.login(this.credentials).subscribe(() => {
        this.router.navigateByUrl('management/home');
      },
        err => {
          console.error(err);
        });
    }
  }

}
