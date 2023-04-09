package com.pub.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "peminjaman")
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "tgl_pinjam")
    private String tgl_pinjam;

    @Column(name = "batas_kembali")
    private String batas_kembali;

    @Column(name = "tgl_kembali")
    private String tgl_kembali;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin", referencedColumnName = "id")
    private Admin admin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "anggota", referencedColumnName = "id")
    private Anggota anggota;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buku", referencedColumnName = "id")
    private Buku buku;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "denda")
    private Integer denda;
}