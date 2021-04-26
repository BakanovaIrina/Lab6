package another.console;

import another.baseClass.SpaceMarine;

import java.util.Date;
import java.util.stream.Stream;

/**
 * Интерфейс для менеджера по выводу
 */
public interface OutputManager {

    /**
     * Метод для печати определенного сообщения (нет аргументов)
     * @param fileName - имя файла по умолчанию
     */
    void printNoInputArgs(String fileName);

    /**
     * Метод для печати определенного сообщения (исключений)
     * @param exception - название ошибки
     */
    void printException(String exception);

    /**
     * Метод для печати определенного сообщения (приветствие)
     */
    void printHello();

    /**
     * Метод для печати определенного сообщения (информация о коллекции)
     * @param type - тип
     * @param date - дата создания
     * @param size - размер
     */
    void printInfo(String type, Date date, int size);

    /**
     * Метод для печати определенного сообщения (сумма здоровья)
     * @param sum - сумма
     */
    void printSumOfHealthMessage(Float sum);

    /**
     * Метод для печати определенного сообщения (сумма бойцов на главе)
     * @param chapter - глава
     * @param sum - сумма
     */
    void printSumMarinesInChapterMessage(String chapter, Long sum);

    /**
     * Метод для печати определенного сообщения (описание команды)
     * @param commandName - имя команды
     */
    void printCommandDescription(String commandName);

    /**
     * Метод для печати определенного сообщения (среднее значение здоровья)
     * @param average - среднее значение
     */
    void printAverageOfHealthMessage(Float average);

    /**
     * Метод для печати определенного сообщения (коллекция пуста)
     */
    void printNoElementsInCollection();

    /**
     * Метод для печати определенного сообщения (описание конкретного элемента)
     * @param spaceMarine - элемент
     */
    void printElementMessage(SpaceMarine spaceMarine);

    /**
     * Метод для печати определенного сообщения (нет подходящего значения в коллекции)
     */
    void printNoSuchElementInCollection();

    /**
     * Метод для печати определенного сообщения (элемент не минимален)
     */
    void printIsNotMinMessage();

    /**
     * Метод для печати определенного сообщения (ввод поля)
     * @param inputField - поле, которое нужно ввести)
     */
    void printInputMessage(String inputField);

    /**
     * Метод для печати любого сообщения
     * @param message - любое сообщение
     */
    void print(String message);

    void printEnumMessage(Stream<String> stream);
}
