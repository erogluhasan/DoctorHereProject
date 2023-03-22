package com.doctorhere.base.appointment.model.dto;

import com.doctorhere.base.appointment.enums.EnumAppointmentStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AppointmentResponse {
    private String doctorName;
    private String doctorSurname;
    private String patientName;
    private String patientSurname;
    private String note;
    private EnumAppointmentStatus appointmentStatus;
    private LocalDateTime appointmentTime;
    private Double fee;
    private Double cost;
}
