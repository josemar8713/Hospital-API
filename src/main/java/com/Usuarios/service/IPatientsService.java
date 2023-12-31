package com.Usuarios.service;

import com.Usuarios.entity.PatientsEntity;

import java.util.List;
import java.util.Optional;

public interface IPatientsService {
    List<PatientsEntity> findAll();

    Optional<PatientsEntity> findById(Integer id);

    void save(PatientsEntity patientsEntity);

    void deleById (Integer id);
}
