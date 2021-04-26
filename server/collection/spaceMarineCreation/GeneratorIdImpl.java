package server.collection.spaceMarineCreation;

import java.util.Random;

public class GeneratorIdImpl implements GeneratorId{
    @Override
    public int generateId() {
        return new Random().nextInt(Integer.MAX_VALUE);
    }
}
