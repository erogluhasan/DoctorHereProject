package com.doctorhere.base.patient.repository;

import com.doctorhere.base.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
