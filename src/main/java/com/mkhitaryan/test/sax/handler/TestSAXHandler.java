package com.mkhitaryan.test.sax.handler;

import com.mkhitaryan.test.sax.entity.Currency;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Integer.parseInt;

public final class TestSAXHandler extends DefaultHandler {

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    private List<Currency> currencyList = new LinkedList<>();

    private String thisElement = null;
    private int currencyListIndex = 0;

    public TestSAXHandler(){}

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws SAXException {
        thisElement = qName;

        if (qName == "Valute") {
            currencyList.add(new Currency());
            currencyList.get(currencyListIndex).setId(atts.getValue(0));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length);

        if (value.length() != 0){
            if(thisElement == "NumCode"){
                currencyList.get(currencyListIndex).setNumcode(value);
            } else if (thisElement == "CharCode") {
                currencyList.get(currencyListIndex).setCharcode(value);
            } else if (thisElement == "Nominal") {
                currencyList.get(currencyListIndex).setNominal(parseInt(value));
            } else if (thisElement == "Name") {
                currencyList.get(currencyListIndex).setName(value);
            } else if (thisElement == "Value") {
                currencyList.get(currencyListIndex).setValue(new BigDecimal(value.replace(',','.')));
            }
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        if (qName == "Valute") {
            currencyListIndex++;
        }
    }

    public void clearEntityList(){
        currencyListIndex = 0;
        currencyList.clear();
    }
}
