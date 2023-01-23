package com.doctorhere.base.patient;

import com.doctorhere.base.patient.model.dto.PatientRequest;
import com.doctorhere.base.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping("signup")
    public ResponseEntity createDoctor(@RequestBody PatientRequest patientRequest) {
        patientService.create(patientRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
