import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { InternsComponent } from './interns/interns.component';
import { PageFormatComponent } from './page-format/page-format.component';
import { ProjectsComponent } from './projects/projects.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'management/home',
    pathMatch: 'full',
  },
  {
    path: 'management',
    component: PageFormatComponent,
    children: [
      {
        path: 'interns',
        component: InternsComponent,
      },
      {
        path: 'projects',
        component: ProjectsComponent
      },
      {
        path: 'home',
        component: HomeComponent,
      }
    ]
  },
  {
    path: 'login',
    component: LoginComponent,

  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
