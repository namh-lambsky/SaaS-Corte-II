package com.SAAS.ProyectoCorteII.Repositories;

import com.SAAS.ProyectoCorteII.Model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise,Integer> {
}
