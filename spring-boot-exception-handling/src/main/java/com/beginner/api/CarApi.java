package com.beginner.api;

import com.beginner.dto.Car;
import com.beginner.exception.EntitysNotFoundException;
import com.beginner.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarApi {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<Car> getCar(@RequestParam String name) {
        return ResponseEntity.ok(carService.getCar(name));
    }
    /*
    @ExceptionHandler({EntitysNotFoundException.class})
    public String entityNotFound() {
        return "Record not found";
    }*/

}
