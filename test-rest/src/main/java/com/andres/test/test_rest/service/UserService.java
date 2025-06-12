package com.andres.test.test_rest.service;

import java.util.List;

import com.andres.test.test_rest.dto.UserDTO;
import com.andres.test.test_rest.model.response.Response;

public interface UserService {

    Response<List<UserDTO>> retrieve();

    Response<UserDTO> createUser(UserDTO user);
}
