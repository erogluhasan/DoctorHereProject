package com.doctorhere.base.doctor.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoctorResponse {
    private boolean newsletter;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String certificateNo;
    private String patentNo; //Tescil No
    private String graduadateSchool;
    private Long professionId;
    private String interests;
    private String workHospital;
    private String image;
    private String video;
    private String cv;
    private DoctorSettingsResponse doctorSettings;
    private List<Long> doctorProfessionsIdList;
}
