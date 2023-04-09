package com.pub.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeminjamanDto {
    private String tglPinjam;
    private String batasKembali;
    private String tglKembali;
    private Integer admin;
    private Integer anggota;
    private Integer buku;
    private String status;
    private Integer denda;
}
