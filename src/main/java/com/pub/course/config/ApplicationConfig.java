package com.pub.course.config;

import com.pub.course.payload.Perpustakaan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public Perpustakaan
    daftarSiswa(){
        return new Perpustakaan();
    }

}
