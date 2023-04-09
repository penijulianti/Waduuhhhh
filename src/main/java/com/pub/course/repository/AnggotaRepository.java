package com.pub.course.repository;

import java.util.Optional;
import com.pub.course.model.Anggota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnggotaRepository extends JpaRepository<Anggota, Integer> {
    public Optional<Anggota> findByPengenalContains(String pengenal);
}
