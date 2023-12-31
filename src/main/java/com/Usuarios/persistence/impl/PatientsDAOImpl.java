package com.Usuarios.persistence.impl;

import com.Usuarios.entity.PatientsEntity;
import com.Usuarios.persistence.IPatientsDAO;
import com.Usuarios.repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class PatientsDAOImpl implements IPatientsDAO {

    @Autowired
    private PatientsRepository patientsRepository;

    @Override
    public List<PatientsEntity> findAll() { return (List<PatientsEntity>) patientsRepository.findAll();}

    @Override
    public Optional<PatientsEntity> findById(Integer id) { return  patientsRepository.findById(id);}

    @Override
    public void save(PatientsEntity patientsEntity) { patientsRepository.save(patientsEntity);}

    @Override
    public void deleById(Integer id) {patientsRepository.deleteById(id);}
}
