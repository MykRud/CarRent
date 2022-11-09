package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.service.CarService;
import com.misharyduk.CarRent.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteDriver {
    @Autowired
    private DriverService driverService;

    @GetMapping("/delete-driver/{id}")
    public String deleteDriver(@PathVariable int id){
        driverService.deleteDriver(id);
        return "redirect:/driver/list";
    }
}
