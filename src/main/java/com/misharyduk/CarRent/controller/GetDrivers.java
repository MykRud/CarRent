package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.model.Driver;
import com.misharyduk.CarRent.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GetDrivers {
    @Autowired
    private DriverService driverService;

    @GetMapping("/drivers-list")
    public ModelAndView getDrivers(){
        ModelAndView mv = new ModelAndView("drivers-list");
        List<Driver> drivers = driverService.getDrivers();
        mv.addObject("drivers", drivers);
        return mv;
    }
}
