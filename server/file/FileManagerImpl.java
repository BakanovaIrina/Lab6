package server.file;

import another.baseClass.*;
import another.exceptions.*;
import another.file.FileManager;
import another.file.FileReader;
import another.file.FileWriter;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Менеджер для работы с файлами
 */
public class FileManagerImpl implements FileManager {

    /**
     * Читатель данных из файла
     */
    FileReader fileReader;

    /**
     * Записыватель данных в файл
     */
    FileWriter fileWriter;

    /**
     * Примитивный парсер при получении данных
     */
    Parser parser;

    Serializer serializer;


    /**
     * Конструктор
     * @param fileReader - читатель
     * @param fileWriter - записыватель
     * @param parser - парсер
     */
    public FileManagerImpl(FileReader fileReader, FileWriter fileWriter, Parser parser,
                           Serializer serializer) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.parser = parser;
        this.serializer = serializer;
    }

    @Override
    public ArrayList<SpaceMarine> getCollectionFromFile(String fileName) throws IOException, UncorrectedNullException,
            UncorrectedFileException, ParseException, UncorrectedSizeException, UncorrectedFieldException {
        ArrayList<SpaceMarine> spaceMarines;
        ArrayList<String> input;

        input = fileReader.getStringFile(fileReader.openFile(fileName));
        spaceMarines = parser.parseToSpaceMarine(input);


        return spaceMarines;
    }

    @Override
    public void writeElements(ArrayList<SpaceMarine> spaceMarines) {
        String marine = serializer.serialize(spaceMarines);
        try {
            fileWriter.write(marine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            fileReader.closeFile();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
