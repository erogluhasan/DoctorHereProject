package com.doctorhere.base.doctorinspection.repository;

import com.doctorhere.base.doctorinspection.model.InspectionTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InspectionTimeRepository extends JpaRepository<InspectionTime,Long> {
    Optional<InspectionTime> findByIdAndDoctorId(Long inspectionTimeId, Long doctorId);
}
