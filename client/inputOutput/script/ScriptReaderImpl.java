package client.inputOutput.script;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс, взяимодействующий с самим файлом скрипта
 */
public class ScriptReaderImpl implements ScriptReader {

    /**
     * Оболочка для InputStreamReader
     */
    private final BufferedReader reader;

    /**
     * Конструктор
     * @param inputStreamReader - поток данных из файла
     */
    public ScriptReaderImpl(InputStreamReader inputStreamReader) {
        this.reader = new BufferedReader(inputStreamReader);
    }

    @Override
    public String read() {
        String s = null;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public boolean isReady() {
        try {
            return reader.ready();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
