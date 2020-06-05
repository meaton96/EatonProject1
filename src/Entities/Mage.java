package Entities;

public class Mage extends NPC {

    public static final int ID = 21;

    private final String DEFAULT_ELEMENTAL_TYPE = "Frost";
    private final int DEFAULT_YEARS_PRACTICED = 0;

    private String elementType;
    private int yearsPracticing;

    public Mage() {
        this.elementType = DEFAULT_ELEMENTAL_TYPE;
        this.yearsPracticing = DEFAULT_YEARS_PRACTICED;
    }

    public Mage(String name, int lives, int health, String helpfulSkill, int skillLevel, String elementType, int yearsPracticing) {
        super(name, lives, health, helpfulSkill, skillLevel);
        this.elementType = elementType;
        this.yearsPracticing = yearsPracticing;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nDamage Type: " + elementType
                + "\nYears Spent Practicing: " + yearsPracticing;
    }

    @Override
    public void ready() {
        super.ready();
    }

    @Override
    public void speak() {
        super.speak();
    }

    @Override
    public void move() {
        super.move();
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public int getYearsPracticing() {
        return yearsPracticing;
    }

    public void setYearsPracticing(int yearsPracticing) {
        this.yearsPracticing = yearsPracticing;
    }
}
