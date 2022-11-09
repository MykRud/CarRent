package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.model.CreditCard;
import com.misharyduk.CarRent.model.Driver;
import com.misharyduk.CarRent.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterDriver {
    @Autowired
    private DriverService driverService;

    @GetMapping("/driver-register")
    public ModelAndView registerDriverView(){
        ModelAndView mv = new ModelAndView("register-driver");
        mv.addObject("driver", new Driver());
        return mv;
    }

    @PostMapping("/driver-register")
    public ModelAndView registerDriver(@ModelAttribute Driver driver,
                                       @RequestParam("cardNumber") int cardNumber,
                                       @RequestParam("expMonth") int expMonth,
                                       @RequestParam("expYear") int expYear,
                                       @RequestParam("bankSystem") String bankSystem){
        CreditCard creditCard = new CreditCard();
        creditCard.setNumberOfCard(cardNumber);
        creditCard.setExpMonth(expMonth);
        creditCard.setExpYear(expYear);
        creditCard.setBankSystem(bankSystem);
        driver.setCreditCard(creditCard);
        driverService.addDriver(driver);

        return new ModelAndView("redirect:/driver-register");
    }
}
