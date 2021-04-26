package another.baseClass;

import java.io.Serializable;

/**
 * Класс координат
 */
public class Coordinates implements Serializable {

    private static final long serialVersionUID = 1L;

    //Значение поля должно быть больше -341, Поле не может быть null
    private Float x;

    //Значение поля должно быть больше -539, Поле не может быть null
    private Double y;

    public Coordinates(float x, double y){
        this.x = x;
        this.y = y;
    }

    public Float getX() {
        return x;
    }

    public Double getY() {
        return y;
    }
}
