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
public class DoctorSettingsRequest extends AbstractDto {

    private Boolean online;
    private Integer inspectionPeriodMinute;
    private Boolean voiceInspection;
    private Boolean videoInspection;
    private Boolean chatInspection;
}
