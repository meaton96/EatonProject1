package entities.enemies;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import util.UserInputHelper;
/**
 * @author Michael Eaton
 */
/**
 * class representing a rogue type enemy
 */
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Rogue extends Enemy {

    public static final int ID = 11;
    private int sneakLevel;
    private boolean master;

    /**
     * @param name        String name of entity
     * @param lives       integer number of lives
     * @param health      integer amount of health
     * @param damageType  String damage type of the enemy
     * @param damageLevel integer damage level of the enemy
     * @param master      boolean if the rogue is a master rogue or not
     * @param sneakLevel  integer level of sneakiness
     */
    public Rogue(String name, int lives, int health, String damageType, int damageLevel, int sneakLevel, boolean master) {
        super(name, lives, health, damageType, damageLevel);
        this.sneakLevel = sneakLevel;
        this.master = master;
    }

    /**
     * to string to assist in printing
     *
     * @return String with information on the Rogue
     */
    @Override
    public String toString() {

        return super.toString()
                + "\nSneak Level: " + sneakLevel
                + "\nMasterful: " + (master ? "Yes" : "No");
    }

    /**
     * method to assist in initializing class fields with user entered values
     *
     * @return this class
     */
    @Override
    public Rogue build() {
        super.build();

        sneakLevel = UserInputHelper.INVALID_INPUT;
        System.out.println("Enter " + getName() + "'s sneak level (integer): ");

        while (sneakLevel == UserInputHelper.INVALID_INPUT)
            sneakLevel = UserInputHelper.getIntInput();

        System.out.println("Is " + getName() + " a master? (Enter y/n): ");

        master = UserInputHelper.getBooleanInput();

        return this;
    }

    /**
     * Prints out a ready message
     */
    public void ready() {
        System.out.println(getName() + " is ready for mischief");
    }

    /**
     * prints out what the Rogue says
     */
    public void speak() {
        System.out.println(getName() + " is talking quietly");
    }


    /**
     * prints out a movement message
     */
    public void move() {
        System.out.println(getName() + " is sneaking");
    }
}
