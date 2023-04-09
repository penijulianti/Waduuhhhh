package com.pub.course.repository;

import com.pub.course.model.Anggota;
import com.pub.course.model.Peminjaman;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PeminjamanRepository extends JpaRepository<Peminjaman, Integer> {
    // // nampakin semua data user
    // @Query ("SELECT pe from Peminjaman pe WHERE pe.anggota=:id")
    public List<Peminjaman> findByAnggota(Integer id);

    // cari satu
    public Optional<Peminjaman> findByBukuId(Integer id);
}
