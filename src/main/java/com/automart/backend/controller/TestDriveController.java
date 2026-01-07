package com.automart.backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automart.backend.model.TestDrive;
import com.automart.backend.repository.TestDriveRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class TestDriveController {

    @Autowired
    private TestDriveRepository repo;

    @PostMapping("/testdrive")
    public Map<String, String> bookTestDrive(@RequestBody TestDrive td) {

        repo.save(td);

        Map<String, String> res = new HashMap<>();
        res.put("message", "Test drive booked successfully");

        return res;
    }
}
