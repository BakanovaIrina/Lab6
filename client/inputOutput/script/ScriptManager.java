package client.inputOutput.script;


import another.console.InputManager;

/**
 * Интерфейс, описывающий действия для ScriptManager, расширяющие действия обычного InputManager
 */
public interface ScriptManager extends InputManager {

    /**
     * Метод, показывающий готовность
     * @return true - готов, false - нет
     */
    boolean isReady();
}
