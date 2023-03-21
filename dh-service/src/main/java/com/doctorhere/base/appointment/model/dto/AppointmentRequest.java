package com.doctorhere.base.appointment.model.dto;

import com.doctorhere.base.appointment.enums.EnumAppointmentType;
import com.doctorhere.base.entity.dto.AbstractDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapping;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class AppointmentRequest extends AbstractDto {

    @NotNull
    @Size(max = 150, message = "validation.patient.name.size")
    @ApiModelProperty(example = "doctorId", value = "1")
    private Long doctorId;

    @NotNull
    @ApiModelProperty(example = "inspectionTimeId", value = "1")
    private Long inspectionTimeId;

    @NotNull
    @ApiModelProperty(example = "appointmentType", value = "VIDEO")
    private EnumAppointmentType appointmentType;

    @Size(max = 1500, message = "validation.appointment.note.size")
    private String note;

    @NotNull
    @ApiModelProperty(example = "fee", value = "1.1")
    private Double fee;

    @NotNull
    @ApiModelProperty(example = "cost", value = "1.1")
    private Double cost;

}
