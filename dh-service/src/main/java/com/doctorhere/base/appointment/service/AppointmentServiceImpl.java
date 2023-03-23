package com.doctorhere.base.appointment.service;


import com.doctorhere.base.appointment.enums.EnumAppointmentStatus;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
     @Override
    public Page<Appointment> findAllPageable(Integer pageNumber, Integer pageSize, String sortingDirection, String sortingName, EnumAppointmentStatus status, Long patientId, Long doctorId) {
        Sort.Direction direction;
        if (sortingDirection.equals("ASC")) {
            direction = Sort.Direction.ASC;
        } else {
            direction = Sort.Direction.DESC;
        }
        return appointmentRepository.findAllPageable(status, PageRequest.of(pageNumber - 1, pageSize, Sort.by(direction, sortingName)), patientId, doctorId);
    }

    @Override
    public List<Appointment> findAllList(String sortingDirection, String sortingName, EnumAppointmentStatus status, Long patientId, Long doctorId) {
        Sort.Direction direction;
        if (sortingDirection.equals("ASC")) {
            direction = Sort.Direction.ASC;
        } else {
            direction = Sort.Direction.DESC;
        }
        return appointmentRepository.findAllList(status, Sort.by(direction, sortingName), patientId, doctorId);
    }


    @Override
    public void delete(AppointmentRequest appointmentRequest) {
        appointmentRepository.findById(appointmentRequest.getId()).ifPresentOrElse((appointment) ->{
            if(appointmentIsDeletable(appointment)){
                appointment.setAppointmentStatus(EnumAppointmentStatus.CANCELED);
                appointment.setCancelTime(LocalDateTime.now());
                appointment.setCancelReason(appointmentRequest.getCancelReason());
                appointmentRepository.save(appointment);
            }
        },() -> {
            throw new BusinessRuleException("exception.appointment.notfound");
        });
    }

    private boolean appointmentIsDeletable(Appointment appointment) {
        //TODO iş akışlarını uygula, onaylı ise nasıl olmalı?
        if(!appointment.getAppointmentStatus().equals(EnumAppointmentStatus.WAITING_APPROVED) ||
                appointment.getAppointmentTime().isBefore(LocalDateTime.now())){
            throw new BusinessRuleException("exception.appointment.cancel.notavailable");
        }
        return true;
    }

}
