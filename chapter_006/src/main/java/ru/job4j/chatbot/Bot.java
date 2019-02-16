package ru.job4j.chatbot;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Чат бот отвечающий случайной фразой из файла
 *
 * @author ViktorShiyan
 * @since 12.02.2019
 */
public class Bot {
    public static void main(String[] args) {
        Bot bot = new Bot();
        bot.dialog();
    }

    /**
     * Метод для ведения диалога с ботом
     */
    public void dialog() {
        boolean run = true;
        boolean mute = false;
        Scanner scanner = new Scanner(System.in);
        while (run) {
            String ask = scanner.nextLine();
            if ("закончить".equals(ask)) {
                log(ask);
                run = false;
            } else if ("стоп".equals(ask)) {
                log(ask);
                mute = true;
            } else if ("продолжить".equals(ask)) {
                log(ask);
                mute = false;
            } else {
                log(ask);
                if (!mute) {
                    String answer = botAnswer(new File("answer.txt"));
                    log(answer);
                    System.out.println(answer);
                }
            }
        }
    }

    /**
     * Метод возвращает случайный ответ бота из файла
     *
     * @return строка с ответом
     */
    private String botAnswer(File f) {
        String result = null;
        try {
            Random rand = new Random();
            int n = 0;
            for (Scanner sc = new Scanner(f); sc.hasNext(); ) {
                ++n;
                String line = sc.nextLine();
                if (rand.nextInt(n) == 0) {
                    result = line;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }


    /**
     * Метод для записи в файл лога
     *
     * @param logText записываеммые слова в лог
     */
    private void log(String logText) {
        try (FileWriter writer = new FileWriter("logBot.txt", true)) {
            writer.write(logText + System.lineSeparator());
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
