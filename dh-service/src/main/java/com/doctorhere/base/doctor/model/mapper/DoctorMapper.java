package com.doctorhere.base.doctor.model.mapper;

import com.doctorhere.base.doctor.model.Doctor;
import com.doctorhere.base.doctor.model.dto.DoctorRequest;
import com.doctorhere.base.doctor.model.dto.DoctorResponse;
import com.doctorhere.base.user.model.User;
import org.mapstruct.*;

@Mapper
public interface DoctorMapper extends BaseDoctorMapper {

    @Mapping(target = "doctorProfessionsSet", source = "doctorRequest.doctorProfessionsIdList", qualifiedByName = "convertToDoctorProfessions")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "profession.id", source = "doctorRequest.professionId")
    @Mapping(target = "approved", constant = "false")
    Doctor toEntity(DoctorRequest doctorRequest, User user);

    @Mapping(target = "doctorProfessionsIdList", source = "doctorProfessionsSet", qualifiedByName = "extractDoctorProfessionsIdList")
    DoctorResponse toResponse(Doctor doctor);

    @Mapping(target = "user", source = "user")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "approved", ignore = true)
    void updateEntity(@MappingTarget Doctor doctor, DoctorRequest doctorRequest, User user);

    @BeforeMapping
    default void doBeforeMapping(@MappingTarget Doctor doctor, DoctorRequest doctorRequest, User user) {
        doctor.setProfession(null);
    }

    @AfterMapping
    default void doAfterMapping(@MappingTarget Doctor doctor, DoctorRequest doctorRequest, User user) {
        if (doctorRequest.getProfessionId() == null)
            doctor.setProfession(null);
    }

}
