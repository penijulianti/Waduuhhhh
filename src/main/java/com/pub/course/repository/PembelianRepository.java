package com.pub.course.repository;

import com.pub.course.model.Pembelian;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PembelianRepository extends JpaRepository<Pembelian, Integer> {
    public List<Pembelian> findByTanggal(String tanggal);
}
