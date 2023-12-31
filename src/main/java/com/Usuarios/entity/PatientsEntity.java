package com.Usuarios.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class PatientsEntity {

    @Id
    @Column(name = "id_patient", nullable = false)
    private Integer idPatient;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name="last_name", nullable = false,length = 50)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false,length = 10)
    private Integer phone;


}
