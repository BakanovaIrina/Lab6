package another.baseClass;

import java.io.Serializable;
import java.util.Objects;

/**
 * Класс главы
 */
public class Chapter implements Serializable {

    private static final long serialVersionUID = 1L;
    //Поле не может быть null, Строка не может быть пустой
    private String name;

    private String parentLegion;

    //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 1000
    private Integer marinesCount;

    public Chapter(String name, String parentLegion, Integer marinesCount) {
        this.name = name;
        this.parentLegion = parentLegion;
        this.marinesCount = marinesCount;
    }

    public String getName() {
        return name;
    }

    public String getParentLegion() {
        return parentLegion;
    }

    public Integer getMarinesCount() {
        return marinesCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return Objects.equals(name, chapter.name) &&
                Objects.equals(parentLegion, chapter.parentLegion) &&
                Objects.equals(marinesCount, chapter.marinesCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parentLegion, marinesCount);
    }
}
