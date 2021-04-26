package server.collection.spaceMarineCreation;

import another.console.InputConverter;
import another.baseClass.AstartesCategory;
import another.baseClass.MeleeWeapon;
import another.baseClass.Weapon;

public interface InputFieldsConverter extends InputConverter {

    /**
     * Конвертация из строки в int
     * @param s - строка
     * @return - конвертированная строка
     * @throws NumberFormatException - кидается, если тип нельзя привести
     */
    int convertToInt(String s) throws NumberFormatException;

    /**
     * Конвертация из строки в float
     * @param s - строка
     * @return - конвертированная строка
     * @throws NumberFormatException - кидается, если тип нельзя привести
     */
    float convertToFloat(String s) throws NumberFormatException;

    /**
     * Конвертация из строки в double
     * @param s - строка
     * @return - конвертированная строка
     * @throws NumberFormatException - кидается, если тип нельзя привести
     */
    double convertToDouble(String s) throws NumberFormatException;

    /**
     * Конвертация из строки в AstartesCategory
     * @param s - строка
     * @return - конвертированная строка
     * @throws IllegalArgumentException - кидается, если тип нельзя привести
     */
    AstartesCategory convertToAstartesCategory(String s) throws IllegalArgumentException;

    /**
     * Конвертация из строки в MeleeWeapon
     * @param s - строка
     * @return - конвертированная строка
     * @throws IllegalArgumentException - кидается, если тип нельзя привести
     */
    MeleeWeapon convertToMeleeWeapon(String s) throws IllegalArgumentException;

    /**
     * Конвертация из строки в Weapon
     * @param s - строка
     * @return - конвертированная строка
     * @throws IllegalArgumentException - кидается, если тип нельзя привести
     */
    Weapon convertToWeapon(String s) throws IllegalArgumentException;
}
