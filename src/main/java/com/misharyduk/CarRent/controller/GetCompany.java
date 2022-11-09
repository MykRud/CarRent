package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.model.Company;
import com.misharyduk.CarRent.service.CarService;
import com.misharyduk.CarRent.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetCompany {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/company")
    public ModelAndView getCompany(){
        ModelAndView mv = new ModelAndView("company-view");
        Company company = companyService.getCompany();
        mv.addObject("company", company);
        return mv;
    }
}
