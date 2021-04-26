package another.baseClass;

import java.io.Serializable;
import java.util.Date;

/**
 * Основной класс коллекции
 */
public class SpaceMarine implements Comparable<SpaceMarine>, Serializable {

     private static final long serialVersionUID = 1L;

     //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
     private int id;

     //Поле не может быть null, Строка не может быть пустой
     private String name;

     //Поле не может быть null
     private Coordinates coordinates;

     //Поле не может быть null, Значение этого поля должно генерироваться автоматически
     private java.util.Date creationDate;

     //Значение поля должно быть больше 0
     private float health;

     //Поле не может быть null
     private AstartesCategory category;

     //Поле не может быть null
     private Weapon weaponType;

     //Поле может быть null
     private MeleeWeapon meleeWeapon;

     //Поле может быть null
     private Chapter chapter;

     public SpaceMarine(int id, String name, Coordinates coordinates, Date creationDate,
                        float health, AstartesCategory category, Weapon weaponType,
                        MeleeWeapon meleeWeapon, Chapter chapter) {
          this.id = id;
          this.name = name;
          this.coordinates = coordinates;
          this.creationDate = creationDate;
          this.health = health;
          this.category = category;
          this.weaponType = weaponType;
          this.meleeWeapon = meleeWeapon;
          this.chapter = chapter;
     }

     public int getId() {
          return id;
     }

     public String getName() {
          return name;
     }

     public Coordinates getCoordinates() {
          return coordinates;
     }

     public Date getCreationDate() {
          return creationDate;
     }

     public float getHealth() {
          return health;
     }

     public AstartesCategory getCategory() {
          return category;
     }

     public Weapon getWeaponType() {
          return weaponType;
     }

     public MeleeWeapon getMeleeWeapon() {
          return meleeWeapon;
     }

     public Chapter getChapter() {
          return chapter;
     }

     public void setName(String name) {
          this.name = name;
     }

     public void setCoordinates(Coordinates coordinates) {
          this.coordinates = coordinates;
     }

     public void setCreationDate(Date creationDate) {
          this.creationDate = creationDate;
     }

     public void setHealth(float health) {
          this.health = health;
     }

     public void setCategory(AstartesCategory category) {
          this.category = category;
     }

     public void setWeaponType(Weapon weaponType) {
          this.weaponType = weaponType;
     }

     public void setMeleeWeapon(MeleeWeapon meleeWeapon) {
          this.meleeWeapon = meleeWeapon;
     }

     public void setChapter(Chapter chapter) {
          this.chapter = chapter;
     }

     @Override
     public int compareTo(SpaceMarine o) {
          return (int) (o.getHealth() - health);
     }
}
