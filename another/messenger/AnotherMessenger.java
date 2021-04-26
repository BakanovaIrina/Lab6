package another.messenger;

/**
 * Интерфейс для прочих сообщений
 */
public interface AnotherMessenger {
    /**
     * Метод для получения приветственного сообщения
     * @return String message
     */
    String getHelloMessage();

    String getCommandIsExecutedSuccessfully(String commandName);
}
