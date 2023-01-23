package com.doctorhere.base.patient.model.mapper;

import com.doctorhere.base.patient.model.Patient;
import com.doctorhere.base.patient.model.dto.PatientRequest;
import com.doctorhere.base.patient.model.dto.PatientResponse;
import com.doctorhere.base.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PatientMapper {

    @Mapping(target = "user", source = "user")
    @Mapping(target = "id", ignore = true)
    Patient toEntity(PatientRequest patientRequest, User user);

    PatientResponse toResponse(Patient patient);

}
