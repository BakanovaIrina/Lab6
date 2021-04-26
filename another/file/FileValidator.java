package another.file;

import java.io.File;

/**
 * Интерфейс, описывающий действия при проверки файлов
 */
public interface FileValidator{
    /**
     * Метод, проверяющий файл
     * @param file - проверяемый файл
     * @return true, если файл корректен, false - если нет
     */
    boolean validateFile(File file);

    /**
     * Метод, проверяющий имя файла
     * @param fileName - проверяемое имя
     * @return true, если имя корректно, false - если нет
     */
    boolean validateFileName(String fileName);
}
