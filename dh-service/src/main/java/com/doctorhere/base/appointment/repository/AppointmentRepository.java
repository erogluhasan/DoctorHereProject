package com.doctorhere.base.appointment.repository;

import com.doctorhere.base.appointment.enums.EnumAppointmentStatus;
import com.doctorhere.base.appointment.model.Appointment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByDoctorIdAndAppointmentTime(Long doctorId, LocalDateTime appointmentTime);
    @Query(value="select ap from Appointment ap  where (:status is null or ap.appointmentStatus = :status) and ap.deleted=false and (:patientId is null or ap.patient.id = :patientId) and (:doctorId is null or ap.doctor.id = :doctorId)",
            countQuery = "select count(ap) from Appointment ap where (:status is null or ap.appointmentStatus = :status) and ap.deleted=false " )
    Page<Appointment> findAllPageable(@Param("status") EnumAppointmentStatus status, Pageable request, @Param("patientId") Long patientId, @Param("doctorId") Long doctorId);
    @Query(value="select ap from Appointment ap  where (:status is null or ap.appointmentStatus = :status) and ap.deleted=false and (:patientId is null or ap.patient.id = :patientId) and (:doctorId is null or ap.doctor.id = :doctorId)")
    List<Appointment> findAllList(@Param("status") EnumAppointmentStatus status, Sort sort, @Param("patientId") Long patientId, @Param("doctorId") Long doctorId);

    @Query(value="select ap from Appointment ap  where ap.id= :id and ap.deleted=false and (:patientId is null or ap.patient.id = :patientId) and (:doctorId is null or ap.doctor.id = :doctorId)")
    Optional<Appointment> findByIdAndDoctorIdAndPatientId(@Param("id") Long id, @Param("doctorId") Long doctorId, @Param("patientId") Long patientId);
}
