package com.pub.course.controller;

import com.pub.course.dto.AdminDto;
import com.pub.course.model.Admin;
import com.pub.course.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/find-all")
    public Object findAll() {
        return adminRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody AdminDto adminDto) {
        Admin adm = new Admin();
        adm.setNama(adminDto.getNama());
        adm.setGender(adminDto.getGender());
        adm.setJabatan(adminDto.getJabatan());
        adm.setTgl_lahir(adminDto.getTgl_lahir());
        adm.setNoTelepon(adminDto.getNo_telp());
        adm.setAlamat(adminDto.getAlamat());
        return adminRepository.save(adm);

    }
    @PutMapping("/update/{id}")
    public Object update(@PathVariable Integer id, @RequestBody AdminDto adminDto) {
        Admin adm = adminRepository.findById(id).orElse(null);
        if (adm == null) {
            return ResponseEntity.badRequest().body("Id Admin tidak ditemukan!");
        }

        adm.setNama(adminDto.getNama());
        adm.setGender(adminDto.getGender());
        adm.setJabatan(adminDto.getJabatan());
        adm.setTgl_lahir(adminDto.getTgl_lahir());
        adm.setNoTelepon(adminDto.getNo_telp());
        adm.setAlamat(adminDto.getAlamat());
        return adminRepository.save(adm);
    }

    @DeleteMapping("/delete/{id}")
    public Object delete(@PathVariable Integer id) {
        Admin adm = adminRepository.findById(id).orElse(null);
        if (adm == null) {
            return ResponseEntity.badRequest().body("Id Admin tidak ditemukan!");
        }
        adminRepository.delete(adm);
        return null;
    }
}
