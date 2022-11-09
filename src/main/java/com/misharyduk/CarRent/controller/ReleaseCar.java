package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReleaseCar {

    @Autowired
    private CarService carService;

    @GetMapping("/release-car")
    public ModelAndView releaseCar(){
        ModelAndView mv = new ModelAndView("car-release");
        mv.addObject("cars", carService.getCars());
        return mv;
    }

    @PostMapping("/release-car")
    public String releaseCar(@RequestParam int car_id){
        carService.releaseCar(car_id);
        return "redirect:/car?id="+car_id;
    }

}
