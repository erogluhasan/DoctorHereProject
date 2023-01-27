package com.doctorhere.base.doctorinspection.repository;

import com.doctorhere.base.doctorinspection.model.InspectionTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionTimeRepository extends JpaRepository<InspectionTime,Long> {
}
