package com.SAAS.ProyectoCorteII.Services;


import com.SAAS.ProyectoCorteII.Model.Enterprise;
import com.SAAS.ProyectoCorteII.Repositories.EnterpriseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class EnterpriseService {
    @Autowired
    EnterpriseRepository enterpriseRepository;

    public ArrayList<Enterprise> getEnterprises() {
        return (ArrayList<Enterprise>) enterpriseRepository.findAll();
    }

    public Enterprise getEnterpriseById(int id) {
        return enterpriseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa con el id " + id + "no encontrado"));
    }

    public Enterprise saveEnterprise(Enterprise enterprise) {
        Date currentDate = new Date(System.currentTimeMillis());
        enterprise.setCreated_at(currentDate);
        enterprise.setUpdated_at(currentDate);
        return enterpriseRepository.save(enterprise);
    }

    public Enterprise updateEnterpriseById(Enterprise request, int id) {
        Enterprise enterprise = getEnterpriseById(id);
        enterprise.setName(request.getName());
        enterprise.setDocument(request.getDocument());
        enterprise.setPhone(request.getPhone());
        enterprise.setAddress(request.getAddress());
        if (request.getEmployees() != null) {
            enterprise.setEmployees(request.getEmployees());
        }

        if (request.getTransactions() != null) {
            enterprise.setTransactions(request.getTransactions());
        }
        Date currentDate = new Date(System.currentTimeMillis());
        enterprise.setUpdated_at(currentDate);
        enterpriseRepository.save(enterprise);

        return enterprise;
    }

    public Boolean deleteEnterpriseById(int id) {
        try {
            enterpriseRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
