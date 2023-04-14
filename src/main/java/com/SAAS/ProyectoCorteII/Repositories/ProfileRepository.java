package com.SAAS.ProyectoCorteII.Repositories;

import com.SAAS.ProyectoCorteII.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer> {
}
