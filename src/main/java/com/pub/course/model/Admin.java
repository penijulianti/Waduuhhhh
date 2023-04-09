package com.pub.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin")
public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "gender", nullable = false,length = 1)
    private String gender;

    @Column(name = "jabatan", nullable = false)
    private String jabatan;

    @Column(name = "tgl_lahir", nullable = false)
    private String tgl_lahir;

    @Column(name = "no_telepon", length = 15)
    private String noTelepon;

    @Column(name = "alamat", nullable = false)
    private String alamat;
}
