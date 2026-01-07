package com.automart.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automart.backend.model.ContactMessage;

public interface ContactRepository extends JpaRepository<ContactMessage, Integer> {
}
