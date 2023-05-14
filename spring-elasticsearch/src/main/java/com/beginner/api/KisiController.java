package com.beginner.api;

import java.util.Calendar;
import java.util.List;
import com.beginner.entity.Kisi;
import com.beginner.repository.KisiRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kisi")
public class KisiController {

    @Autowired
    public final KisiRepository kisiRepository;

    @PostConstruct
    public void init(){
        Kisi kisi = new Kisi();
        kisi.setAd("Burak");
        kisi.setSoyad("Korkut");
        kisi.setAdres("test");
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        kisi.setId("0001");
        kisiRepository.save(kisi);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
        List<Kisi> kisiler = kisiRepository.findByAdLikeOrSoyadLike(search, search);
        return ResponseEntity.ok(kisiler);
    }
}
