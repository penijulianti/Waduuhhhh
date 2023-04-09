package com.pub.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="rak")
@Entity
public class Rak {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column( name = "id",nullable = false)
        private Integer id;

        @Column(name = "nama",nullable = false)
        private String nama;

        @Column(name = "location",nullable = false)
        private String location;
}
