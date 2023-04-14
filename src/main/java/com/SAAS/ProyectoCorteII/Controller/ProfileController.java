package com.SAAS.ProyectoCorteII.Controller;


import com.SAAS.ProyectoCorteII.Model.Profile;
import com.SAAS.ProyectoCorteII.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @GetMapping
    public ArrayList<Profile> getProfile(){
        return this.profileService.getProfile();
    }

    @GetMapping(path = "/{id}")
    public Optional<Profile> getProfileById(@PathVariable int id){
        return this.profileService.getProfileById(id);
    }

    @PostMapping("/new")
    public Profile saveProfile(@RequestBody Profile Profile){
        return this.profileService.saveProfile(Profile);
    }

    @PutMapping("/update-{id}")
    public Profile updateProfile(@RequestBody Profile Profile,@PathVariable int id){
        return this.profileService.updateProfileById(Profile,id);
    }

    @DeleteMapping("/delete-{id}")
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
