package com.pub.course.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PayloadPerpus {
    private String  nama, gender, tgalLahir, noTelp, alamat;
    private int noId;
}
