import { Component, OnInit } from "@angular/core";
import { Employee } from "../employee/employee.component";
import { DataStorageService } from "../data/data-storage.service";
import { ActivatedRoute, Params, Router } from "@angular/router";

@Component({
  selector: "app-create-employee",
  templateUrl: "./create-employee.component.html",
  styleUrls: ["./create-employee.component.css"],
})
export class CreateEmployeeComponent implements OnInit {
  employee: Employee;
  id: number;
  editMode: boolean = false;

  firstName: string = "";
  lastName: string = "";
  emailId: string = "";
  salary: string = "";
  constructor(
    private dataStorage: DataStorageService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      this.id = +params["id"];
      console.log(this.id);
      this.editMode = params["id"] != null;

      console.log(this.editMode);
    });

    this.dataStorage.getEmployee(this.id).subscribe((result) => {
      console.log(result);
      this.employee = result;
      this.firstName = this.employee.firstName;
      this.lastName = this.employee.lastName;
      this.emailId = this.employee.emailId;
    });
  }

  onSubmit() {
    if (this.editMode) {
      const empObject = {
        firstName: this.employee.firstName,
        lastName: this.employee.lastName,
        emailId: this.employee.emailId,
      };

      console.log(empObject);
      this.dataStorage
        .updateEmployee(this.id, empObject)
        .subscribe((result) => {
          console.log(result);
          this.router.navigate(["./employees"]);
        });
    } else {
      const empObject = {
        firstName: this.firstName,
        lastName: this.lastName,
        emailId: this.emailId,
        salary: this.salary,
      };

      console.log(empObject);
      this.dataStorage.createEmployee(empObject).subscribe((result) => {
        console.log(result);
        this.router.navigate(["./employees"]);
      });
    }
  }
}
