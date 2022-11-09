package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.model.Car;
import com.misharyduk.CarRent.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddCar {
    @Autowired
    private CarService carService;

    @GetMapping("/add-car")
    public ModelAndView addCarView(){
        ModelAndView mv = new ModelAndView("add-car");
        mv.addObject("car", new Car());
        return mv;
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car){
        boolean isAdded = carService.addCar(car);
        Car foundCar = carService.getCarByNumber(car.getCarNumber());
        return "redirect:/car?id="+foundCar.getId();
    }

}
