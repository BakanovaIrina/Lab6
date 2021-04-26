package another.file;

import another.exceptions.UncorrectedFileException;
import another.exceptions.UncorrectedNullException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Интерфейс, описывающий действия при непосредственном заборе данных из файла
 */
public interface FileReader {

    /**
     * Метод, возвращающий лист строк-содержимого файла
     * @param inputStreamReader - поток данных
     * @return - лист строк
     * @throws IOException - исключение
     */
    ArrayList<String> getStringFile(InputStreamReader inputStreamReader) throws IOException;

    /**
     * Метод, открывающий файл
     * @param fileName - имя файла
     * @return поток данных
     * @throws FileNotFoundException - файл не найден
     * @throws UncorrectedNullException - имя файла не введено
     * @throws UncorrectedFileException - файл некорректен
     */
    InputStreamReader openFile(String fileName) throws FileNotFoundException, UncorrectedFileException,
            UncorrectedNullException;

    public void closeFile() throws IOException;
}
