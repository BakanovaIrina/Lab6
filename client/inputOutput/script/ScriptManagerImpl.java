package client.inputOutput.script;


import another.console.InputCommandConverter;
import another.console.OutputManager;

import java.util.HashMap;

/**
 * Класс, взаимодействующий с скриптом
 */
public class ScriptManagerImpl implements ScriptManager {

    /**
     * Считыватель того, что находится в самом файле скрипта
     */
    ScriptReader reader;

    /**
     * Конвертер для получаемого
     */
    InputCommandConverter inputConverter;


    /**
     * Конструктор
     * @param reader - считыватель
     * @param inputConverter - конвертер
     */
    public ScriptManagerImpl(ScriptReader reader, InputCommandConverter inputConverter) {
        this.reader = reader;
        this.inputConverter = inputConverter;
    }

    @Override
    public HashMap<String, String> readSpaceMarine(OutputManager outputManager) {
        HashMap<String, String> fields = new HashMap<>();

        fields.put("name", reader.read());

        fields.put("coordinateX", reader.read());

        fields.put("coordinateY", reader.read());

        fields.put("health", reader.read());

        fields.put("category", reader.read());

        fields.put("weapon", reader.read());

        fields.put("meleeWeapon", reader.read());

        fields.put("chapterName", reader.read());

        fields.put("parentLegion", reader.read());

        fields.put("numberMarines", reader.read());

        return fields;
    }

    @Override
    public String[] readCommand() {
        return inputConverter.convertToCommand(reader.read());
    }

    @Override
    public boolean isReady() {
        return reader.isReady();
    }
}
