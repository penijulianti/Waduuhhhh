package com.pub.course.repository;

import com.pub.course.model.Admin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    public Optional<Admin> findByNamaContains(String nama);
}
