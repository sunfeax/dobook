package com.sunfeax.dobook.service;

import com.sunfeax.dobook.entity.UserEntity;
import com.sunfeax.dobook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }
}
