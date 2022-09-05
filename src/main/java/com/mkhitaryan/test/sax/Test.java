package com.mkhitaryan.test.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Test {
    public void begin(){
        String url = "https://www.cbr.ru/scripts/XML_daily.asp";
            //SAX парсер
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            TestSAXHandler handler = new TestSAXHandler();
            parser.parse(url, handler);
            System.out.println("SAX parser result:\n" + handler.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
