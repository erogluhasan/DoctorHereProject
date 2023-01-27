package com.doctorhere.base.doctorinspection.model.dto;

import com.doctorhere.base.entity.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class InspectionTimeResponse extends AbstractDto {

    private LocalDate day;

    private LocalTime startHour;

    private LocalTime finishHour;

}
