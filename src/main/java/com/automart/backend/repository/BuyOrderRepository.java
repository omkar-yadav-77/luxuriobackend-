package com.automart.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automart.backend.model.BuyOrder;

public interface BuyOrderRepository extends JpaRepository<BuyOrder, Integer> {
}
