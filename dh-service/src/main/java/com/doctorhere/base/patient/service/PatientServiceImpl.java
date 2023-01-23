package com.doctorhere.base.patient.service;


import com.doctorhere.base.patient.model.Patient;
import com.doctorhere.base.patient.model.dto.PatientRequest;
import com.doctorhere.base.patient.model.mapper.PatientMapper;
import com.doctorhere.base.patient.repository.PatientRepository;
import com.doctorhere.base.user.model.Role;
import com.doctorhere.base.user.model.User;
import com.doctorhere.base.user.model.UserRole;
import com.doctorhere.base.user.model.mapper.UserMapper;
import com.doctorhere.base.user.service.UserService;
import com.doctorhere.common.exception.BusinessRuleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final UserMapper userMapper;
    private final UserService userService;

    @Override
    @Transactional
    public void create(PatientRequest patientRequest) {
        User user;
        var userExist = userService.getByUsername(patientRequest.getEmail());
        if (userExist.isPresent()) {
            var patientRole = userExist.get().getRoles().stream().filter(p -> p.getRole().equals(Role.PATIENT)).findAny();
            if (patientRole.isPresent())
                throw new BusinessRuleException("exception.patient.exist");

            userExist.get().getRoles().add(new UserRole(Role.PATIENT, userExist.get()));
            user = userExist.get();
        } else {
            user = userMapper.toEntity(patientRequest.getEmail(), patientRequest.getPassword(), List.of(Role.PATIENT));
        }

        var patient = patientMapper.toEntity(patientRequest, user);
        patientRepository.save(patient);
    }

    @Override
    public Patient update(PatientRequest patientRequest) {
        return null;
    }
}
