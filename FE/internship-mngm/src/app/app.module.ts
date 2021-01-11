import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AngularMaterialModule } from './angular-material/angular-material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { PageFormatComponent } from './page-format/page-format.component';
import { InternsComponent } from './interns/interns.component';
import { ProjectsComponent } from './projects/projects.component';
import { EditInternDialogComponent } from './interns/edit-intern-dialog/edit-intern-dialog.component';
import { AddInternDialogComponent } from './interns/add-intern-dialog/add-intern-dialog.component';
import { SearchInternPipe } from './interns/search-intern.pipe';
import { ProjectDetailsComponent } from './project-details/project-details.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { AddInternProjectComponent } from './project-details/add-intern-project/add-intern-project.component';

@NgModule({
  declarations: [
    AppComponent,
    PageFormatComponent,
    InternsComponent,
    ProjectsComponent,
    EditInternDialogComponent,
    AddInternDialogComponent,
    SearchInternPipe,
    ProjectDetailsComponent,
    HomeComponent,
    LoginComponent,
    AddInternProjectComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
