package com.doctorhere.base.doctor.model.mapper;

import com.doctorhere.base.doctor.model.dto.DoctorSettingsRequest;
import com.doctorhere.base.doctor.model.dto.DoctorSettingsResponse;
import com.doctorhere.base.doctor.DoctorSettings;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface DoctorSettingsMapper {

    DoctorSettings toEntity(DoctorSettingsRequest doctorSettingsRequest);

    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget DoctorSettings doctorSettings, DoctorSettingsRequest doctorSettingsRequest);

    DoctorSettingsResponse toResponse(DoctorSettings doctorSettings);

}
