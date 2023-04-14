package com.SAAS.ProyectoCorteII.Controller;


import com.SAAS.ProyectoCorteII.Model.Enterprise;
import com.SAAS.ProyectoCorteII.Services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;
    @GetMapping
    public ArrayList<Enterprise> getEnterprise(){
        return this.enterpriseService.getEnterprises();
    }

    @GetMapping(path = "/{id}")
    public Optional<Enterprise> getEnterpriseById(@PathVariable int id){
        return this.enterpriseService.getEnterpriseById(id);
    }

    @PostMapping(path = "/new")
    public Enterprise saveEnterprise(@RequestBody Enterprise enterprise){
        return this.enterpriseService.saveEnterprise(enterprise);
    }

    @PutMapping(path = "/update-{id}")
    public Enterprise updateEnterprise(@RequestBody Enterprise enterprise,@PathVariable int id){
        return this.enterpriseService.updateEnterpriseById(enterprise,id);
    }

    @DeleteMapping("/delete-{id}")
    public String deleteEnterprise(@PathVariable int id){
        boolean isDeleted = this.enterpriseService.deleteEnterpriseById(id);
        if (isDeleted){
            return "Enterprise with id: "+id+" was deleted";
        }
        else {
            return "Unexpected error: Enterprise with id:"+id+" was not deleted";
        }
    }

}
