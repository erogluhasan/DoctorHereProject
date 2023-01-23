package com.doctorhere.base.patient;

import com.doctorhere.base.patient.model.dto.PatientRequest;
import com.doctorhere.base.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
@Validated
public class PatientController {

    private final PatientService patientService;

    @PostMapping("signup")
    public ResponseEntity createPatient(@RequestBody PatientRequest patientRequest) {
        patientService.create(patientRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity updatePatient(@Valid @RequestBody PatientRequest patientRequest) {
        patientService.update(patientRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
}
