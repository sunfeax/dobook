package com.sunfeax.dobook.mapper;

import org.springframework.stereotype.Component;

import com.sunfeax.dobook.dto.user.UserResponseDto;
import com.sunfeax.dobook.entity.UserEntity;

@Component
public class UserMapper {

    public UserResponseDto toResponseDto(UserEntity userEntity) {
        return new UserResponseDto(
            userEntity.getId(),
            userEntity.getFirstName(),
            userEntity.getLastName(),
            userEntity.getEmail(),
            userEntity.getPhoneNumber(),
            userEntity.getRole(),
            userEntity.getUserType(),
            userEntity.getCreatedAt()
        );
    }
}
