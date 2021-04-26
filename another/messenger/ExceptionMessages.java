package another.messenger;

/**
 * Интерфейс для получения сообщений об ошибках
 */
public interface ExceptionMessages {

    /**
     * Метод для получения сообщения об ошибке (не введены значения параметров командной строки)
     * @param fileName - имя файла, который будет использоваться
     * @return String message
     */
    String getNoInputArgs(String fileName);

    String getExceptionMessage(String exceptionName);
}
