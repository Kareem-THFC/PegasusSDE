package com.example.SpringBootPegasus.Controllers;

import com.example.SpringBootPegasus.Entities.car;
import com.example.SpringBootPegasus.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/car")
@CrossOrigin(origins = "http://127.0.0.1:5501/")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService =  carService;
    }

    @GetMapping
    public List<car> getCar() {
        return carService.getCar();
    }
    @PostMapping
    public void registerNewcar(@RequestBody car car1) {
        carService.addNewcar(car1);
        }

    @DeleteMapping(path = "{carid}")
        public void deletecar(@PathVariable("carid")Long carid) {
            carService.deletecar(carid);
    }
    @PutMapping(path = "{carid}")
    public void updatecar(
            @PathVariable("carid")Long carid,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) int dailyRate
    )
        {
            carService.updatecar(carid,model,brand,color,dailyRate);}
    }



