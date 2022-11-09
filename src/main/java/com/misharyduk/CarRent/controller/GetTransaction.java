package com.misharyduk.CarRent.controller;

import com.misharyduk.CarRent.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetTransaction {
    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/transaction")
    public ModelAndView getTransaction(@RequestParam int id){
        ModelAndView mv = new ModelAndView("transaction-view");
        mv.addObject("transaction", transactionService.getTransactionById(id));
        return mv;
    }
}
