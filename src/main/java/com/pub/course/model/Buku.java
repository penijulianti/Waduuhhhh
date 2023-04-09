package com.pub.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="buku")
@Entity
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id",nullable = false)
    private Integer id;

    @Column(name = "judul",nullable = false)
    private String judul;

    @Column(name = "jenis",nullable = false)
    private String jenis;

    @Column(name = "penulis",nullable = false)
    private String penulis;

    @Column(name = "penerbit",nullable = false)
    private String penerbit;
    
    @Column(name = "harga", nullable = false)
    private Integer harga;

    @Column(name = "stok", nullable = false)
    private Integer stok;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rak", referencedColumnName = "id")
    private Rak rak;
}
