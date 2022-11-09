package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetTransactions {
    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/transactions-list")
    public ModelAndView getTransaction(){
        ModelAndView mv = new ModelAndView("transactions-list");
        mv.addObject("transactions", transactionService.getAllTransactions());
        return mv;
    }
}
