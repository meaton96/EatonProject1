package entities.npc;

import util.UserInputHelper;

/**
 * class representing a friendly mage entity
 */
public class Mage extends NPC implements interfaces.Transportable {


    public static final int ID = 21;

    private final String DEFAULT_ELEMENTAL_TYPE = "Frost";
    private final int DEFAULT_YEARS_PRACTICED = 0;

    private String elementType;
    private int yearsPracticing;

    /**
     * default constructor to init class fields to default values
     */
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

    /**
     * to String to assist in printing information on the Mage
     *
     * @return a String with information about the Mage
     */
    @Override
    public String toString() {
        return super.toString()
                + "\nDamage Type: " + elementType
                + "\nYears Spent Practicing: " + yearsPracticing;
    }

    /**
     * method to assist in initializing the class fields with user provided values
     *
     * @return this class
     */
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

    /**
     * Prints out a ready message
     */
    public void ready() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " is ready to fire off some spells");

    }


    /**
     * prints out what the Mages says
     */
    public void speak() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " says \"Sela'ma ashal'anore!\"");
    }

    /**
     * prints out a movement message
     */
    public void move() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " moves");
    }

    /**
     * @return String element type of the Mage
     */
    public String getElementType() {
        return elementType;
    }

    /**
     * @param elementType String element type of the Mage
     */
    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    /**
     * @return integer of number of years the Mage spent practicing magic
     */
    public int getYearsPracticing() {
        return yearsPracticing;
    }

    /**
     * @param yearsPracticing integer of number of years the Mage spent practicing magic
     */
    public void setYearsPracticing(int yearsPracticing) {
        this.yearsPracticing = yearsPracticing;
    }

    /**
     * prints out a flying message
     */
    public void fly() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " flies");
    }

    /**
     * prints out a teleporting message
     */
    public void teleport() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " teleports");
    }
}
