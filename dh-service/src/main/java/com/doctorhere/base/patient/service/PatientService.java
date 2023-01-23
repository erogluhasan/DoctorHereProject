package com.doctorhere.base.patient.service;

import com.doctorhere.base.patient.model.Patient;
import com.doctorhere.base.patient.model.dto.PatientRequest;

public interface PatientService {

    void create(PatientRequest patientRequest);

    Patient update(PatientRequest patientRequest);

}
