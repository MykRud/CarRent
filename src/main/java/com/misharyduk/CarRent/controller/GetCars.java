package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.model.Car;
import com.misharyduk.CarRent.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GetCars {
    @Autowired
    private CarService carService;

    @GetMapping("/cars-list")
    public ModelAndView getCars(){
        ModelAndView mv = new ModelAndView("cars-list");
        List<Car> cars = carService.getCars();
        mv.addObject("cars", cars);
        return mv;
    }
}
