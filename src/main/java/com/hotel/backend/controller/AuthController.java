package com.hotel.backend.controller;

import com.hotel.backend.dto.LoginRequest;
import com.hotel.backend.dto.LoginResponse;
import com.hotel.backend.entity.User;
import com.hotel.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        User user = userService.findByEmail(request.getEmail()).orElse(null);

        if (user == null) {
            return ResponseEntity.status(401).body("Invalid email");
        }

        if (!userService.checkPassword(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid password");
        }

        return ResponseEntity.ok(
                new LoginResponse("Login successful", user.getRole(), user.getEmail())
        );
    }
}
