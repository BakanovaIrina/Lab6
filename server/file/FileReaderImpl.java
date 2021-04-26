package server.file;

import another.file.FileReader;
import another.file.FileValidator;
import server.file.FileValidatorImpl;

import java.io.*;
import java.util.ArrayList;

/**
 * Класс, взаимодействующий с файлом
 */
public class FileReaderImpl implements FileReader {
    /**
     * Валидатор для проверки ввода
     */
    FileValidator fileValidator;

    private FileInputStream fileInputStream;

    /**
     * Конструктор
     */
    public FileReaderImpl(){
        fileValidator = new FileValidatorImpl();
    }

    @Override
    public InputStreamReader openFile(String fileName) throws FileNotFoundException{
        if (fileValidator.validateFileName(fileName)){
            File file = new File(fileName);
            if (fileValidator.validateFile(file)){
                fileInputStream = new FileInputStream(file);
                return new InputStreamReader(fileInputStream);
            }
            else throw new FileNotFoundException();
        }
        else throw new FileNotFoundException();
    }

    @Override
    public ArrayList<String> getStringFile(InputStreamReader inputStreamReader) throws IOException {
        BufferedReader reader = new BufferedReader(inputStreamReader);
        ArrayList<String> list = new ArrayList<>();
        while (reader.ready()){
            list.add(reader.readLine());
        }
        return list;
    }

    public void closeFile() throws IOException {
        fileInputStream.close();
    }
}
