package com.pub.course.controller;

import com.pub.course.dto.AnggotaDto;
import com.pub.course.model.Anggota;
import com.pub.course.repository.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anggota")
public class AnggotaController {
    @Autowired
    AnggotaRepository anggotaRepository;

    @GetMapping("/find-all")
    public Object findAll() {
        return anggotaRepository.findAll();
    }

    // post data di register 
    @PostMapping("/")
    public Object create(@RequestBody AnggotaDto anggotaDto) {
        Anggota ang = new Anggota();
        ang.setPengenal(anggotaDto.getPengenal());
        ang.setNama(anggotaDto.getNama()); 
        ang.setGender(anggotaDto.getGender());
        ang.setTgl_lahir(anggotaDto.getTgl_lahir());
        ang.setNoTelepon(anggotaDto.getNo_telp());
        ang.setAlamat(anggotaDto.getAlamat());
        return anggotaRepository.save(ang);
    }

    // update data di admin bagian anggota
    @PutMapping("/{pengenal}")
    public Object update(@PathVariable String pengenal, @RequestBody AnggotaDto anggotaDto) {
        Anggota ang = anggotaRepository.findByPengenalContains(pengenal).orElse(null);
        if (ang == null) {
            return ResponseEntity.badRequest().body("Id Admin tidak ditemukan!");
        }
        ang.setPengenal(anggotaDto.getPengenal());
        ang.setNama(anggotaDto.getNama());
        ang.setGender(anggotaDto.getGender());
        ang.setTgl_lahir(anggotaDto.getTgl_lahir());
        ang.setNoTelepon(anggotaDto.getNo_telp());
        ang.setAlamat(anggotaDto.getAlamat());
        return anggotaRepository.save(ang);
    }
}
