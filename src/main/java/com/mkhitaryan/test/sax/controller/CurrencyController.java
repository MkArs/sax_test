package com.mkhitaryan.test.sax.controller;

import com.mkhitaryan.test.sax.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @RequestMapping("/converter")
    public String openConverter(){
        currencyService.updateCurrencies();
        return "converter";
    }

}
