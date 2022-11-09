package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetAllEmployees {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees-list")
    public ModelAndView getEmployees(){
        ModelAndView mv = new ModelAndView("employees-list");
        mv.addObject("employees", employeeService.getAllEmployee());
        return mv;
    }
}
