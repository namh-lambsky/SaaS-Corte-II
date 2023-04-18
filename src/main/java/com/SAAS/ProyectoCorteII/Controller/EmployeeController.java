package com.SAAS.ProyectoCorteII.Controller;

import com.SAAS.ProyectoCorteII.Model.Employee;
import com.SAAS.ProyectoCorteII.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ArrayList<Employee>getEmployees(){
        return this.employeeService.getEmployees();
    }

    @GetMapping(path = "/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return this.employeeService.getEmployeeById(id);
    }

    @PostMapping(path = "/new")
    public Employee saveEmployee(@RequestBody Employee employee){
        return this.employeeService.saveEmployee(employee);
    }

    @PutMapping(path = "/update-{id}")
    public Employee updateEmployee(@RequestBody Employee request,  @PathVariable int id){
        return this.employeeService.updateEmployeeById(request,id);
    }

    @DeleteMapping(path = "/delete-{id}")
    public String deleteEmployee(@PathVariable int id){
        boolean isDeleted = this.employeeService.deleteEmployeeById(id);
        if (isDeleted){
            return "Employee with id: "+id+" was deleted";
        }
        else {
            return "Unexpected error: Employee with id:"+id+" was not deleted";
        }
    }
}
