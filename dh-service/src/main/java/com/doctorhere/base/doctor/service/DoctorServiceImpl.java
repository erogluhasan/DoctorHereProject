package com.doctorhere.base.doctor.service;


import com.doctorhere.base.doctor.model.Doctor;
import com.doctorhere.base.doctor.model.dto.DoctorRequest;
import com.doctorhere.base.doctor.model.mapper.DoctorMapper;
import com.doctorhere.base.doctor.repository.DoctorRepository;
import com.doctorhere.base.user.model.Role;
import com.doctorhere.base.user.model.User;
import com.doctorhere.base.user.model.UserRole;
import com.doctorhere.base.user.model.mapper.UserMapper;
import com.doctorhere.base.user.service.UserService;
import com.doctorhere.common.exception.BusinessRuleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;
    private final UserMapper userMapper;
    private final UserService userService;

    @Override
    @Transactional
    public void create(DoctorRequest doctorRequest) {
        User user;
        var userExist = userService.getByUsername(doctorRequest.getEmail());
        if (userExist.isPresent()) {
            var doctorRole = userExist.get().getRoles().stream().filter(p -> p.getRole().equals(Role.DOCTOR)).findAny();
            if (doctorRole.isPresent())
                throw new BusinessRuleException("exception.doctor.exist");

            userExist.get().getRoles().add(new UserRole(Role.DOCTOR, userExist.get()));
            user = userExist.get();
        } else {
            user = userMapper.toEntity(doctorRequest.getEmail(), doctorRequest.getPassword(), List.of(Role.DOCTOR));
        }

        var doctor = doctorMapper.toEntity(doctorRequest, user);
        doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(DoctorRequest doctorRequest) {
        return null;
    }
}
