package com.pub.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BukuDto {
    private String judul;
    private String jenis;
    private String penulis;
    private String penerbit;
    private Integer harga;
    private Integer stok;
    private Integer id_rak;
}
