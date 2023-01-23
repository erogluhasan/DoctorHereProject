package com.doctorhere.base.user.model.mapper;

import com.doctorhere.base.user.model.Role;
import com.doctorhere.base.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Mapper
public interface UserMapper {

    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password", qualifiedByName = "passwordEncoder")
    @Mapping(target = "roles", source = "roles")
    User toEntity(String username, String password, List<Role> roles);

    @Named("passwordEncoder")
    default String passwordEncoder(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }


    @Mapping(target = "password", source = "password", qualifiedByName = "passwordEncoder")
    User updateEntity(@MappingTarget User userExist, String password);
}
