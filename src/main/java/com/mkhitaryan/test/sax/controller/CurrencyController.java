package com.mkhitaryan.test.sax.controller;

import com.mkhitaryan.test.sax.entity.Operation;
import com.mkhitaryan.test.sax.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @RequestMapping("/")
    public String openConverter(Model model) {
        currencyService.updateCurrencies();

        model.addAttribute("allCurrencies", currencyService.fillCurrencyDropdown());
        model.addAttribute("operation", new Operation());

        return "converter";
    }


}
