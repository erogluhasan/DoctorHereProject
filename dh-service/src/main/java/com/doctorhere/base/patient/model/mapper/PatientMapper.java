package com.doctorhere.base.patient.model.mapper;

import com.doctorhere.base.patient.model.Patient;
import com.doctorhere.base.patient.model.dto.PatientRequest;
import com.doctorhere.base.patient.model.dto.PatientResponse;
import com.doctorhere.base.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface PatientMapper {

    @Mapping(target = "user", source = "user")
    @Mapping(target = "id", ignore = true)
    Patient toEntity(PatientRequest patientRequest, User user);

    PatientResponse toResponse(Patient patient);
    @Mapping(target = "user", source = "user")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    void updateEntity(@MappingTarget Patient patient, PatientRequest request, User user);
}
