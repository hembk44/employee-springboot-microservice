import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { WelcomeComponent } from "./home/welcome/welcome.component";
import { EmployeeComponent } from "./home/employee/employee.component";

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
    path: "employee",
    component: EmployeeComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
