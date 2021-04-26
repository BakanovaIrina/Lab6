package client;

import another.console.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс, считывающий ввод пользователя в консоли
 */
public class ConsoleReader implements Reader {
    /**
     * Оболочка для InputStreamReader
     */
    private final BufferedReader reader;

    /**
     * Конструктор
     */
    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String read() {
        String s = null;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
