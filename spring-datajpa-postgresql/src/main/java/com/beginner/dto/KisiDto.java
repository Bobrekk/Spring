package com.beginner.dto;

import com.beginner.entity.Adres;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class KisiDto {
    private Long id;

    private String adi;

    private String soyadi;

    private List<String> adresler;
}
