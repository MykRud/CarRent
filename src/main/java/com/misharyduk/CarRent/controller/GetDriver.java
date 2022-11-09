package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.model.Driver;
import com.misharyduk.CarRent.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetDriver {
    @Autowired
    private DriverService driverService;

    @GetMapping("/driver")
    public ModelAndView getDriver(@RequestParam int id){
        ModelAndView mv = new ModelAndView("driver-view");
        Driver driver = driverService.getDriver(id);
        mv.addObject("driver", driver);
        return mv;
    }
}
