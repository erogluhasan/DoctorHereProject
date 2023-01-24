package com.doctorhere.base.user.service;



import com.doctorhere.base.user.model.User;
import com.doctorhere.base.user.model.mapper.UserMapper;
import com.doctorhere.base.user.repository.UserRepository;
import com.doctorhere.common.exception.BusinessRuleException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    
    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User passwordCheckAndUpdate(String password, String newPassword, User userExist) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(bCryptPasswordEncoder.matches(password, userExist.getPassword())){
            if (!StringUtils.isBlank(newPassword)) {
                userExist = userMapper.updateEntity(userExist, newPassword);
            }
        } else {
            throw new BusinessRuleException("exception.user.password.wrong");
        }
        return userExist;
    }
}
