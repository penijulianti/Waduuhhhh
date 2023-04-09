package com.pub.course.controller;

import com.pub.course.dto.PeminjamanDto;
import com.pub.course.model.Admin;
import com.pub.course.model.Anggota;
import com.pub.course.model.Buku;
import com.pub.course.model.Peminjaman;
import com.pub.course.repository.AdminRepository;
import com.pub.course.repository.AnggotaRepository;
import com.pub.course.repository.BukuRepository;
import com.pub.course.repository.PeminjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peminjaman")
public class PeminjamanController {
    @Autowired
    PeminjamanRepository peminjamanRepository;
    @Autowired
    AnggotaRepository anggotaRepository;
    @Autowired
    BukuRepository bukuRepository;
    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/find-all")
    public Object findAll() {
        return peminjamanRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody PeminjamanDto peminjamanDto) {
        Admin adm = adminRepository.findById(peminjamanDto.getAdmin()).orElse(null);
        Anggota agt = anggotaRepository.findById(peminjamanDto.getAnggota()).orElse(null);
        Buku buku = bukuRepository.findById(peminjamanDto.getBuku()).orElse(null);
        
        if(agt == null|| adm == null || buku == null){
            return ResponseEntity.badRequest().body("Id Anggota / Id Buku salah");
        }else{
            Peminjaman pinj = new Peminjaman();
            pinj.setTgl_pinjam(peminjamanDto.getTglPinjam());
            pinj.setBatas_kembali(peminjamanDto.getBatasKembali());
            pinj.setAdmin(adm); // admin deklar pas login
            pinj.setAnggota(agt);
            pinj.setBuku(buku);
            pinj.setStatus(peminjamanDto.getStatus());
            return peminjamanRepository.save(pinj);
        }
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Integer id, @RequestBody PeminjamanDto peminjamanDto) {
        Admin adm = adminRepository.findById(peminjamanDto.getAdmin()).orElse(null);
        Anggota agt = anggotaRepository.findById(peminjamanDto.getAnggota()).orElse(null);
        Buku buku = bukuRepository.findById(peminjamanDto.getBuku()).orElse(null);
        if (agt == null) {
            return ResponseEntity.badRequest().body("Id Anggota tidak ditemukan!");
        }else if (buku == null) {
            return ResponseEntity.badRequest().body("Id Buku tidak ditemukan!");
        }else{
            Peminjaman pinj = peminjamanRepository.findById(id).orElse(null);
            pinj.setTgl_pinjam(peminjamanDto.getTglPinjam());
            pinj.setBatas_kembali(peminjamanDto.getBatasKembali());
            pinj.setTgl_kembali(peminjamanDto.getTglKembali());
            pinj.setAdmin(adm);
            pinj.setAnggota(agt);
            pinj.setBuku(buku);
            pinj.setStatus(peminjamanDto.getStatus());
            pinj.setDenda(peminjamanDto.getDenda());

            return peminjamanRepository.save(pinj);
        }
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Integer id) {
        Peminjaman pinj = peminjamanRepository.findById(id).orElse(null);
        if (pinj == null) {
            return ResponseEntity.badRequest().body("Id Peminjaman tidak ditemukan!");
        }else{
            peminjamanRepository.delete(pinj);
            return ResponseEntity.ok().body("Peminjaman Telah dihapus");
        }
    }

    @GetMapping("/find-by-pengenal/{pengenal}")
    public Object findByPengenalContains(@PathVariable String pengenal) {
        Anggota ag = anggotaRepository.findByPengenalContains(pengenal).orElse(null);
        return peminjamanRepository.findByAnggota(ag.getId());
    }

    // @GetMapping("/find-by-pengenal")
    // public Object findPeminjaman(@PathVariable String pengenal) {
    //     Anggota agt = anggotaRepository.findByPengenalContains(pengenal).orElse(null);
    //    // var pinj = peminjamanRepository.findByAnggotaId(agt.getId());
    //     if (agt == null) {
    //         return ResponseEntity.badRequest().body("Id Anggota tidak ditemukan!");
    //     }else{
    //         Integer id = agt.getId();
    //         // var pinj = peminjamanRepository.findByAnggotaId(agt.getId());

    //         // return ResponseEntity.ok().body(peminjamanRepository.findByAnggotaId(id));
    //         return peminjamanRepository.findByAnggotaId(id);
    //     }
    // // return null;
    // }
}