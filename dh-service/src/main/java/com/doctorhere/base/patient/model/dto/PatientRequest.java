package com.doctorhere.base.patient.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class PatientRequest {

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

    @NotNull
    @Size(max = 150, message = "validation.doctor.phone.size")
    @ApiModelProperty(example = "phone")
    private String phone;

}
