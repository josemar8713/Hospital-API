package com.Usuarios.web.controller;

import com.Usuarios.entity.PatientsEntity;
import com.Usuarios.service.IPatientsService;
import com.Usuarios.web.controller.dto.PatientsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientsController {

    @Autowired
    private IPatientsService patientsService;

    @GetMapping("/findall")

    public ResponseEntity<?> findAll() {
        List<PatientsDTO> patientsDTO = patientsService.findAll()
                .stream()
                .map(patients -> PatientsDTO.builder()
                        .idPatient(patients.getIdPatient())
                        .name(patients.getName())
                        .lastName(patients.getLastName())
                        .age(patients.getAge())
                        .phone(patients.getPhone())
                        .build())
                .toList();
        return ResponseEntity.ok(patientsDTO);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<PatientsEntity> patientsOptional = patientsService.findById(id);
        if (patientsOptional.isPresent()) {
            PatientsEntity patients = patientsOptional.get();

            PatientsDTO patientsDTO = PatientsDTO.builder()
                    .name(patients.getName())
                    .lastName(patients.getLastName())
                    .age(patients.getAge())
                    .phone(patients.getPhone())
                    .build();
            return ResponseEntity.ok(patientsDTO);

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PatientsDTO patientsDTO) throws URISyntaxException {
        if (patientsDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        patientsService.save(PatientsEntity.builder()
                .idPatient(patientsDTO.getIdPatient())
                .name(patientsDTO.getName())
                .lastName(patientsDTO.getLastName())
                .age(patientsDTO.getAge())
                .phone(patientsDTO.getPhone())
                .build());
        return ResponseEntity.created(new URI("/api/patients/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody PatientsDTO patientsDTO) {
        Optional<PatientsEntity> patientsEntityOptional = patientsService.findById(id);

        if (patientsEntityOptional.isPresent()) {
            PatientsEntity patients = patientsEntityOptional.get();
            patients.setIdPatient(patientsDTO.getIdPatient());
            patients.setName(patientsDTO.getName());
            patients.setLastName(patientsDTO.getLastName());
            patients.setAge(patientsDTO.getAge());
            patients.setPhone(patientsDTO.getPhone());
            patientsService.save(patients);
            return ResponseEntity.ok("PATIENT UPDATED CORRECTLY");
        }
        return ResponseEntity.notFound().build();
    }
}