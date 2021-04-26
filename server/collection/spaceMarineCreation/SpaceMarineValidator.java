package server.collection.spaceMarineCreation;

import another.baseClass.*;

import java.util.Date;

/**
 * Интерфейс для действий валидатора элемента SpaceMarine
 */
public interface SpaceMarineValidator {

    /**
     * Проверяет id
     * @param id id
     * @return true, если прошел проверку, false - если нет
     */
    boolean validateId(int id);

    /**
     * Проверяет имя
     * @param name имя
     * @return true, если прошел проверку, false - если нет
     */
    boolean validateName(String name);

    /**
     * Проверяет координаты (значения)
     * @param x координата
     * @param y координата
     * @return true, если прошел проверку, false - если нет
     */
    boolean validateCoordinates(float x, double y);

    /**
     * Проверяет координаты
     * @param coordinates - координаты
     * @return true, если прошел проверку, false - если нет
     */
    boolean validateCoordinates(Coordinates coordinates);

    /**
     * Проверяет дату создания элемента
     * @param date дата
     * @return true, если прошел проверку, false - если нет
     */
    boolean validateCreationDate(Date date);

    /**
     * Проверяет здоровье
     * @param health здоровье
     * @return true, если прошел проверку, false - если нет
     */
    boolean validateHealth(float health);

    /**
     * Проверяет категорию
     * @param category категория
     * @return true, если прошел проверку, false - если нет
     */
    boolean validateAstartesCategory(AstartesCategory category);

    /**
     * Проверяет оружие
     * @param weapon оружие
     * @return true, если прошел проверку, false - если нет
     */
    boolean validateWeapon(Weapon weapon);

    /**
     * Проверяет оружие ближнего боя
     * @param meleeWeapon оружие ближнего боя
     * @return true, если прошел проверку, false - если нет
     */
    boolean validateMeleeWeapon(MeleeWeapon meleeWeapon);

    /**
     * Проверяет главу
     * @param chapterName имя главы
     * @param parentLegion родительский регион
     * @param marinesCount количество бойцов
     * @return true, если прошел проверку, false - если нет
     */
    boolean validateChapter(String chapterName, String parentLegion, int marinesCount);
}
