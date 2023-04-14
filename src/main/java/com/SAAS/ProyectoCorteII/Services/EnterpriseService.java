package com.SAAS.ProyectoCorteII.Services;

import com.SAAS.ProyectoCorteII.Model.Enterprise;
import com.SAAS.ProyectoCorteII.Repositories.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EnterpriseService {

    @Autowired
    EnterpriseRepository enterpriseRepository;

    public ArrayList<Enterprise> getEnterprises(){
        return (ArrayList<Enterprise>) enterpriseRepository.findAll();
    }

    public Enterprise saveEnterprise(Enterprise enterprise){
        return enterpriseRepository.save(enterprise);
    }

    public Optional<Enterprise> getEnterpriseById(int id){
        return enterpriseRepository.findById(id);
    }

    public Enterprise updateEnterpriseById(Enterprise request, int id){
        Enterprise enterprise = enterpriseRepository.findById(id).get();
        enterprise.setId(request.getId());
        enterprise.setName(request.getName());
        enterprise.setDocument(request.getDocument());
        enterprise.setPhone(request.getPhone());
        enterprise.setAddress(request.getAddress());

        enterpriseRepository.save(enterprise);
        return enterprise;
    }

    public Boolean deleteEnterpriseById(int id){
        try {
            enterpriseRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
