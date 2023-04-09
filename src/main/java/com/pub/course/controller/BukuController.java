package com.pub.course.controller;


import com.pub.course.dto.BukuDto;
import com.pub.course.model.Buku;
import com.pub.course.model.Rak;
import com.pub.course.repository.BukuRepository;
import com.pub.course.repository.RakRepository;

import lombok.var;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buku")
public class BukuController {
    @Autowired
    BukuRepository bukuRepository;
    
    @Autowired
    RakRepository rakRepository;

    @GetMapping("/find-all")
    public Object findAll() {
        return bukuRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody BukuDto bukuDto) {
        Rak rak = rakRepository.findById(bukuDto.getId_rak()).orElse(null);
        Buku buku = new Buku();
        buku.setJudul(bukuDto.getJudul());
        buku.setJenis(bukuDto.getJenis());
        buku.setPenulis(bukuDto.getPenulis());
        buku.setPenerbit(bukuDto.getPenerbit());
        buku.setHarga(bukuDto.getHarga());
        buku.setStok(bukuDto.getStok());
        buku.setRak(rak);
        return bukuRepository.save(buku);
    }

    @PutMapping("/update/{id_buku}")
    public Object update(@PathVariable Integer id_buku, @PathVariable Integer id, @RequestBody BukuDto bukuDto) {
        Buku buku = bukuRepository.findById(id_buku).orElse(null);
        if (buku == null) {
            return ResponseEntity.badRequest().body("Id Buku tidak ditemukan!");
        }
        Rak rak = rakRepository.findById(id).orElse(null);
        buku.setJudul(bukuDto.getJudul());
        buku.setJenis(bukuDto.getJenis());
        buku.setPenulis(bukuDto.getPenulis());
        buku.setPenerbit(bukuDto.getPenerbit());
        buku.setHarga(bukuDto.getHarga());
        buku.setStok(bukuDto.getStok());
        buku.setRak(rak);
        return bukuRepository.save(buku);
    }

    @PutMapping("/pinjam-stok/{id}")
    public Object updet(@PathVariable Integer id) {
        Buku buku = bukuRepository.findById(id).orElse(null);
        if (buku == null) {
            return ResponseEntity.badRequest().body("Id Buku tidak ditemukan!");
        }
        
        buku.setStok(buku.getStok()-1);

        return bukuRepository.save(buku);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Integer id) {
        Buku buku = bukuRepository.findById(id).orElse(null);
        if (buku == null) {
            return ResponseEntity.badRequest().body("Id Buku tidak ditemukan!");
        }else{
            bukuRepository.delete(buku);
            return ResponseEntity.ok().body("Data Buku Telah Dihapus");
        }
    }

    @GetMapping("/find-by-judul/{judul}")
    public Object findByJudul(@RequestParam("judul") String judul) {
        var buku = bukuRepository.findByJudul(judul);
        if (buku == null) {
            return ResponseEntity.badRequest().body("Data Buku tidak ditemukan !");
        }
        return bukuRepository.findByJudul(judul);
    }

    @GetMapping("/find-by-penulis/{penulis}")
    public Object findByPenulis(@RequestParam String penulis) {
    var buku_penulis = bukuRepository.findByPenulis(penulis);
        if (buku_penulis == null) {
            return ResponseEntity.badRequest().body("Data Buku tidak ditemukan !");
        }
        return bukuRepository.findByPenulis(penulis);
    }
}
