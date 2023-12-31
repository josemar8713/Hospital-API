package com.Usuarios.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientsDTO {

private Integer idPatient;
private String name;
private String lastName;
private Integer age;
private Integer phone;

}
