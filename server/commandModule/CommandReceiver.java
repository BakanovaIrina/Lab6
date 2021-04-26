package server.commandModule;

import another.baseClass.SpaceMarine;
import another.messenger.Messenger;

/**
 * Интерфейс, описывающий действия CommandReceiver
 */
public interface CommandReceiver {

    void clearLastScripts();
    /**
     * Исполнение команды average_of_health
     */
    String averageOfHealth();

    /**
     * Исполнение команды add
     */
    String add(SpaceMarine spaceMarine);

    /**
     * Исполнение команды add_if_min
     */
    String addIfMin(SpaceMarine spaceMarine);

    /**
     * Исполнение команды clear
     */
    String clear();

    /**
     * Исполнение команды exit
     */
    void exit();

    /**
     * Исполнение команды group_counting_by_chapter
     */
    String groupCountingByChapter();

    /**
     * Исполнение команды help
     */
    String help();

    /**
     * Исполнение команды info
     */
    String info();

    /**
     * Исполнение команды reorder
     */
    String reorder();

    /**
     * Исполнение команды save
     */
    void save();

    /**
     * Исполнение команды show
     */
    String show();

    /**
     * Исполнение команды sum_of_health
     */
    String sumOfHealth();

    /**
     * Исполнение команды remove_by_id
     * @param id - id удаляемого элемента
     */
    String removeById(int id);

    /**
     * Исполнение команды update_id
     * @param id - id изменяемого элемента
     */
    String updateId(int id, SpaceMarine spaceMarine);

    /**
     * Исполнение команды insert_at
     * @param index - индекс, куда нужно поместить элемент
     */
    String insertAt(int index, SpaceMarine spaceMarine);

    /**
     * Исполнение команды execute_script
     * @param fileName - имя скрипта
     */
    String executeScript(String fileName);

    void setMessenger(Messenger messenger);
}
