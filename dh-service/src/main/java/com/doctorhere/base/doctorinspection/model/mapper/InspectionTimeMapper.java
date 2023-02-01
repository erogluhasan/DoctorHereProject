package com.doctorhere.base.doctorinspection.model.mapper;


import com.doctorhere.base.doctor.model.Doctor;
import com.doctorhere.base.doctorinspection.model.InspectionTime;
import com.doctorhere.base.doctorinspection.model.dto.InspectionTimeRequest;
import org.mapstruct.*;

import java.time.LocalDateTime;


@Mapper
public interface InspectionTimeMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "timeRangeStart", source = "inspectionTimeRequest.timeRangeStart")
    @Mapping(target = "timeRangeFinish", source = "inspectionTimeRequest.timeRangeFinish")
    @Mapping(target = "chatInspection", source = "doctor.chatInspection")
    @Mapping(target = "videoInspection", source = "doctor.videoInspection")
    @Mapping(target = "voiceInspection", source = "doctor.voiceInspection")
    @Mapping(target = "doctor.id", source = "doctor.id")
    @Mapping(target = "startTime", source = "timeStart")
    InspectionTime toEntity(Doctor doctor, LocalDateTime timeStart, InspectionTimeRequest inspectionTimeRequest);



}
