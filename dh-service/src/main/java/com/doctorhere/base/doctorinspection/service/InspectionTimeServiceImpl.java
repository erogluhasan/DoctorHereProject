package com.doctorhere.base.doctorinspection.service;

import com.doctorhere.base.doctor.model.Doctor;
import com.doctorhere.base.doctor.service.DoctorService;
import com.doctorhere.base.doctorinspection.model.InspectionTime;
import com.doctorhere.base.doctorinspection.model.dto.InspectionTimeRequest;
import com.doctorhere.base.doctorinspection.model.mapper.InspectionTimeMapper;
import com.doctorhere.base.doctorinspection.repository.InspectionTimeRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class InspectionTimeServiceImpl implements InspectionTimeService {

    private final InspectionTimeRepository inspectionTimeRepository;
    private final DoctorService doctorService;

    private final InspectionTimeMapper inspectionTimeMapper;

    @Override
    @Transactional
    public void create(List<InspectionTimeRequest> inspectionTimeRequestList) {
        Doctor doctor = doctorService.getById(1L);//TODO  doktor token ile alınacak

        List<InspectionTime> inspectionTimes = new ArrayList<>();

        inspectionTimeRequestList.forEach(inspectionTimeRequest -> {
            List<LocalDateTime> inspectionTimeValues = calculateAndGetPeriodList(doctor.getInspectionPeriodMinute(), inspectionTimeRequest.getStartHour(), inspectionTimeRequest.getFinishHour());
            inspectionTimeValues.forEach(inspectionTime -> {
                inspectionTimes.add(
                        inspectionTimeMapper.toEntity(
                                doctor.getId(),
                                inspectionTime,
                                doctor.getVoiceInspection(),
                                doctor.getVideoInspection(),
                                doctor.getChatInspection()
                        ));
            });

        });

        inspectionTimeRepository.saveAll(inspectionTimes);

    }


    private List<LocalDateTime> calculateAndGetPeriodList(Integer periodMinute, LocalDateTime startTime, LocalDateTime finishTime) {
        LocalDateTime periodTime;
        List<LocalDateTime> localDateTimes = new ArrayList<>();
        boolean isValidTime;
        do {
            periodTime = startTime.plusMinutes(periodMinute);
            isValidTime = periodTime.isBefore(finishTime);
            if (isValidTime) {
                localDateTimes.add(periodTime);
                startTime = periodTime;
            }

        } while (isValidTime);

        return localDateTimes;
    }

}
