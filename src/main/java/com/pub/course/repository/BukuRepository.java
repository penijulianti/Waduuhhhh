package com.pub.course.repository;

import com.pub.course.model.Buku;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BukuRepository extends JpaRepository<Buku, Integer> {
    @Query ("SELECT bu from Buku bu WHERE bu.judul LIKE %:judul%")
    public List<Buku> findByJudul(String judul);
    
    public Optional<Buku> findByJudulContains(String judul);

    public List<Buku> findByPenulis(String penulis);
}
