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
    private EmployeeService employeeService;
    @GetMapping
    public ArrayList<Employee> getEmployee(){
        return this.employeeService.getEmployees();
    }

    @GetMapping(path = "/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id){
        return this.employeeService.getEmployeeById(id);
    }

    @PostMapping("/new")
    public Employee saveEmployee(@RequestBody Employee Employee){
        return this.employeeService.saveEmployee(Employee);
    }

    @PutMapping("/update-{id}")
    public Employee updateEmployee(@RequestBody Employee Employee,@PathVariable int id){
        return this.employeeService.updateEmployeeById(Employee,id);
    }

    @DeleteMapping("/delete-{id}")
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
