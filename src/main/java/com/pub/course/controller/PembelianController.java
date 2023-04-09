package com.pub.course.controller;

// import com.pub.course.dto.BukuDto;
import com.pub.course.dto.PembelianDto;
import com.pub.course.model.Admin;
import com.pub.course.model.Buku;
import com.pub.course.model.Pembelian;
import com.pub.course.repository.AdminRepository;
import com.pub.course.repository.BukuRepository;
import com.pub.course.repository.PembelianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembelian")
public class PembelianController {
    @Autowired
    PembelianRepository pembelianRepository;
    
    @Autowired
    AdminRepository adminRepository;
    
    @Autowired
    BukuRepository bukuRepository;

    @GetMapping("/find-all")
    public Object findAll() {
        return pembelianRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody PembelianDto pembelianDto) {

        Admin adm = adminRepository.findById(pembelianDto.getIdAdmin()).orElse(null);
        Buku bk = bukuRepository.findById(pembelianDto.getIdBuku()).orElse(null);
        
        Pembelian beli = new Pembelian();
        beli.setAdmin(adm);
        beli.setBuku(bk);
        beli.setJumlah(pembelianDto.getJumlah());
        beli.setHarga(pembelianDto.getJumlah()*bk.getHarga());
        beli.setTanggal(pembelianDto.getTanggal());
        bk.setStok(bk.getStok()-pembelianDto.getJumlah());
        bukuRepository.save(bk);
        return pembelianRepository.save(beli);
    }

    @PutMapping("/{id_beli}")
    public Object update(@PathVariable Integer id_beli, @RequestBody PembelianDto pembelianDto) {
        Pembelian beli = pembelianRepository.findById(id_beli).orElse(null);
        if (beli == null) {
            return ResponseEntity.badRequest().body("Id Pembelian tidak ditemukan!");
        }
        Admin adm = adminRepository.findById(pembelianDto.getIdAdmin()).orElse(null);
        Buku bk = bukuRepository.findById(pembelianDto.getIdBuku()).orElse(null);
        beli.setAdmin(adm);
        beli.setBuku(bk);
        beli.setJumlah(pembelianDto.getJumlah());
        beli.setHarga(pembelianDto.getJumlah()*bk.getHarga());
        beli.setTanggal(pembelianDto.getTanggal());
        bk.setStok(bk.getStok()-pembelianDto.getJumlah());
        return pembelianRepository.save(beli);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Integer id) {
        Pembelian beli = pembelianRepository.findById(id).orElse(null);
        if (beli == null) {
            return ResponseEntity.badRequest().body("Id Pembelian tidak ditemukan!");
        }else{
            pembelianRepository.delete(beli);
            return ResponseEntity.ok().body("Id Pembelian telah dihapus");
        }
    }
    
    @GetMapping("/find-by-tanggal/{tanggal}")
    public Object findTanggal(@PathVariable String tanggal) {
        return pembelianRepository.findByTanggal(tanggal);
    }
}
