package com.pub.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PembelianDto {
    private Integer idAdmin;
    private Integer idBuku;
    private Integer jumlah;
    private Integer harga;
    private String tanggal;

}
