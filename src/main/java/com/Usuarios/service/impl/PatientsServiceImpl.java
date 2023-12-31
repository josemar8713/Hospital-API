package com.Usuarios.service.impl;

import com.Usuarios.entity.PatientsEntity;
import com.Usuarios.persistence.IPatientsDAO;
import com.Usuarios.service.IPatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientsServiceImpl implements IPatientsService {

    @Autowired
    private IPatientsDAO patientsDAO;

    @Override
    public List<PatientsEntity> findAll() {return patientsDAO.findAll();}

    @Override
    public Optional<PatientsEntity> findById(Integer id) {return patientsDAO.findById(id);}

    @Override
    public void save(PatientsEntity patientsEntity) { patientsDAO.save(patientsEntity);}

    @Override
    public void deleById(Integer id) { patientsDAO.deleById(id);}
}
