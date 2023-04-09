package com.pub.course.repository;

import com.pub.course.model.Rak;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RakRepository extends JpaRepository<Rak, Integer> {
    public Optional<Rak> findByNamaContains(String nama);
    
    @Query ("SELECT rak from Rak rak WHERE rak.nama LIKE %:nama%")
    public List<Rak> findByNama(String nama);
}