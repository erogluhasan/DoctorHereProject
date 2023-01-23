package com.doctorhere.base.patient.repository;

import com.doctorhere.base.patient.model.Patient;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    @EntityGraph(attributePaths = {"user"})
    Optional<Patient> findById(Long id);

}
