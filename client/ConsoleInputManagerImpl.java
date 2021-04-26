package client;

import another.baseClass.*;
import another.console.ConsoleInputManager;
import another.console.InputCommandConverter;
import another.console.OutputManager;
import another.console.Reader;

import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Класс для взаимодействия с консолью
 */
public class ConsoleInputManagerImpl implements ConsoleInputManager {

    /**
     * Считыватель ввода
     */
    Reader reader;

    /**
     * Конвертер для ввода
     */
    InputCommandConverter inputConverter;

    /**
     * Конструктор
     * @param inputConverter - конвертер
     * @param reader - считыватель
     */
    public ConsoleInputManagerImpl(InputCommandConverter inputConverter,
                                   Reader reader) {
        this.reader = reader;
        this.inputConverter = inputConverter;
    }

    @Override
    public String[] readCommand() {
        return inputConverter.convertToCommand(reader.read());
    }

    public String readLanguage(){
        return inputConverter.convertToString(reader.read());
    }

    @Override
    public HashMap<String, String> readSpaceMarine(OutputManager outputManager) {
        HashMap<String, String> fields = new HashMap<>();

        outputManager.printInputMessage("name");
        fields.put("name", reader.read());

        outputManager.printInputMessage("coordinateX");
        fields.put("coordinateX", reader.read());

        outputManager.printInputMessage("coordinateY");

        fields.put("coordinateY", reader.read());

        outputManager.printInputMessage("health");
        fields.put("health", reader.read());

        outputManager.printInputMessage("category");
        outputManager.printEnumMessage(Stream.of(AstartesCategory.values()).map(v -> v.toString()));
        fields.put("category", reader.read());

        outputManager.printInputMessage("weapon");
        outputManager.printEnumMessage(Stream.of(Weapon.values()).map(v -> v.toString()));
        fields.put("weapon", reader.read());

        outputManager.printInputMessage("meleeWeapon");
        outputManager.printEnumMessage(Stream.of(MeleeWeapon.values()).map(v -> v.toString()));
        fields.put("meleeWeapon", reader.read());

        outputManager.printInputMessage("chapterName");
        fields.put("chapterName", reader.read());

        outputManager.printInputMessage("parentLegion");
        fields.put("parentLegion", reader.read());

        outputManager.printInputMessage("numberMarines");
        fields.put("numberMarines", reader.read());

        return fields;
    }

}
