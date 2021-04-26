package another.console;

import java.util.HashMap;

/**
 * Интерфейс, расширяющий действия InputManager для ConsoleInputManager
 */
public interface ConsoleInputManager extends InputManager {

    /**
     * Метод для ввода языка
     * @return - язык в стоковом представлении
     */
    String readLanguage();

    HashMap<String, String> readSpaceMarine(OutputManager outputManager);
}
