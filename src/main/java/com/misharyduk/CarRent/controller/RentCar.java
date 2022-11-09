package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.service.CarService;
import com.misharyduk.CarRent.service.DriverService;
import com.misharyduk.CarRent.service.EmployeeService;
import com.misharyduk.CarRent.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RentCar {
    @Autowired
    private DriverService driverService;
    @Autowired
    private CarService carService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/rent-car")
    public ModelAndView rentCar(@RequestParam(value = "error", required = false) String error){
        ModelAndView mv = new ModelAndView("car-rent");
        mv.addObject("drivers", driverService.getDrivers());
        mv.addObject("cars", carService.getCars());
        mv.addObject("employees", employeeService.getAllEmployee());
        mv.addObject("error", error);

        return mv;
    }

    @PostMapping("/rent-car")
    public ModelAndView rentCar(@RequestParam int car_id, @RequestParam int driver_id,
                                @RequestParam double distance, @RequestParam int employee_id){
        ModelAndView mv = new ModelAndView("redirect:/rent-car");
        boolean isRent = driverService.rentCar(driver_id, car_id, distance);
        mv.addObject("error", null);
        if(!isRent) {
            mv.addObject("error", "Оренда не може бути здійснена");
            return mv;
        }
        transactionService.saveTransaction(car_id, driver_id, distance, employee_id);
        mv.setViewName("redirect:/driver?id="+driver_id);
        return mv;
    }
}
