package another.file;

import another.baseClass.SpaceMarine;
import another.exceptions.UncorrectedFieldException;
import another.exceptions.UncorrectedFileException;
import another.exceptions.UncorrectedNullException;
import another.exceptions.UncorrectedSizeException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Менеджер, отвечающий за ввод-вывод из файла
 */
public interface FileManager {

    /**
     * Метод, получающий элементы из файла
     * @param fileName - имя файла
     * @return - лист элементов
     */
    ArrayList<SpaceMarine> getCollectionFromFile(String fileName) throws IOException, UncorrectedNullException, UncorrectedFileException, ParseException, UncorrectedSizeException, UncorrectedFieldException;

    /**
     * Метод, записывающий элемент в файл
     * @param spaceMarines - записываемый элемент
     */
    void writeElements(ArrayList<SpaceMarine> spaceMarines);

    void close();
}
