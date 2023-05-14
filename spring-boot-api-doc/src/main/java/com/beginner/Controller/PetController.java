package com.beginner.Controller;

import com.beginner.dto.PetDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "Benim PET API dokümantasyonum.")
public class PetController {

    private List<PetDto> petList = new ArrayList<>();

    @PostConstruct
    public void init(){
        petList.add(new PetDto(1,"Test Pet", new Date()));
    }

    @PostMapping
    @ApiOperation(value = "Yeni Pet Ekleme Metodu", notes = "Bu metodu dikkatli kullan")
    public ResponseEntity<PetDto> kaydet(@RequestBody @ApiParam(value = "hayvan") PetDto petDto){
        petList.add(petDto);
        return ResponseEntity.ok(petDto);
    }

    @GetMapping
    @ApiOperation(value = "Pet listesi Metodu", notes = "Bu metod tümünü getirir")
    public ResponseEntity<List<PetDto>> tumunuListele() {

        return ResponseEntity.ok(petList);
    }
}
