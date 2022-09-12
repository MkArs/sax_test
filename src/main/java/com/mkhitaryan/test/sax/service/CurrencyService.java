package com.mkhitaryan.test.sax.service;

import com.mkhitaryan.test.sax.entity.Currency;

import java.util.List;

public interface CurrencyService {
    public void updateCurrencies();
    public List<Currency> fillCurrencyDropdown();
}
