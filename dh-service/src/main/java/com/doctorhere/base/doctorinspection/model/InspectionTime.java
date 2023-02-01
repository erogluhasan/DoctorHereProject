package com.doctorhere.base.doctorinspection.model;

import com.doctorhere.base.doctor.model.Doctor;
import com.doctorhere.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "dh_doctor_inspection_time")
@Where(clause = "deleted = false")
public class InspectionTime extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    //TODO saat dilimi tutulmalı
    private LocalDateTime startTime;

    private boolean voiceInspection;

    private boolean videoInspection;

    private boolean chatInspection;

}
