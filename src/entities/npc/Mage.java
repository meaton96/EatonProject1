package entities.npc;

import util.UserInputHelper;

public class Mage extends NPC implements interfaces.Transportable {


    public static final int ID = 21;

    private final String DEFAULT_ELEMENTAL_TYPE = "Frost";
    private final int DEFAULT_YEARS_PRACTICED = 0;

    private String elementType;
    private int yearsPracticing;

    public Mage() {
        this.elementType = DEFAULT_ELEMENTAL_TYPE;
        this.yearsPracticing = DEFAULT_YEARS_PRACTICED;
    }
    
    /**
     *
     * @param name String name of entity
     * @param lives integer number of lives
     * @param health integer amount of health
     * @param helpfulSkill String name of helpful skill
     * @param skillLevel integer skill level
     * @param elementType String damage/element type
     * @param yearsPracticing integer years spent practicing being a mage
     */
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
    public Mage build() {
        super.build();

        System.out.println("Enter " + getName() + "'s damage type:");
        elementType = UserInputHelper.getStringInput();

        System.out.println("Enter " + getName() + "'s amount of years spent practicing (integer): ");
        yearsPracticing = UserInputHelper.INVALID_INPUT;

        while (yearsPracticing == UserInputHelper.INVALID_INPUT)
            yearsPracticing = UserInputHelper.getIntInput();
        return this;
    }

    public void ready() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " is ready to fire off some spells");

    }


    public void speak() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " says \"Sela'ma ashal'anore!\"");
    }


    public void move() {
        System.out.println(getClass().getSimpleName() + " " + getClass() + " moves");
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

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " flies");
    }

    @Override
    public void teleport() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " teleports");
    }
}
