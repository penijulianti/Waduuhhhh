package com.pub.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "anggota")
public class Anggota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username")
    private Integer username;

    @Column(name = "password")
    private Integer password;

    @Column(name = "pengenal")
    private String pengenal;

    @Column(name = "nama")
    private String nama;

    @Column(name = "gender",length = 1)
    private String gender;

    @Column(name = "tgl_lahir")
    private String tgl_lahir;

    @Column(name = "no_telepon")
    private String noTelepon;

    @Column(name = "alamat")
    private String alamat;

}
