package com.doctorhere.base.appointment.model;

import com.doctorhere.base.appointment.enums.EnumAppointmentStatus;
import com.doctorhere.base.doctor.model.Doctor;
import com.doctorhere.base.entity.BaseEntity;
import com.doctorhere.base.patient.model.Patient;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "dh_appointment_detail")
@Where(clause = "deleted = false")
public class AppointmentDetail extends BaseEntity {


    @JoinColumn(name = "appointment_id")
    @ManyToOne
    private Appointment appointment;

    private String note;

}