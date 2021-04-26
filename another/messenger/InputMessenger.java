package another.messenger;

import java.util.stream.Stream;

/**
 * Интерфейс для получения сообщений, связанных с вводом данных
 */
interface InputMessenger {

    /**
     * Метод для получения сообщения о вводимом поле
     * @param inputField - вводимое поле
     * @return String message
     */
    String getInputMessage(String inputField);

    /**
     * Метод для получения сообщения о существующих значениях enum
     * @param stream - поток значений
     * @return String message
     */
    String getEnumMessage(Stream<String> stream);

}
