package com.mkhitaryan.test.sax.dao;

import com.mkhitaryan.test.sax.TestSAXHandler;
import com.mkhitaryan.test.sax.entity.Currency;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

@Repository
public class CurrencyDAOImpl implements CurrencyDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void updateCurrencies() {
        String url = "https://www.cbr.ru/scripts/XML_daily.asp";
        //SAX парсер
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            TestSAXHandler handler = new TestSAXHandler();
            parser.parse(url, handler);

            Session session = sessionFactory.getCurrentSession();

            for (Currency currency:
                 handler.getCurrencyList()) {
                session.saveOrUpdate(currency);
            }

            handler.clearEntityList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Currency> fillCurrencyDropdown() {
        Session session = sessionFactory.getCurrentSession();
        List<Currency> allCurrencies = session.createQuery("from currencies", Currency.class).getResultList();
        return allCurrencies;
    }
}

