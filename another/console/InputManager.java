package another.console;

import java.util.HashMap;

/**
 * Интерфейс, описывающий поведение менеджера, работающего с вводом
 */
public interface InputManager {

    /**
     * Метод, читающий определенный элемент
     * @param outputManager - менеджер для запроса у пользователя соответствующего поля
     * @return - элемент SpaceMarine
     */
    HashMap<String, String> readSpaceMarine(OutputManager outputManager);

    /**
     * Метод, читающий команды
     * @return массив из полученного (команда-значение)
     */
    String[] readCommand();
}
