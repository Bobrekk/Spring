package com.beginner.api;

import com.beginner.entity.Kullanici;
import com.beginner.repository.KullaniciRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kullanici")
public class KullaniciApi {
    @Autowired
    private KullaniciRepository kullaniciRepository;

    @PostConstruct
    public void init(){
        Kullanici kullanici = new Kullanici();
        kullanici.setAd("Burak");
        kullanici.setSoyadi("Korkut");
        kullaniciRepository.save(kullanici);
    }

    @PostMapping
    public ResponseEntity<Kullanici> ekle(@RequestBody Kullanici kullanici){
        return ResponseEntity.ok(kullaniciRepository.save(kullanici));
    }

    @GetMapping
    public ResponseEntity<List<Kullanici>> tumunuListele() {
        return ResponseEntity.ok(kullaniciRepository.findAll());
    }
}
