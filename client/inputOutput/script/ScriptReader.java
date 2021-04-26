package client.inputOutput.script;

import another.console.Reader;

/**
 * Интерфейс, описывающий действия для читателя из скрипта
 */
public interface ScriptReader extends Reader {
    /**
     * Метод, показывающий, считаны ли все данные
     * @return true - что-то осталось, false - все считано
     */
    boolean isReady();
}
