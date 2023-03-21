package com.doctorhere.base.appointment.service;


import com.doctorhere.base.appointment.model.Appointment;
import com.doctorhere.base.appointment.model.dto.AppointmentRequest;
import com.doctorhere.base.appointment.model.mapper.AppointmentMapper;
import com.doctorhere.base.appointment.repository.AppointmentRepository;
import com.doctorhere.base.doctor.model.Doctor;
import com.doctorhere.base.doctor.service.DoctorService;
import com.doctorhere.base.doctorinspection.model.InspectionTime;
import com.doctorhere.base.doctorinspection.service.InspectionTimeService;
import com.doctorhere.base.patient.model.Patient;
import com.doctorhere.base.patient.service.PatientService;
import com.doctorhere.common.exception.BusinessRuleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final InspectionTimeService inspectionTimeService;
    private final AppointmentMapper appointmentMapper;

    @Override
    public void create(AppointmentRequest appointmentRequest) {
        Patient patient = patientService.getById(1L);//TODO  hasta token ile alınacak
        Doctor doctor = doctorService.findById(appointmentRequest.getDoctorId());
        InspectionTime inspectionTime = inspectionTimeService.getByIdAndDoctorId(appointmentRequest.getInspectionTimeId(), appointmentRequest.getDoctorId());

        findByDoctorIdAndAppointmentTime(appointmentRequest.getDoctorId(), inspectionTime.getStartTime()).ifPresent(appointment -> {
            throw new BusinessRuleException("exception.appointment.exist");
        });

        appointmentRepository.save(appointmentMapper.toEntity(patient, inspectionTime, appointmentRequest));
    }

    @Override
    public Optional<Appointment> findByDoctorIdAndAppointmentTime(Long doctorId, LocalDateTime startTime) {
        return appointmentRepository.findByDoctorIdAndAppointmentTime(doctorId, startTime);
    }

}
