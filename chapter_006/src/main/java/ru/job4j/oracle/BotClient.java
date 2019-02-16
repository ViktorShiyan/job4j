package ru.job4j.oracle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Класс реализующий клиента для работы с ботом ораклом
 *
 * @author ViktorShiyan
 * @since 13.02.2019
 */
public class BotClient {
    private Socket socket;

    public BotClient(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
    }

    /**
     * Меотод запускающий клиента
     *
     * @throws IOException ошибка ввода вывода
     */
    public void run() throws IOException {
        String userAsk;
        String botAnswer;
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner console = new Scanner(System.in)) {
            do {
                userAsk = console.nextLine();
                out.println(userAsk);
                botAnswer = in.readLine();
                System.out.println(botAnswer);
            } while (!userAsk.equals("exit"));
        }
    }

    public static void main(String[] args) throws IOException {
        BotClient client = new BotClient("127.0.0.1", 4242);
        client.run();
    }
}