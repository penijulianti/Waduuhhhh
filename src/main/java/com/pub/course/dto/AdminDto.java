package com.pub.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
    private String nama;
    private String gender;
    private String jabatan;
    private String tgl_lahir;
    private String no_telp;
    private String alamat;
}
