package com.Usuarios.persistence;

import com.Usuarios.entity.PatientsEntity;

import java.util.List;
import java.util.Optional;

public interface IPatientsDAO {

    List<PatientsEntity> findAll();

    Optional<PatientsEntity> findById(Integer id);

    void save(PatientsEntity patientsEntity);

    void deleById (Integer id);
}
