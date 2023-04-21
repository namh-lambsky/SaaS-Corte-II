package com.SAAS.ProyectoCorteII.Services;

import com.SAAS.ProyectoCorteII.Model.Employee;
import com.SAAS.ProyectoCorteII.Model.Enterprise;
import com.SAAS.ProyectoCorteII.Model.Profile;
import com.SAAS.ProyectoCorteII.Model.Transaction;
import com.SAAS.ProyectoCorteII.Repositories.EmployeeRepository;
import com.SAAS.ProyectoCorteII.Repositories.EnterpriseRepository;
import com.SAAS.ProyectoCorteII.Repositories.ProfileRepository;
import com.SAAS.ProyectoCorteII.Repositories.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    EnterpriseRepository enterpriseRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public ArrayList<Employee> getEmployees() {
        return (ArrayList<Employee>) employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
    }

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findAllByEmail(email);
    }

    public Profile getProfileById(int id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Perfil con el id " + id + "no encontrado"));
    }

    public Enterprise getEnterpriseById(int id) {
        return enterpriseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa con el id " + id + "no encontrado"));
    }

    public Transaction getTransactionById(int t_id) {
        return transactionRepository.findById(t_id)
                .orElseThrow(() -> new EntityNotFoundException("Transacción con el id " + t_id + "no encontrado"));
    }

    public Employee saveEmployee(Employee employee) {
        int p_id = employee.getProfile().getId();
        int e_id = employee.getEnterprise().getId();

        Date currentDate = new Date(System.currentTimeMillis());
        employee.setProfile(getProfileById(p_id));
        employee.setEnterprise(getEnterpriseById(e_id));
        employee.setCreated_at(currentDate);
        employee.setUpdated_at(currentDate);

        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeById(Employee request, int id) {
        Employee employee = this.getEmployeeById(id);
        employee.setEmail(request.getEmail());
        employee.setRole(request.getRole());
        if (request.getProfile() != null) {
            employee.setProfile(getProfileById(request.getProfile().getId()));
        }
        if (request.getEnterprise() != null) {
            employee.setEnterprise(getEnterpriseById(request.getEnterprise().getId()));
        }
        if (request.getTransactions() != null) {
            employee.setTransactions(request.getTransactions());
        }
        Date currentDate = new Date(System.currentTimeMillis());
        employee.setUpdated_at(currentDate);

        employeeRepository.save(employee);

        return employee;
    }

    public Boolean deleteEmployeeById(int id) {
        try {
            employeeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
