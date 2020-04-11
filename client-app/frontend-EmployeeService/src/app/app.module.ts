import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './home/welcome/welcome.component';
import { EmployeeComponent } from './home/employee/employee.component';
import { ErrorComponent } from './home/error/error.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    EmployeeComponent,
    ErrorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
