package ru.job4j.oracle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Клаас релизующий работу сервера
 *
 * @author ViktorShiyan
 * @since 13.02.2019
 */
public class BotServer {
    private Socket socket;

    public BotServer(Socket socket) {
        this.socket = socket;
    }

    /**
     * Метод запускающий сервер
     *
     * @throws IOException ошибка ввода вывода
     */
    public void run() throws IOException {
        String ask;

        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                if ("hello".equals(ask)) {
                    out.println("Hello, dear friend, I'm a oracle.");
                } else if ("ready?".equals(ask)) {
                    out.println("Yes, lets go!");
                } else if ("exit".equals(ask)) {
                    out.println("bye bye");
                } else {
                    out.println("No idea ...");
                }
            } while (!"exit".equals(ask));
        }
    }

    public static void main(String[] args) throws IOException {
        try (Socket socket = new ServerSocket(4242).accept()) {
            BotServer server = new BotServer(socket);
            server.run();
        }


    }

}