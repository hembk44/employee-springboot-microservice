import { Component, OnInit } from "@angular/core";
import { DataStorageService } from "../data/data-storage.service";
import { MatSnackBar } from "@angular/material/snack-bar";
import { ActivatedRoute, Router } from "@angular/router";

export interface Employee {
  empId: number;
  firstName: string;
  lastName: string;
  emailId: string;
  salary: string;
}

@Component({
  selector: "app-employee",
  templateUrl: "./employee.component.html",
  styleUrls: ["./employee.component.css"],
})
export class EmployeeComponent implements OnInit {
  employees: Employee[];

  constructor(
    private dataStorageService: DataStorageService,
    private _snackBar: MatSnackBar,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.refreshEmployees();
  }

  refreshEmployees() {
    this.dataStorageService.employeesList().subscribe((result) => {
      console.log(result);
      this.employees = result;
    });
  }

  deleteEmployee(id: number) {
    this.dataStorageService.deleteEmployee(id).subscribe((result) => {
      console.log(result);
      if (result == null) {
        this._snackBar.open(
          "Employee with id " + id + " is deleted!",
          "close",
          {
            duration: 5000,
            panelClass: ["delete"],
          }
        );
      }
      this.refreshEmployees();
    });
  }

  updateEmployee(id: number) {
    this.router.navigate(["employees", id]);
  }

  createEmployee() {
    this.router.navigate(["create"]);
  }
}
