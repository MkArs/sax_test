package com.mkhitaryan.test.sax;

import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;

public class Test {
    public void begin(){
        SOAPMessage soapMessage = null;
        try {
            soapMessage = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage();
            SOAPPart part = soapMessage.getSOAPPart();
            SOAPEnvelope envelope = part.getEnvelope();
            SOAPBody body = envelope.getBody();
            Name bodyName = envelope.createName("AllDataInfoXML", null, "http://web.cbr.ru/");
            body.addBodyElement(bodyName);
            soapMessage.saveChanges();
            System.out.println(soapMessage); //

            //Отправка сообщения и получение ответа
            //Установка адресата
            String destination = "http://www.cbr.ru/DailyInfoWebServ/DailyInfo.asmx";
            //Отправка
            SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = soapConnFactory.createConnection();
            SOAPMessage reply = connection.call(soapMessage, destination);

            //ответ
            //Проверка полученного ответа
            System.out.println("\nRESPONSE:\n");
            //Создание XSLT-процессора
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = null;
            try {
                transformer = transformerFactory.newTransformer();
            } catch (TransformerConfigurationException e) {
                throw new RuntimeException(e);
            }
            //Получение содержимого ответа
            Source sourceContent = reply.getSOAPPart().getContent();
            //Задание выходного потока для результата преобразования
            StreamResult result = new StreamResult(System.out);
            try {
                transformer.transform(sourceContent, result);
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            }
        } catch (SOAPException e) {
            throw new RuntimeException(e);
        }
    }
}
