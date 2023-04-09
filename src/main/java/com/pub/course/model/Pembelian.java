package com.pub.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pembelian")
public class Pembelian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_admin", referencedColumnName = "id")
    private Admin admin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_buku", referencedColumnName = "id")
    private Buku buku;

    @Column(name = "jumlah", nullable = false)
    private Integer jumlah;
    
    @Column(name = "harga", nullable = false)
    private Integer harga;

    @Column(name = "tanggal", nullable = false)
    private String tanggal;
}
