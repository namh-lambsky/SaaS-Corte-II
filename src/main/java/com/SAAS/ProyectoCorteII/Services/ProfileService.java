package com.SAAS.ProyectoCorteII.Services;


import com.SAAS.ProyectoCorteII.Model.Profile;
import com.SAAS.ProyectoCorteII.Repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public ArrayList<Profile> getProfile(){
        return (ArrayList<Profile>) profileRepository.findAll();
    }

    public Profile saveProfile(Profile profile){
        return profileRepository.save(profile);
    }

    public Optional<Profile> getProfileById(int id){
        return profileRepository.findById(id);
    }

    public Profile updateProfileById(Profile request, int id){
        Profile profile = profileRepository.findById(id).get();
        profile.setId(request.getId());
        profile.setImage(request.getImage());
        profile.setPhone(request.getPhone());
        profile.setEmployee(request.getEmployee());

        profileRepository.save(profile);
        return profile;
    }

    public Boolean deleteProfileById(int id){
        try {
            profileRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
