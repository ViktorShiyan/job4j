package ru.job4j.magnit;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Класс для конвертирования  xsqt
 *
 * @author viktorshiyan
 * @since 15.03.2019
 */
public class ConvertXSQT {

    /**
     * метод конвертации
     *
     * @param source входной файл
     * @param dest   файл назначения
     * @param scheme схема
     * @throws TransformerException ошибка тконвертации
     */
    public void convert(File source, File dest, File scheme) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(
                new StreamSource(scheme));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
        transformer.transform(new StreamSource(source),
                new StreamResult(dest)
        );
    }
}

