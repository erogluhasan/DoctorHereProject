package com.doctorhere.base.doctorinspection.model.dto;

import com.doctorhere.base.entity.dto.AbstractDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class InspectionTimeRequest extends AbstractDto {

    @NotNull
    private LocalDate day;

    @NotNull
    private LocalDateTime timeStart;

    @NotNull
    private LocalDateTime timeFinish;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime timeRangeStart;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime timeRangeFinish;

}
