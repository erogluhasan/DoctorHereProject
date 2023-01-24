package com.doctorhere.base.doctor.model.dto;

import com.doctorhere.base.entity.dto.AbstractDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class DoctorRequest extends AbstractDto {

    private boolean newsletter;

    @NotNull
    @Size(max = 150, message = "validation.doctor.name.size")
    @ApiModelProperty(example = "name")
    private String name;

    @NotNull
    @Size(max = 150, message = "validation.doctor.surname.size")
    @ApiModelProperty(example = "surname")
    private String surname;

    @NotNull
    @Size(max = 150, message = "validation.doctor.email.size")
    @ApiModelProperty(example = "email")
    private String email;

    @NotNull
    @Size(min = 8, message = "validation.doctor.password.size")
    @ApiModelProperty(example = "password")
    private String password;

    @Size(min = 8, message = "validation.doctor.passwordnew.size")
    @ApiModelProperty(example = "passwordNew")
    private String passwordNew;

    @NotNull
    @Size(max = 150, message = "validation.doctor.phone.size")
    @ApiModelProperty(example = "phone")
    private String phone;

    @NotNull
    @Size(max = 150, message = "validation.doctor.certificateNo.size")
    @ApiModelProperty(example = "certificateNo")
    private String certificateNo;

    @NotNull
    @Size(max = 150, message = "validation.doctor.patentNo.size")
    @ApiModelProperty(example = "patentNo")
    private String patentNo; //Tescil No

    @NotNull
    @Size(max = 150, message = "validation.doctor.graduadateSchool.size")
    @ApiModelProperty(example = "graduadateSchool")
    private String graduadateSchool;

    @NotNull
    @ApiModelProperty(example = "1")
    private Long professionId;

    @NotNull
    @Size(max = 150, message = "validation.doctor.interests.size")
    @ApiModelProperty(example = "interests")
    private String interests;

    private String workHospital;

    private String image;

    private String video;

    private String cv;

    private String online;

    private List<Long> doctorProfessionsIdList;
}
