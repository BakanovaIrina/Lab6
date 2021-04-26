package server.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

/**
 * Интерфейс, описывающий действия по работе с коллекцией
 */
public interface CollectionManager <T> {

    /**
     * Добавляет элемент в коллекцию
     * @param element - добавляемый элемент
     */
    void addElement(T element);

    /**
     * Добавляет элементы в коллекцию
     * @param list - элементы
     */
    void addElements(ArrayList<T> list);

    /**
     * Добавляет элемент в коллекцию по индексу
     * @param element - элемент
     * @param index - индекс
     */
    void addElement(T element, int index);

    /**
     * Очищает коллекцию
     */
    void clear();

    /**
     * Удаляет элемент из коллекции
     * @param element - элемент
     */
    void removeElement(T element);

    /**
     * Метод, выдающий поток данных элементов данной коллекции
     * @return поток данных коллекции
     */
    Stream<T> getStream();

    /**
     * Метод, возвращающий тип коллекции
     * @return тип коллекции
     */
    Class getType();

    /**
     * Метод, возвращающий размер
     * @return размер
     */
    int getSize();

    /**
     * Метод, возвращающий дату создания коллекции
     * @return дата
     */
    Date getDate();

    /**
     * Метод, сортирующий коллекцию в обратном порядке
     */
    void reorder();

    /**
     * Метод, сохраняющий коллекцию
     */
    void save();
}
