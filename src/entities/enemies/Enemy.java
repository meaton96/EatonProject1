package entities.enemies;

import entities.Entity;
import util.UserInputHelper;


/**
 * class representing an Enemy entity
 */
public abstract class Enemy extends Entity {

    public static final int ID = 1;

    private final String DEFAULT_DAMAGE_TYPE = "Physical";
    private final int DEFAULT_DAMAGE_LEVEL = 1;

    private String damageType;
    private int damageLevel;

    /**
     * default constructor to init all variables
     */
    protected Enemy() {
        super();
        damageLevel = DEFAULT_DAMAGE_LEVEL;
        damageType = DEFAULT_DAMAGE_TYPE;
    }

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
     * @return String damage type of enemy
     */
    public String getDamageType() {
        return damageType;
    }

    /**
     * @param damageType String damage type of enemy
     */
    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    /**
     * @return integer damage level of the enemy
     */
    public int getDamageLevel() {
        return damageLevel;
    }

    /**
     * @param damageLevel integer damage level of the enemy
     */
    public void setDamageLevel(int damageLevel) {
        this.damageLevel = damageLevel;
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
