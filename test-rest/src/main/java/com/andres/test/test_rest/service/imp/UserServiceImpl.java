package com.andres.test.test_rest.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andres.test.test_rest.constant.MessageResponse;
import com.andres.test.test_rest.dto.UserDTO;
import com.andres.test.test_rest.entity.User;
import com.andres.test.test_rest.model.response.Response;
import com.andres.test.test_rest.repository.UserRepository;
import com.andres.test.test_rest.service.UserService;
import com.andres.test.test_rest.utility.Utilities;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Response<List<UserDTO>> retrieve() {
        return new Response<List<UserDTO>>(MessageResponse.SUCCESS_RETRIEVE, 
        this.userRepository
            .findAll()
            .stream()
            .map(userEntity -> Utilities.mapping(userEntity, UserDTO.class))
            .collect(Collectors.toList())
        );
    }

    @Override
    @Transactional
    public Response<UserDTO> createUser(UserDTO user) {
        User userEntity = new User();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setAge(user.getAge());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));

        this.userRepository.save(userEntity);
        return new Response<>(MessageResponse.SUCCESS_RETRIEVE, null);
    }

}
