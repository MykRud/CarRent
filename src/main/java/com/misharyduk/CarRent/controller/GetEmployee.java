package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.service.EmployeeService;
import com.misharyduk.CarRent.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetEmployee {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/employee")
    public ModelAndView getEmployee(@RequestParam int id){
        ModelAndView mv = new ModelAndView("employee-view");
        mv.addObject("employee", employeeService.getEmployee(id));
        return mv;
    }
}
