package com.automart.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automart.backend.model.Admin;
import com.automart.backend.model.BuyOrder;
import com.automart.backend.model.TestDrive;
import com.automart.backend.repository.AdminRepository;
import com.automart.backend.repository.BuyOrderRepository;
import com.automart.backend.repository.TestDriveRepository;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private BuyOrderRepository buyRepo;

    @Autowired
    private TestDriveRepository testRepo;

    // 🔐 LOGIN
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> data) {

        Map<String, Object> response = new HashMap<>();

        String email = data.get("email");
        String password = data.get("password");

        Optional<Admin> admin = adminRepo.findByEmail(email);

        if (admin.isEmpty()) {
            response.put("success", false);
            response.put("message", "Admin not found");
            return response;
        }

        if (!admin.get().getPassword().equals(password)) {
            response.put("success", false);
            response.put("message", "Invalid password");
            return response;
        }

        response.put("success", true);
        response.put("message", "Login successful");
        response.put("user", admin.get());

        return response;
    }

    // 📦 BUY ORDERS
    @GetMapping("/buy_orders")
    public List<BuyOrder> getOrders() {
        return buyRepo.findAll();
    }

    // 🚗 TEST DRIVES
    @GetMapping("/testdrive")
    public List<TestDrive> getTestDrives() {
        return testRepo.findAll();
    }
}
