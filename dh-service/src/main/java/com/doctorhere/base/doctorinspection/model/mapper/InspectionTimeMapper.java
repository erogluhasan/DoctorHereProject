package com.doctorhere.base.doctorinspection.model.mapper;


import com.doctorhere.base.doctorinspection.model.InspectionTime;
import org.mapstruct.*;

import java.time.LocalDateTime;


@Mapper
public interface InspectionTimeMapper {

    @Mapping(target = "doctor.id", source = "doctorId")
    InspectionTime toEntity(Long doctorId, LocalDateTime startTime, boolean voice, boolean video, boolean chat);



}
