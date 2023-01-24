package com.doctorhere.base.user.service;

import com.doctorhere.base.user.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getByUsername(String username);

    User passwordCheckAndUpdate(String password, String newPassword, User userExist);

}
