package entities.enemies;

import entities.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import util.UserInputHelper;
/**
 * @author Michael Eaton
 */

/**
 * class representing an Enemy entity
 */
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public abstract class Enemy extends Entity {

    public static final int ID = 1;
    private String damageType;
    private int damageLevel;

    /**
     * @param name        String name of the entity passed to parent class
     * @param lives       integer number of lives passed to parent class
     * @param health      integer amount of health passed to parent class
     * @param damageType  String damage type of the enemy
     * @param damageLevel integer damage level of the enemy
     */
    protected Enemy(String name, int lives, int health, String damageType, int damageLevel) {
        super(name, lives, health);
        this.damageLevel = damageLevel;
        this.damageType = damageType;
    }

    /**
     * default constructor to init all variables
     */

    /**
     * method to assist in initializing the class fields with user provided values
     *
     * @return this class
     */
    @Override
    public Enemy build() {
        super.build();

        System.out.println("Enter " + getName() + "'s damage type: ");
        damageType = UserInputHelper.getStringInput();

        damageLevel = UserInputHelper.INVALID_INPUT;

        System.out.println("Enter " + getName() + "'s damage level (integer): ");

        while (damageLevel == UserInputHelper.INVALID_INPUT)
            damageLevel = UserInputHelper.getIntInput();

        return this;
    }

    /**
     * to String to assist with printing the information on the enemy
     *
     * @return String with the information on the enemy
     */
    @Override
    public String toString() {
        return super.toString()
                + "\nDamage Type: " + damageType
                + "\nDamage Level: " + damageLevel;
    }


}
