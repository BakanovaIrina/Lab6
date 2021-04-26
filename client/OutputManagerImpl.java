package client;

import another.baseClass.SpaceMarine;
import another.console.OutputManager;
import another.messenger.Messenger;
import another.Printer;

import java.util.Date;
import java.util.stream.Stream;

/**
 * Класс для взаимодействия с выводом
 */
public class OutputManagerImpl implements OutputManager {
    /**
     * Поле для получения сообщений
     */
    private final Messenger messenger;

    /**
     * Поле для вывода сообщений
     */
    private final Printer printer;

    public OutputManagerImpl(Messenger messenger, Printer printer) {
        this.messenger = messenger;
        this.printer = printer;
    }

    @Override
    public void printNoInputArgs(String fileName) {
        printer.printError(messenger.getNoInputArgs(fileName));
    }

    @Override
    public void printException(String exception) {
        printer.printError(messenger.getExceptionMessage(exception));
    }

    @Override
    public void printHello() {
        printer.print(messenger.getHelloMessage());
    }

    @Override
    public void printInfo(String type, Date date, int size) {
        printer.print(messenger.getPrintInfo(type, date, size));
    }

    @Override
    public void printSumOfHealthMessage(Float sum) {
        printer.print(messenger.getPrintSumOfHealthMessage(sum));
    }

    @Override
    public void printSumMarinesInChapterMessage(String chapter, Long sum) {
        printer.print(messenger.getSumMarinesInChapterMessage(chapter, sum));
    }

    @Override
    public void printCommandDescription(String commandName) {
        printer.print(messenger.getCommandDescription(commandName));
    }

    @Override
    public void printAverageOfHealthMessage(Float average) {
        printer.print(messenger.getPrintAverageOfHealthMessage(average));
    }

    @Override
    public void printNoElementsInCollection() {
        printer.print(messenger.getNoElementsInCollection());
    }

    @Override
    public void printElementMessage(SpaceMarine spaceMarine) {
        printer.print(messenger.getElementMessage(spaceMarine));
    }

    @Override
    public void printNoSuchElementInCollection() {
        printer.print(messenger.getNoSuchElementInCollection());
    }

    @Override
    public void printIsNotMinMessage() {
        printer.print(messenger.getIsNotMinMessage());
    }

    @Override
    public void printInputMessage(String inputField) {
        printer.print(messenger.getInputMessage(inputField));
    }

    @Override
    public void print(String message) {
        printer.print(message);
    }

    @Override
    public void printEnumMessage(Stream<String> stream) {
        printer.print(messenger.getEnumMessage(stream));
    }
}
