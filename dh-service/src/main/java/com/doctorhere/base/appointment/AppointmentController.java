package com.doctorhere.base.appointment;

import com.doctorhere.base.appointment.model.Appointment;
import com.doctorhere.base.appointment.model.dto.AppointmentRequest;
import com.doctorhere.base.appointment.service.AppointmentService;
import com.doctorhere.base.patient.model.dto.PatientRequest;
import com.doctorhere.base.patient.service.PatientService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/appointment")
@RequiredArgsConstructor
@Validated
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/save")
    public ResponseEntity createPatient(@RequestBody AppointmentRequest appointmentRequest) {
        appointmentService.create(appointmentRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PutMapping("cancel")
    public void delete(@RequestBody AppointmentRequest appointmentRequest){
        appointmentService.delete(appointmentRequest);
    }
}
