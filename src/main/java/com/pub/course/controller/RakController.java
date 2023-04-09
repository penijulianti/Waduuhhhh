package com.pub.course.controller;

import com.pub.course.dto.RakDto;
import com.pub.course.model.Rak;
import com.pub.course.repository.RakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rak")
public class RakController {
    @Autowired
    RakRepository rakRepository;

    @GetMapping("/find-all")
    public Object findAll() {
        return rakRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody RakDto rakDto) {
        Rak rak = new Rak();
        rak.setNama(rakDto.getNama());
        rak.setLocation(rakDto.getLocation());
        return rakRepository.save(rak);

    }
    @PutMapping("/{id}")
    public Object update(@PathVariable Integer id, @RequestBody RakDto rakDto) {
        Rak rak = rakRepository.findById(id).orElse(null);
        if (rak == null) {
            return ResponseEntity.badRequest().body("Id Rak tidak ditemukan!");
        }
        rak.setNama(rakDto.getNama());
        rak.setLocation(rakDto.getLocation());
        return rakRepository.save(rak);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Integer id) {
        Rak rak = rakRepository.findById(id).orElse(null);
        if (rak == null) {
            return ResponseEntity.badRequest().body("Id Rak tidak ditemukan!");
        }
        rakRepository.delete(rak);
        return null;
    }

    @GetMapping("/{nama}")
    public Object findByNamaContains(@PathVariable String nama) {
        var rak = rakRepository.findByNama(nama);
        if (rak == null) {
            return ResponseEntity.badRequest().body("Rak tidak ditemukan!");
        }else{
            return rakRepository.findByNama(nama);
        }
    }
}
