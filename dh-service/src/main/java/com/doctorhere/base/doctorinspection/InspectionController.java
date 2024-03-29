package com.doctorhere.base.doctorinspection;

import com.doctorhere.base.doctorinspection.model.dto.InspectionTimeRequest;
import com.doctorhere.base.doctorinspection.service.InspectionTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/doctor-inspection")
@RequiredArgsConstructor
@Validated
public class InspectionController {

    private final InspectionTimeService doctorInspectionTimeService;


    @PostMapping("inspection-time")
    public ResponseEntity createInspectionTime(@RequestBody List<@Valid InspectionTimeRequest> inspectionTimeRequestList){
        doctorInspectionTimeService.create(inspectionTimeRequestList);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
