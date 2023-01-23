package com.doctorhere.base.patient.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatientResponse {
    private boolean newsletter;
    private String name;
    private String surname;
    private String email;
    private String phone;
}
