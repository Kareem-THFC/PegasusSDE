package com.example.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/car")
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
@DeleteMapping(path = "carid")
    public void deletecar(@PathVariable("carid")Long carid) {
        carService.deletecar(carid);


}@PutMapping(path = "carid")
public void updatecar(
        @PathVariable("carid")Long carid,
        @RequestParam(required = false) String model)

    {
        carService.updatecar(carid,model);
    }

}



