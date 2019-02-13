package ru.job4j.oracle;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Тест для проверки работы сервера
 *
 * @author ViktorShiyan
 * @since 13.02.2019
 */
public class BotServerTest {
    String ln = System.lineSeparator();

    @Test
    public void whenSayHello() {
        String inStr = Joiner.on(ln).join(
                "hello",
                "exit"
        );
        String outStr = Joiner.on(ln).join(
                "Hello, dear friend, I'm a oracle.",
                "bye bye\r\n"
        );
        serverTest(inStr, outStr);
    }

    @Test
    public void whenSaySomething() {
        String inStr = Joiner.on(ln).join(
                "something",
                "exit"
        );
        String outStr = Joiner.on(ln).join(
                "No idea ...",
                "bye bye\r\n"
        );
        serverTest(inStr, outStr);
    }

    @Test
    public void whenSayExit() {
        String inStr = "exit";
        String outStr = "bye bye\r\n";
        serverTest(inStr, outStr);
    }

    public void serverTest(String inputString, String outputString) {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        try {
            when(socket.getInputStream()).thenReturn(inputStream);
            when(socket.getOutputStream()).thenReturn(outputStream);
            BotServer server = new BotServer(socket);
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(outputStream.toString(), is(outputString));
    }

}