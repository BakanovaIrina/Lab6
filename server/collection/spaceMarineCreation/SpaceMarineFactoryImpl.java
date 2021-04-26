package server.collection.spaceMarineCreation;

import another.baseClass.*;
import another.exceptions.UncorrectedFieldException;

import java.util.Date;
import java.util.HashMap;

/**
 * Класс для создания новых элементов SpaceMarine
 */
public class SpaceMarineFactoryImpl implements SpaceMarineFactory {

    /**
     * Валидатор для полей
     */
    SpaceMarineValidator validator;

    /**
     * Генератор id
     */
    GeneratorId generatorId;

    InputFieldsConverter converter;

    /**
     * Конструктор
     */
    public SpaceMarineFactoryImpl() {
        validator = new SpaceMarineValidatorImpl();
        generatorId = new GeneratorIdImpl();
        converter = new InputFieldsConverterImpl();
    }

    @Override
    public int createNewId() {
        int id = generatorId.generateId();
        while (!validator.validateId(id)){
            id = generatorId.generateId();
        }
        return id;
    }

    @Override
    public Coordinates createCoordinates(float x, double y) throws UncorrectedFieldException {
        Coordinates coordinates;
        if (validator.validateCoordinates(x, y)){
            coordinates = new Coordinates(x, y);
        }
        else {
            throw new UncorrectedFieldException();
        }
        return coordinates;
    }

    @Override
    public Chapter createChapter(String chapterName, String parentLegion, int marinesCount) {
        Chapter chapter;
        if (validator.validateChapter(chapterName, parentLegion, marinesCount)){
            chapter = new Chapter(chapterName, parentLegion, marinesCount);
        }
        else
            chapter = null;
        return chapter;
    }

    //Изменить для отдельного поля (причина непройденной проверки)
    @Override
    public SpaceMarine createSpaceMarine(String name, Coordinates coordinates, Date creationDate, float health,
                                         AstartesCategory astartesCategory, Weapon weapon,
                                         MeleeWeapon meleeWeapon, Chapter chapter) throws UncorrectedFieldException {
        if(validator.validateName(name) && validator.validateCoordinates(coordinates) &&
                validator.validateCreationDate(creationDate) && validator.validateHealth(health) &&
        validator.validateAstartesCategory(astartesCategory) && validator.validateWeapon(weapon) &&
        validator.validateMeleeWeapon(meleeWeapon)){
            int id = createNewId();
            SpaceMarine spaceMarine = new SpaceMarine(id, name, coordinates, creationDate, health, astartesCategory,
                    weapon, meleeWeapon, chapter);
            return spaceMarine;
        }
        else {
            throw new UncorrectedFieldException();
        }
    }

    @Override
    public SpaceMarine createSpaceMarine(HashMap<String, String> fields) throws UncorrectedFieldException {
        SpaceMarine spaceMarine;
        Date creationDate;
        String name;
        float health;
        Coordinates coordinates;
        AstartesCategory astartesCategory;
        Weapon weapon;
        MeleeWeapon meleeWeapon;
        Chapter chapter;

        try {
            creationDate = new Date();
            name = fields.get("name");
            health = converter.convertToFloat(fields.get("health"));
            coordinates = createCoordinates(converter.convertToFloat(fields.get("coordinateX")),
                    converter.convertToDouble(fields.get("coordinateY")));
            astartesCategory = converter.convertToAstartesCategory(fields.get("category"));
            weapon = converter.convertToWeapon(fields.get("weapon"));
            meleeWeapon = converter.convertToMeleeWeapon(fields.get("meleeWeapon"));
            chapter = createChapter(fields.get("chapterName"), fields.get("parentLegion"),
                    converter.convertToInt(fields.get("numberMarines")));
        }
        catch (IllegalArgumentException e){
            return null;
        }


        if(validator.validateName(name) && validator.validateHealth(health) &&
                validator.validateAstartesCategory(astartesCategory) && validator.validateWeapon(weapon) &&
                validator.validateMeleeWeapon(meleeWeapon)){
            int id = createNewId();
            spaceMarine = new SpaceMarine(id, name, coordinates, creationDate, health, astartesCategory,
                    weapon, meleeWeapon, chapter);
        }
        else {
            throw new UncorrectedFieldException();
        }

        return spaceMarine;
    }
}
