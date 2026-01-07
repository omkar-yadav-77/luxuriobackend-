package com.automart.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automart.backend.model.TestDrive;

public interface TestDriveRepository extends JpaRepository<TestDrive, Integer> {
}
