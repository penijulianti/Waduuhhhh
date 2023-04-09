package com.pub.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnggotaDto {
    private String username;
    private String password;
    private String pengenal;
    private String nama;
    private String gender;
    private String tgl_lahir;
    private String no_telp;
    private String alamat;
}
