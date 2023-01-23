package com.doctorhere.base.patient.model.dto;

import com.doctorhere.base.entity.dto.AbstractDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PatientRequest extends AbstractDto {

    private boolean newsletter;

    @NotNull
    @Size(max = 150, message = "validation.patient.name.size")
    @ApiModelProperty(example = "name")
    private String name;

    @NotNull
    @Size(max = 150, message = "validation.patient.surname.size")
    @ApiModelProperty(example = "surname")
    private String surname;

    @NotNull
    @Size(max = 150, message = "validation.patient.email.size")
    @ApiModelProperty(example = "email")
    private String email;

    @NotNull
    @Size(min = 8, message = "validation.patient.password.size")
    @ApiModelProperty(example = "password")
    private String password;

    @NotNull
    @Size(max = 150, message = "validation.patient.phone.size")
    @ApiModelProperty(example = "phone")
    private String phone;

    @Size(min = 8, message = "validation.patient.passwordnew.size")
    @ApiModelProperty(example = "passwordNew")
    private String passwordNew;

}
