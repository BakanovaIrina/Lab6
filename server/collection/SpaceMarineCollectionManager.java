package server.collection;

import another.baseClass.SpaceMarine;
import another.file.FileManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

public class SpaceMarineCollectionManager implements CollectionManager<SpaceMarine> {

    /**
     * Коллекция
     */
    private ArrayList<SpaceMarine> collection;

    /**
     * Дата создания коллекции
     */
    private Date creationDate;

    /**
     * Менеджер для сохранения
     */
    private FileManager fileManager;

    public SpaceMarineCollectionManager(FileManager fileManager, String fileName) {
        try {
            collection = fileManager.getCollectionFromFile(fileName);
        } catch (Exception e) {
            collection = new ArrayList<>();
        }
        creationDate = new Date();
        this.fileManager = fileManager;
    }

    /**
     * Добавляет элемент в коллекцию
     * @param element - добавляемый элемент
     */
    @Override
    public void addElement(SpaceMarine element) {
        collection.add(element);
    }

    /**
     * Добавляет элементы в коллекцию
     * @param list - элементы
     */
    @Override
    public void addElements(ArrayList<SpaceMarine> list) {
        collection.addAll(list);
    }

    /**
     * Добавляет элемент в коллекцию по индексу
     * @param element - элемент
     * @param index   - индекс
     */
    @Override
    public void addElement(SpaceMarine element, int index) {
        if (collection.size() < index){
            for(int i = collection.size(); i < index; i++){
                collection.add(null);
            }
        }
        collection.add(index, element);if (collection.size() < index){
            for(int i = collection.size(); i < index; i++){
                collection.add(null);
            }
        }
        collection.add(index, element);
    }

    /**
     * Очищает коллекцию
     */
    @Override
    public void clear() {
        collection.clear();
    }

    /**
     * Удаляет элемент из коллекции
     * @param element - элемент
     */
    @Override
    public void removeElement(SpaceMarine element) {
        collection.remove(element);
    }

    /**
     * Метод, выдающий поток данных элементов данной коллекции
     * @return поток данных коллекции
     */
    @Override
    public Stream<SpaceMarine> getStream() {
        return collection.stream();
    }

    /**
     * Метод, возвращающий тип коллекции
     * @return тип коллекции
     */
    @Override
    public Class getType() {
        return collection.getClass();
    }

    /**
     * Метод, возвращающий размер
     * @return размер
     */
    @Override
    public int getSize() {
        return collection.size();
    }

    /**
     * Метод, возвращающий дату создания коллекции
     *
     * @return дата
     */
    @Override
    public Date getDate() {
        return creationDate;
    }

    /**
     * Метод, сортирующий коллекцию в обратном порядке
     */
    @Override
    public void reorder() {
        ArrayList<SpaceMarine> newCollection = new ArrayList<>();
        for (int i = collection.size() - 1; i >= 0; i--) {
            newCollection.add(collection.get(i));
        }
        collection = newCollection;
    }

    /**
     * Метод, сохраняющий коллекцию
     */
    @Override
    public void save() {
        fileManager.writeElements(collection);
    }
}
