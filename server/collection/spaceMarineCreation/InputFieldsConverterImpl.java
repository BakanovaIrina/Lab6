package server.collection.spaceMarineCreation;

import another.baseClass.AstartesCategory;
import another.baseClass.MeleeWeapon;
import another.baseClass.Weapon;

public class InputFieldsConverterImpl implements InputFieldsConverter {

    @Override
    public int convertToInt(String s) throws NumberFormatException {
        return Integer.parseInt(s);
    }

    @Override
    public float convertToFloat(String s) throws NumberFormatException {
        return Float.parseFloat(s);
    }

    @Override
    public double convertToDouble(String s) throws NumberFormatException {
        return Double.parseDouble(s);
    }

    @Override
    public AstartesCategory convertToAstartesCategory(String s) throws IllegalArgumentException {
        return AstartesCategory.valueOf(s.toUpperCase());
    }

    @Override
    public MeleeWeapon convertToMeleeWeapon(String s) throws IllegalArgumentException {
        return MeleeWeapon.valueOf(s.toUpperCase());
    }

    @Override
    public Weapon convertToWeapon(String s) throws IllegalArgumentException {
        return Weapon.valueOf(s.toUpperCase());
    }
}
