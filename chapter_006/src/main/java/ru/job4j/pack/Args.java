package ru.job4j.pack;


import java.util.ArrayList;

/**
 * Класс служащий для получения аргументов
 *
 * @author ViktorShiyan
 * @since 09.02.2019
 */
public class Args {
    /**
     * аргументы для работы программы
     */
    private String[] args;

    /**
     * Канструктор
     *
     * @param args аргументы для запуска приложения
     */
    public Args(String[] args) {
        this.args = args;
    }


    /**
     * метод возвращающий директорию для сжатия
     *
     * @return директория
     */
    public String directory() {
        String directory = "";
        for (int i = 0; i < this.args.length; i++) {
            if (this.args[i].equals("-d") && !this.args[i + 1].startsWith("-")) {
                directory = this.args[i + 1];
                break;
            }
        }
        return directory;
    }

    /**
     * метод возвращающий имя файла архива
     *
     * @return имя файла
     */
    public String output() {
        String nameFile = "";
        for (int i = 0; i < this.args.length; i++) {
            if (this.args[i].equals("-o") && !this.args[i + 1].startsWith("-")) {
                nameFile = this.args[i + 1];
                break;
            }
        }
        return nameFile;
    }

    /**
     * метод возвращающий имя файла архива
     *
     * @return имя файла
     */
    public String[] exclude() {
        ArrayList<String> arrayAxclude = new ArrayList<>();
        for (int i = 0; i < this.args.length; i++) {
            if (this.args[i].equals("-e") && !this.args[i + 1].startsWith("-")) {
                for (int j = i + 1; j < this.args.length; j++) {
                    if (this.args[j].startsWith("-")) {
                        break;
                    }
                    arrayAxclude.add(this.args[j]);
                }
            }
        }
        return arrayAxclude.toArray(new String[arrayAxclude.size()]);
    }

}
