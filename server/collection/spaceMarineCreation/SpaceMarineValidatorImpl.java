package server.collection.spaceMarineCreation;

import another.baseClass.*;

import java.util.ArrayList;
import java.util.Date;

public class SpaceMarineValidatorImpl implements SpaceMarineValidator {
    ArrayList<Integer> lastId;

    public SpaceMarineValidatorImpl(){
        lastId = new ArrayList<>();
    }

    @Override
    public boolean validateId(int id) {
        if (lastId.contains(id)){
            return false;
        }
        else{
            lastId.add(id);
            return true;
        }
    }

    @Override
    public boolean validateName(String name) {
        return name != null && name != "";
    }

    @Override
    public boolean validateCoordinates(float x, double y) {
        return x > -341 && y > -539;
    }

    @Override
    public boolean validateCoordinates(Coordinates coordinates) {
        return coordinates != null;
    }

    @Override
    public boolean validateCreationDate(Date date) {
        return date != null;
    }

    @Override
    public boolean validateHealth(float health) {
        return health > 0;
    }

    @Override
    public boolean validateAstartesCategory(AstartesCategory category) {
        return category != null;
    }

    @Override
    public boolean validateWeapon(Weapon weapon) {
        return weapon != null;
    }

    @Override
    public boolean validateMeleeWeapon(MeleeWeapon meleeWeapon) {
        return meleeWeapon != null;
    }

    @Override
    public boolean validateChapter(String chapterName, String parentLegion, int marinesCount) {
        if(chapterName == null || marinesCount <= 0 || marinesCount >= 1000){
            return false;
        }
        else
            return true;
    }
}
