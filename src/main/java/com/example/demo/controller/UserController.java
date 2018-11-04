package com.example.demo.controller;

import com.example.demo.controller.api.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        List<String> users = userService.getUsernames();

        return users.stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }
}
