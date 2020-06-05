package entities.enemies;

import util.UserInputHelper;

public class Rogue extends Enemy{

    public static final int ID = 11;

    private final int DEFAULT_SNEAK = 1;
    private final boolean DEFAULT_MASTER = false;

    private int sneakLevel;
    private boolean master;

    public Rogue() {
        super();
        this.sneakLevel = DEFAULT_SNEAK;
        this.master = DEFAULT_MASTER;
    }

    public Rogue(String name, int lives, int health, String damageType, int damageLevel, int sneakLevel, boolean master) {
        super(name, lives, health, damageType, damageLevel);
        this.sneakLevel = sneakLevel;
        this.master = master;
    }

    @Override
    public String toString() {

        return super.toString()
                + "\nSneak Level: " + sneakLevel
                + "\nMasterful: " + (master ? "Yes" : "No");
    }

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

    public void ready() {
        System.out.println(getName() + " is ready for mischief");
    }


    public void speak() {
        System.out.println(getName() + " is talking quietly");
    }


    public void move() {
        System.out.println(getName() + " is sneaking");
    }
}
