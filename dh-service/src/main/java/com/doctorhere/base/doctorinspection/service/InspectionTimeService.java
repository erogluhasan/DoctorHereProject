package com.doctorhere.base.doctorinspection.service;

import com.doctorhere.base.doctorinspection.model.dto.InspectionTimeRequest;

import java.util.List;

public interface InspectionTimeService {

    void create(List<InspectionTimeRequest> inspectionTimeRequest);

}
