package client.inputOutput.output;

import another.Printer;

/**
 * Класс для печати сообщений в консоль
 */
public class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printError(String message) {
        System.out.println(message);
    }
}
