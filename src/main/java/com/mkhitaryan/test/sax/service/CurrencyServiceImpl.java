package com.mkhitaryan.test.sax.service;

import com.mkhitaryan.test.sax.dao.CurrencyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CurrencyServiceImpl implements CurrencyService{
    @Autowired
    private CurrencyDAO currencyDAO;
    @Override
    @Transactional(transactionManager = "transactionManager")
    public void updateCurrencies() {
        currencyDAO.updateCurrencies();
    }
}
