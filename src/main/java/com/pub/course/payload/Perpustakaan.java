package com.pub.course.payload;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Perpustakaan {
    List <PayloadPerpus> perpusList = new ArrayList<>();
}
