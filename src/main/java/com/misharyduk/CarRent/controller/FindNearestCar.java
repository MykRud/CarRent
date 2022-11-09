package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FindNearestCar {
    @Autowired
    private CarService carService;

    @RequestMapping("/find-nearest-car")
    public ModelAndView findNearestCar(){
        return new ModelAndView("redirect:/car?id="+carService.findNearestCar().getId());
    }
}
