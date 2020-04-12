import { Injectable } from "@angular/core";

import { HttpClient } from "@angular/common/http";
import { Employee } from "../employee/employee.component";

@Injectable({
  providedIn: "root",
})
export class DataStorageService {
  private baseUrlEmployee = "http://localhost:8081/api/employees/";
  constructor(private http: HttpClient) {}

  employeesList() {
    return this.http.get<Employee[]>(this.baseUrlEmployee);
  }

  deleteEmployee(id: number) {
    return this.http.delete(this.baseUrlEmployee + "delete/" + id);
  }

  getEmployee(id: number) {
    return this.http.get<Employee>(this.baseUrlEmployee + "get/" + id);
  }

  updateEmployee(id: number, obj: Object) {
    return this.http.put<Employee>(this.baseUrlEmployee + "update/" + id, obj);
  }

  createEmployee(obj: Object) {
    return this.http.post<Employee>(this.baseUrlEmployee + "set/", obj);
  }
}
