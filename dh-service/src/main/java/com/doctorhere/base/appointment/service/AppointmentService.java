package com.doctorhere.base.appointment.service;

import com.doctorhere.base.appointment.model.Appointment;
import com.doctorhere.base.appointment.model.dto.AppointmentRequest;
import com.doctorhere.base.patient.model.Patient;
import com.doctorhere.base.patient.model.dto.PatientRequest;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AppointmentService {

    void create(AppointmentRequest appointmentRequest);
    Optional<Appointment> findByDoctorIdAndAppointmentTime(Long doctorId, LocalDateTime startTime);

}
