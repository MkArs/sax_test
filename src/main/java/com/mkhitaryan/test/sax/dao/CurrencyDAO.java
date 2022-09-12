package com.mkhitaryan.test.sax.dao;

import com.mkhitaryan.test.sax.entity.Currency;

import java.util.List;

public interface CurrencyDAO {
    public void updateCurrencies();
    public List<Currency> fillCurrencyDropdown();
}
