package ru.job4j.pack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс для поиска файлов подходящих по параметру exclude
 *
 * @author ViktorShiyan
 * @since 12.02.2019
 */
public class SearchFiles {
    private final List<String> listWithFileNames = new ArrayList<>();

    /**
     * Метод возращающий список файлов по указаному фильтру
     * и в выбранной директории
     *
     * @return список подходящих файлов
     */
    public List<String> findFilesList(String directory, String[] exclude) {
        File f = new File(directory);
        for (File fl : Objects.requireNonNull(f.listFiles())) {
            if (fl.isDirectory()) {
                this.findFilesList(fl.getAbsolutePath(), exclude);
            } else {
                for (String excl : exclude) {
                    if (fl.getAbsolutePath().contains(excl)) {
                        this.listWithFileNames.add(fl.getAbsolutePath());
                    }
                }
            }
        }
        return listWithFileNames;
    }
}
