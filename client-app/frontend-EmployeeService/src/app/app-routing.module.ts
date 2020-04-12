import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { WelcomeComponent } from "./home/welcome/welcome.component";
import { EmployeeComponent } from "./home/employee/employee.component";
import { ErrorComponent } from "./home/error/error.component";
import { CreateEmployeeComponent } from "./home/create-employee/create-employee.component";

const routes: Routes = [
  {
    path: "",
    redirectTo: "welcome",
    pathMatch: "full",
  },
  {
    path: "welcome",
    component: WelcomeComponent,
  },
  {
    path: "employees",
    component: EmployeeComponent,
  },
  {
    path: "create",
    component: CreateEmployeeComponent,
  },
  {
    path: "employees/:id",
    component: CreateEmployeeComponent,
  },
  {
    path: "**",
    component: ErrorComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
