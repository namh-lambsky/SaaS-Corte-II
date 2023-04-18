package com.SAAS.ProyectoCorteII.Services;

import com.SAAS.ProyectoCorteII.Model.Employee;
import com.SAAS.ProyectoCorteII.Model.Enterprise;
import com.SAAS.ProyectoCorteII.Model.Transaction;
import com.SAAS.ProyectoCorteII.Repositories.EmployeeRepository;
import com.SAAS.ProyectoCorteII.Repositories.EnterpriseRepository;
import com.SAAS.ProyectoCorteII.Repositories.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    EnterpriseRepository enterpriseRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public ArrayList<Transaction> getTransactions() {
        return (ArrayList<Transaction>) transactionRepository.findAll();
    }

    public Transaction getTransactionById(int id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transaccion con el id " + id + "no encontrado"));
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
    }

    public Enterprise getEnterpriseById(int e_id) {
        return enterpriseRepository.findById(e_id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa con el id " + e_id + "no encontrado"));
    }


    public Transaction saveTransaction(Transaction transaction) {
        Date currentDate = new Date(System.currentTimeMillis());
        transaction.setCreated_at(currentDate);
        transaction.setUpdated_at(currentDate);
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransactionById(Transaction request, int id) {
        Transaction transaction = getTransactionById(id);
        transaction.setAmount(request.getAmount());
        transaction.setConcept(request.getConcept());

        if (request.getEnterprise() != null) {
            transaction.setEnterprise(getEnterpriseById(request.getEnterprise().getId()));
        }
        if (request.getEmployee() != null) {
            transaction.setEmployee(getEmployeeById(request.getEmployee().getId()));
        }

        Date currentDate = new Date(System.currentTimeMillis());
        transaction.setUpdated_at(currentDate);


        transactionRepository.save(transaction);

        return transaction;
    }

    public Boolean deleteTransactionById(int id) {
        try {
            transactionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
