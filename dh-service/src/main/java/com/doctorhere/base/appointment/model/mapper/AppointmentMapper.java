package com.doctorhere.base.appointment.model.mapper;

import com.doctorhere.base.appointment.model.Appointment;
import com.doctorhere.base.appointment.model.dto.AppointmentRequest;
import com.doctorhere.base.appointment.model.dto.AppointmentResponse;
import com.doctorhere.base.doctor.model.Doctor;
import com.doctorhere.base.doctorinspection.model.InspectionTime;
import com.doctorhere.base.patient.model.Patient;
import com.doctorhere.base.profession.model.Profession;
import com.doctorhere.base.profession.model.dto.ProfessionResponseDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface AppointmentMapper {


    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "appointmentStatus", constant = "WAITING_APPROVED")
    @Mapping(target = "appointmentTime", source = "inspectionTime.startTime")
    @Mapping(target = "appointmentType", source = "request.appointmentType")
    @Mapping(target = "doctor.id", source = "request.doctorId")
    @Mapping(target = "cost", source = "request.cost")
    @Mapping(target = "fee", source = "request.fee")
    @Mapping(target = "patient", source = "patient")
    Appointment toEntity(Patient patient, InspectionTime inspectionTime, AppointmentRequest request);

    @Mapping(target = "doctorName", source = "appointment.doctor.name")
    @Mapping(target = "doctorSurname", source = "appointment.doctor.surname")
    @Mapping(target = "patientName", source = "appointment.patient.name")
    @Mapping(target = "patientSurname", source = "appointment.patient.surname")
    AppointmentResponse toResponse(Appointment appointment);

    List<AppointmentResponse> toResponse(List<Appointment> appointments);
}
