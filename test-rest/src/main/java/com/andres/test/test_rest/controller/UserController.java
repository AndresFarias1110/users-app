package com.andres.test.test_rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.test.test_rest.constant.RoutesConstant;
import com.andres.test.test_rest.dto.UserDTO;
import com.andres.test.test_rest.model.response.Response;
import com.andres.test.test_rest.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * Users Controller
 * @author Andres Farias
 * @since May 20 2025
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(RoutesConstant.USER_BASE_PATH)
public class UserController {

    private final UserService userService;

    @GetMapping(RoutesConstant.DATA_RETRIEVE_PATH)
    public Response<List<UserDTO>> retrieve() {
        // Optional<User> user =  userRepository.findById((long) 1);
        // if (user.isPresent()) {
        //     user.
        // }
        return this.userService.retrieve();

        
    }

    @PostMapping(RoutesConstant.DATA_CREATE_PATH)
    public Response<UserDTO> createUser(@RequestBody @Valid UserDTO user) {
        return this.userService.createUser(user);
    }

}
