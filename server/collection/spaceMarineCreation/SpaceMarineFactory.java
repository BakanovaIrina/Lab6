package server.collection.spaceMarineCreation;

import another.baseClass.*;
import another.exceptions.UncorrectedFieldException;

import java.util.Date;
import java.util.HashMap;

/**
 * Интерфейс, описывающий действия по созданию элемента SpaceMarine
 */
public interface SpaceMarineFactory {

    /**
     * Метод для создания нового id
     * @return id
     */
    int createNewId();

    /**
     * Метод для создания координат
     * @param x - координата X
     * @param y - координата Y
     * @return координаты
     * @throws UncorrectedFieldException возникает, если x или y введены некорректно
     */
    Coordinates createCoordinates(float x, double y) throws UncorrectedFieldException, UncorrectedFieldException;

    /**
     * Метод для создания главы
     * @param chapterName - название
     * @param parentLegion - родительский легион
     * @param marinesCount - количество бойцов
     * @return chapter
     * @throws UncorrectedFieldException возникает, если поля введены некорректно
     */
    Chapter createChapter(String chapterName, String parentLegion, int marinesCount) throws UncorrectedFieldException;

    /**
     * Метод, создающий SpaceMarine
     * @param name - имя
     * @param coordinates - координаты
     * @param creationDate - дата создания
     * @param health - здоровье
     * @param astartesCategory - категория
     * @param weapon - оружие
     * @param meleeWeapon - оружие ближнего боя
     * @param chapter - глава
     * @return созданный элемент
     * @throws UncorrectedFieldException возникает, если поля введены некорректно
     */
    SpaceMarine createSpaceMarine(String name, Coordinates coordinates, Date creationDate, float health,
                                  AstartesCategory astartesCategory, Weapon weapon, MeleeWeapon meleeWeapon,
                                  Chapter chapter) throws UncorrectedFieldException;

    SpaceMarine createSpaceMarine(HashMap<String, String> fields) throws UncorrectedFieldException;
}
