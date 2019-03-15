package ru.job4j.magnit;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс парсер xml
 *
 * @author viktorshiyan
 * @since 15.03.2019
 */
public class ParserXML {

    private List<Integer> list;

    public ParserXML() {
        this.list = new LinkedList<>();
        try {
            parse();
            System.out.print(calculateSum());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * метод включающий парсинг
     */
    public void parse() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();

        parser.parse(new File("converted.xml"), handler);
    }

    /**
     * Метод вычисляющий сумму
     *
     * @return сумму
     */
    public int calculateSum() {
        int sum = 0;
        for (Integer e : list) {
            sum += e;
        }
        return sum;
    }

    class MyHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            if (qName.equalsIgnoreCase("entry")) {
                String field = attributes.getValue("field");
                list.add(Integer.parseInt(field));
            }
        }
    }
}
