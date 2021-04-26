package another.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Интерфейс, описывающий действия для записи в файл
 */
public interface FileWriter {

    /**
     * Метод, записывающий строчку в данном формате в файл
     * @param spaceMarine - строчка
     * @throws FileNotFoundException - бросается, если файл не найден
     * @throws UnsupportedEncodingException - бросается, если кодировка не корректна
     */
    void write(String spaceMarine) throws IOException;

    void close() throws IOException;
}
