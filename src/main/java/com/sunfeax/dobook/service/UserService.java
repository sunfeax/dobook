package com.sunfeax.dobook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunfeax.dobook.entity.UserEntity;
import com.sunfeax.dobook.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }
}
