package ru.job4j.pack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Класс для архивирования файлов с определенным расширением
 */
public class Ziper {
    /**
     * Метод архивирует выбранные файлы из определеной директории
     *
     * @param args массив с аргументами
     */
    public static void main(String[] args) {
        Ziper ziper = new Ziper();
        ziper.run(args);
    }

    public void run(String[] args) {
        Args argsSplit = new Args(args);
        SearchFiles searchFiles = new SearchFiles();
        List<String> listFilesPath = searchFiles.findFilesList(argsSplit.directory(), argsSplit.exclude());
        try {
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(argsSplit.output()));
            for (String fileName : listFilesPath) {
                FileInputStream fis = new FileInputStream(fileName);
                ZipEntry entry1 = new ZipEntry(fileName);
                zout.putNextEntry(entry1);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }
}
