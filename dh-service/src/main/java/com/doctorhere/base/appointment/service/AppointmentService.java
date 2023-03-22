package com.doctorhere.base.appointment.service;

import com.doctorhere.base.appointment.enums.EnumAppointmentStatus;
import com.doctorhere.base.appointment.model.Appointment;
import com.doctorhere.base.appointment.model.dto.AppointmentRequest;
import com.doctorhere.base.patient.model.Patient;
import com.doctorhere.base.patient.model.dto.PatientRequest;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    void create(AppointmentRequest appointmentRequest);
    Optional<Appointment> findByDoctorIdAndAppointmentTime(Long doctorId, LocalDateTime startTime);

    Page<Appointment> findAllPageable(Integer pageNumber, Integer pageSize, String sortingDirection, String sortingName, EnumAppointmentStatus status, Long patientId, Long doctorId);

    List<Appointment> findAllList(String sortingDirection, String sortingName, EnumAppointmentStatus status, Long patientId, Long doctorId);
}
