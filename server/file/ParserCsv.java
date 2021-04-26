package server.file;

import another.baseClass.*;
import another.exceptions.UncorrectedFieldException;
import another.exceptions.UncorrectedSizeException;
import another.console.DateConverter;
import server.collection.spaceMarineCreation.SpaceMarineFactory;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Примитивный парсер
 */
public class ParserCsv implements Parser{

    /**
     * Создатель SpaceMarine
     */
    SpaceMarineFactory creator;

    /**
     * Конвертер для даты
     */
    DateConverter dateConverter;

    /**
     * Количество полей в классе
     */
    final int countField;

    /**
     * Конструктор
     * @param spaceMarineCreator - креатор
     * @param dateConverter - конвертер
     */
    public ParserCsv(SpaceMarineFactory spaceMarineCreator, DateConverter dateConverter){
        this.creator = spaceMarineCreator;
        this.dateConverter = dateConverter;
        countField = SpaceMarine.class.getDeclaredFields().length - 2;
    }

    @Override
    public ArrayList<SpaceMarine> parseToSpaceMarine(ArrayList<String> input) throws UncorrectedSizeException,
            ParseException, UncorrectedFieldException {

        ArrayList<SpaceMarine> spaceMarines = new ArrayList<>();

        for (String stringSpaceMarine : input) {
            String[] value = stringSpaceMarine.split(";");
            if (value.length != countField){
                throw new UncorrectedSizeException();
            }

            String[] stringCoordinates = value[1].replace("\"", "").split(" ");

            if(stringCoordinates.length != 2){
                throw new UncorrectedSizeException();
            }

            String[] fullChapter = value[7].replace("\"", "").split(",");

            if(fullChapter.length != 3){
                throw new UncorrectedSizeException();
            }

            spaceMarines.add(creator.createSpaceMarine(value[0], creator.createCoordinates(Float.parseFloat(stringCoordinates[0]),
                    Double.parseDouble(stringCoordinates[1])), dateConverter.convertStringToDate(value[2]), Float.parseFloat(value[3]),
                    AstartesCategory.valueOf(value[4]), Weapon.valueOf(value[5]), MeleeWeapon.valueOf(value[6]),
                    creator.createChapter(fullChapter[0], fullChapter[1], Integer.parseInt(fullChapter[2]))));
        }


        return spaceMarines;
    }
}
