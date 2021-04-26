package server.file;

import another.baseClass.SpaceMarine;
import another.console.DateConverter;

import java.util.ArrayList;

public class SerializerCsv implements Serializer{

    /**
     * Конвертер для даты
     */
    DateConverter dateConverter;

    public SerializerCsv(DateConverter dateConverter) {
        this.dateConverter = dateConverter;
    }

    @Override
    public String serialize(ArrayList<SpaceMarine> spaceMarines) {
        String output = "";
        for (SpaceMarine spaceMarine : spaceMarines) {
            String date = dateConverter.convertDateToStringFormat(spaceMarine.getCreationDate());
            output += spaceMarine.getName() + ";" +
                    "\"" + spaceMarine.getCoordinates().getX() + " " + spaceMarine.getCoordinates().getY() + "\"" + ";"
                    + date + ";" + spaceMarine.getHealth() + ";" + spaceMarine.getCategory() + ";"
                    + spaceMarine.getWeaponType() + ";" + spaceMarine.getMeleeWeapon() + ";" + "\""
                    + spaceMarine.getChapter().getName() + "," + spaceMarine.getChapter().getParentLegion() + ","
                    + spaceMarine.getChapter().getMarinesCount() + "\";" + "\n";
        }
        return output;
    }
}
