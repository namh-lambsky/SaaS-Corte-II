package com.SAAS.ProyectoCorteII.Controller;

import com.SAAS.ProyectoCorteII.Model.Profile;
import com.SAAS.ProyectoCorteII.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @GetMapping
    public ArrayList<Profile>getProfiles(){
        return this.profileService.getProfiles();
    }

    @GetMapping(path = "/{id}")
    public Profile getProfileById(@PathVariable int id){
        return this.profileService.getProfileById(id);
    }

    @PostMapping(path = "/new")
    public Profile saveProfile(@RequestBody Profile profile){
        return this.profileService.saveProfile(profile);
    }

    @PutMapping(path = "/update-{id}")
    public Profile updateProfile(@RequestBody Profile request,  @PathVariable int id){
        return this.profileService.updateProfileById(request,id);
    }

    @DeleteMapping(path = "/delete-{id}")
    public String deleteProfile(@PathVariable int id){
        boolean isDeleted = this.profileService.deleteProfileById(id);
        if (isDeleted){
            return "Profile with id: "+id+" was deleted";
        }
        else {
            return "Unexpected error: Profile with id:"+id+" was not deleted";
        }
    }
}
