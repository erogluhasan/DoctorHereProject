package com.doctorhere.base.doctor;

import com.doctorhere.base.doctor.model.Doctor;
import com.doctorhere.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "dh_doctor_settings")
@Where(clause = "deleted = false")
public class DoctorSettings extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    private Boolean online;
    private Integer inspectionPeriodMinute;
    private Boolean voiceInspection;
    private Boolean videoInspection;
    private Boolean chatInspection;
}
