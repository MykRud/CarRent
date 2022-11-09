package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteCar {
    @Autowired
    private CarService carService;

    @GetMapping("/delete-car/{id}")
    private String deleteCar(@PathVariable int id){
        carService.deleteCar(id);
        return "redirect:/car/list";
    }
}
