package another.messenger;

/**
 * Интерфейс для сообщений, связанных с командами
 */
public interface CommandsMessages {

    /**
     * Метод для получения описания команд
     * @param commandName - имя команды
     * @return String description
     */
    String getCommandDescription(String commandName);

    /**
     * Метод для получения сообщения команды average_of_health
     * @param average - полученное значение
     * @return String message
     */
    String getPrintAverageOfHealthMessage(Float average);

    /**
     * Метод для получения сообщения - вывода команды group_counting_by_chapter
     * @param chapter - определенная глава
     * @param sum - количество SpaceMarine на данной главе
     * @return String message
     */
    String getSumMarinesInChapterMessage(String chapter, Long sum);

    /**
     * Метод для получения сообщения результата команды sum_of_health
     * @param sum - сумма здоровья
     * @return String message
     */
    String getPrintSumOfHealthMessage(Float sum);

    String getExitMessage();

}
