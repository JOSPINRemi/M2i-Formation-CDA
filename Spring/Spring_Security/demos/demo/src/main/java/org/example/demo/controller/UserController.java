package org.example.demo.controller;

import org.example.demo.dto.BaseResponseDto;
import org.example.demo.dto.UserLoginDto;
import org.example.demo.model.User;
import org.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/auth/register")
    public BaseResponseDto registerUser(@RequestBody User user) {
        if (userService.createUser(user)) {
            return new BaseResponseDto("success");
        } else {
            return new BaseResponseDto("failed");
        }
    }

    @PostMapping("/api/auth/login")
    public BaseResponseDto loginUser(@RequestBody UserLoginDto userLoginDto) {
        if (userService.checkUserNameExists(userLoginDto.getEmail())) {
            if (userService.verifyUser(userLoginDto.getEmail(), userLoginDto.getPassword())) {
                Map<String, Object> data = new HashMap<>();
                data.put(
                        "token",
                        userService.generateToken(
                                userLoginDto.getEmail(), userLoginDto.getPassword()
                        )
                );
                return new BaseResponseDto("success", data);
            } else return new BaseResponseDto("Wrong password");
        } else return new BaseResponseDto("User not found");
    }
}
