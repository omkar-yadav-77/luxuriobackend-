package com.automart.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automart.backend.model.BuyOrder;
import com.automart.backend.repository.BuyOrderRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class BuyController {

    @Autowired
    private BuyOrderRepository buyRepository;

    @PostMapping("/buyorder")
    public BuyOrder placeOrder(@RequestBody BuyOrder order) {
        return buyRepository.save(order);
    }

    // 🔑 Admin sाठी
    @GetMapping("/all")
    public java.util.List<BuyOrder> getAllOrders() {
        return buyRepository.findAll();
    }
}
