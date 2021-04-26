package server.file;

import another.file.FileWriter;

import java.io.*;

/**
 * Класс, записывающий данные в файл
 */
public class FileWriterImpl implements FileWriter {
    /**
     * Имя файла
     */
    String fileName;

    /**
     * Записыватель
     */
    PrintWriter printWriter;

    FileOutputStream fileOutputStream;

    /**
     * Конструктор
     * @param fileName - имя файла для записи
     */
    public FileWriterImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(String spaceMarine) throws IOException {
        fileOutputStream = new FileOutputStream(fileName, false);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "Cp866");
        printWriter = new PrintWriter(outputStreamWriter);
        printWriter.println(spaceMarine);
    }

    @Override
    public void close() throws IOException {
        printWriter.close();
        fileOutputStream.close();
    }
}
