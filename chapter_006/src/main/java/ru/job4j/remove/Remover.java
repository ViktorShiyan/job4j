package ru.job4j.remove;

import java.io.*;

/**
 * Класс описывающий удоление слов в потоке
 *
 * @author ViktorShiyan
 * @since 06.02.2019
 */
public class Remover {
    /**
     * Метод удоляющий слова в потоке
     *
     * @param in    входной поток
     * @param out   выходной поток
     * @param abuse массив слов для удоления
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out));
        try {
            String line = "";
            while (bufferedReader.ready()) {
                line = bufferedReader.readLine();
                for (String abuseWord : abuse) {
                    line = line.replace(abuseWord, "");
                }
            }
            bufferedWriter.write(line);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
