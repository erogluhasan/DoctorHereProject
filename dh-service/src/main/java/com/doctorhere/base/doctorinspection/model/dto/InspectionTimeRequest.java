package com.doctorhere.base.doctorinspection.model.dto;

import com.doctorhere.base.entity.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class InspectionTimeRequest extends AbstractDto {

    @NotNull
    private LocalDate day;

    @NotNull
    private LocalDateTime startHour;

    @NotNull
    private LocalDateTime finishHour;

}
