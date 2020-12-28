import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { InternsComponent } from './interns/interns.component';
import { PageFormatComponent } from './page-format/page-format.component';
import { ProjectsComponent } from './projects/projects.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'management/interns',
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
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
