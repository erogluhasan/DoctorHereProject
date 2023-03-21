package com.doctorhere.base.appointment.repository;

import com.doctorhere.base.appointment.model.Appointment;
import com.doctorhere.base.district.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByDoctorIdAndAppointmentTime(Long doctorId, LocalDateTime appointmentTime);
}
