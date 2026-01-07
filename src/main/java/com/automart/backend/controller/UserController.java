package com.automart.backend.controller;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automart.backend.model.User;
import com.automart.backend.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserRepository userRepository;

   @PostMapping("/register")
public Map<String, Object> registerUser(@RequestBody User user) {

    Map<String, Object> response = new HashMap<>();

    // ✅ Already registered check
    Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

    if (existingUser.isPresent()) {
        response.put("success", false);
        response.put("message", "User already registered");
        return response;
    }

    // ✅ Save new user
    userRepository.save(user);
    response.put("success", true);
    response.put("message", "Registration successful");

    return response;
}


@PostMapping("/login")
public Map<String, Object> login(@RequestBody Map<String, String> data) {

    Map<String, Object> response = new HashMap<>();

    String email = data.get("email");
    String password = data.get("password");

    Optional<User> user = userRepository.findByEmail(email);

    if (user.isEmpty()) {
        response.put("success", false);
        response.put("message", "User not found");
        return response;
    }

    if (!user.get().getPassword().equals(password)) {
        response.put("success", false);
        response.put("message", "Invalid password");
        return response;
    }

    response.put("success", true);
    response.put("message", "Login successful");
    response.put("user", user.get());

    return response;
}
}
