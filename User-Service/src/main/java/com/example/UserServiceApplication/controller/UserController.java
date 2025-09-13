package com.example.UserServiceApplication.controller;

import com.example.UserServiceApplication.dto.UserRequestDTO;
import com.example.UserServiceApplication.model.Users;
import com.example.UserServiceApplication.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @PostMapping("/addUpdate")
    private ResponseEntity<Users> addUpdate(@RequestBody @Valid UserRequestDTO dto) throws JsonProcessingException {
        Users user = userService.addUpdate(dto);
        if(user != null){
            ResponseEntity response = new ResponseEntity(user, HttpStatus.OK);
            return response;
        }
        return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/userDetails")
    public Users getUserDetails(@RequestParam("contact") String contact){
        Users u = userService.loadUserByUsername(contact);
        return u;
    }
}
