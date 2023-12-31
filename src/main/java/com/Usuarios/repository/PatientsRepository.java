package com.Usuarios.repository;

import com.Usuarios.entity.PatientsEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends ListCrudRepository<PatientsEntity,Integer> {
}
