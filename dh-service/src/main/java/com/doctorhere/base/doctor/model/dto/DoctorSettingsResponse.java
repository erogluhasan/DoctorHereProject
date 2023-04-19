package com.doctorhere.base.doctor.model.dto;

import com.doctorhere.base.entity.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorSettingsResponse {

    private Boolean online;
    private Integer inspectionPeriodMinute;
    private Boolean voiceInspection;
    private Boolean videoInspection;
    private Boolean chatInspection;
}
