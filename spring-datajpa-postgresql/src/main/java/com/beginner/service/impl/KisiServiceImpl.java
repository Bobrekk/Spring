package com.beginner.service.impl;

import com.beginner.dto.KisiDto;
import com.beginner.entity.Adres;
import com.beginner.entity.Kisi;
import com.beginner.repo.AdresRepository;
import com.beginner.repo.KisiRepository;
import com.beginner.service.KisiService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {

    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;
    @Override
    @Transactional
    public KisiDto save(KisiDto kisiDto) {
        //Assert.isNull(kisiDto.getAdi(), "Adi alani zorunludur!");
        Kisi kisi = new Kisi();
        kisi.setAdi(kisiDto.getAdi());
        kisi.setSoyadi(kisi.getSoyadi());
        final Kisi kisiDb = kisiRepository.save(kisi);
        List<Adres> liste = new ArrayList<>();

        kisiDto.getAdresler().forEach(item -> {
            Adres adres = new Adres();
            adres.setAdres(item);
            adres.setAdresTip(Adres.AdresTip.DIGER);
            adres.setAktif(true);
            adres.setKisi(kisiDb);
            liste.add(adres);
        });
        adresRepository.saveAll(liste);
        kisiDto.setId(kisiDb.getId());
        return kisiDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<KisiDto> getAll() {
        List<Kisi> kisiler = kisiRepository.findAll();
        List<KisiDto> kisiDtos = new ArrayList<>();
        kisiler.forEach(it -> {
            KisiDto kisiDto = new KisiDto();
            kisiDto.setId(it.getId());
            kisiDto.setAdi(it.getAdi());
            kisiDto.setSoyadi(it.getSoyadi());
            kisiDto.setAdresler(it.getAdresler().stream().map(Adres::getAdres)
                    .collect(Collectors.toList()));
            kisiDtos.add(kisiDto);
        });
        return kisiDtos;
    }

    @Override
    public Page<KisiDto> getAll(Pageable pageable) {
        return null;
    }
}