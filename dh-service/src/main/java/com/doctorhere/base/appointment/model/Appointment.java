package com.doctorhere.base.appointment.model;

import com.doctorhere.base.appointment.enums.EnumAppointmentStatus;
import com.doctorhere.base.appointment.enums.EnumAppointmentType;
import com.doctorhere.base.country.model.Country;
import com.doctorhere.base.doctor.model.Doctor;
import com.doctorhere.base.entity.BaseEntity;
import com.doctorhere.base.patient.model.Patient;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "dh_appointment")
@Where(clause = "deleted = false")
public class Appointment extends BaseEntity {


    @JoinColumn(name = "doctor_id")
    @ManyToOne
    private Doctor doctor;

    @JoinColumn(name = "patient_id")
    @ManyToOne
    private Patient patient;

    private LocalDateTime appointmentTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EnumAppointmentStatus appointmentStatus;

    private String note;

    private LocalDateTime cancelTime;

    private String cancelReason;

    private Double fee;

    private Double cost;

    @Enumerated(EnumType.STRING)
    @Column(name = "appointment_type")
    private EnumAppointmentType appointmentType;


}