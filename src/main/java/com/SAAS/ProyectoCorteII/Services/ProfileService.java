package com.SAAS.ProyectoCorteII.Services;

import com.SAAS.ProyectoCorteII.Model.Employee;
import com.SAAS.ProyectoCorteII.Model.Profile;
import com.SAAS.ProyectoCorteII.Repositories.EmployeeRepository;
import com.SAAS.ProyectoCorteII.Repositories.ProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public ArrayList<Profile> getProfiles() {
        return (ArrayList<Profile>) profileRepository.findAll();
    }

    public Profile getProfileById(int id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Perfil con el id: " + id + " no encontrado"));
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
    }

    public Profile saveProfile(Profile profile) {
        Date currentDate = new Date(System.currentTimeMillis());
        profile.setCreated_at(currentDate);
        profile.setUpdated_at(currentDate);
        if (profile.getEmployee() != null) {
            profile.setEmployee(getEmployeeById(profile.getEmployee().getId()));
        }
        return profileRepository.save(profile);
    }

    public Profile updateProfileById(Profile request, int id) {
        Profile profile = getProfileById(id);
        profile.setImage(request.getImage());
        profile.setPhone(request.getPhone());
        if (request.getEmployee() != null) {
            profile.setEmployee(getEmployeeById(request.getEmployee().getId()));
        }

        Date currentDate = new Date(System.currentTimeMillis());
        profile.setUpdated_at(currentDate);
        profileRepository.save(profile);

        return profile;
    }

    public Boolean deleteProfileById(int id) {
        try {
            profileRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
