package com.SAAS.ProyectoCorteII.Services;

import com.SAAS.ProyectoCorteII.Model.Employee;
import com.SAAS.ProyectoCorteII.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public ArrayList<Employee> getEmployees(){
        return (ArrayList<Employee>) employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(int id){
        return employeeRepository.findById(id);
    }

    public Employee updateEmployeeById(Employee request, int id){
        Employee employee = employeeRepository.findById(id).get();
        employee.setId(request.getId());
        employee.setEmail(request.getEmail());
        employee.setProfile(request.getProfile());
        employee.setRole(request.getRole());
        employee.setEnterprise(request.getEnterprise());
        employee.setTransactionList(request.getTransactionList());

        employeeRepository.save(employee);
        return employee;
    }

    public Boolean deleteEmployeeById(int id){
        try {
            employeeRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
