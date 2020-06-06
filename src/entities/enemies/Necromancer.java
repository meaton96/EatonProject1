package entities.enemies;

import interfaces.Transportable;
import util.UserInputHelper;

public class Necromancer extends Enemy implements Transportable {

    public static final int ID = 12;

    private final int DEFAULT_NUM_MINIONS = 1;
    private final boolean DEFAULT_ELITE = false;

    private boolean elite;
    private int numMinions;

    public Necromancer() {
        super();
        this.elite = DEFAULT_ELITE;
        this.numMinions = DEFAULT_NUM_MINIONS;
    }

    public Necromancer(String name, int lives, int health, String damageType, int damageLevel, boolean elite, int numMinions) {
        super(name, lives, health, damageType, damageLevel);
        this.elite = elite;
        this.numMinions = numMinions;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nMax Number of Minions: " + numMinions
                + "\nElite: " + (elite ? "Yes" : "No");
    }

    @Override
    public Necromancer build() {
        super.build();

        System.out.println("Enter " + getName() + "'s number of minions (integer): ");
        numMinions = UserInputHelper.getIntInput();
        System.out.println("Is " + getName() + "elite? (Enter y/n): ");
        elite = UserInputHelper.getBooleanInput();

        return this;
    }

    public void ready() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " is ready to summon more minions");
    }


    public void speak() {
        System.out.println(getName() + " says \"the dead shall serve\"");
    }


    public void move() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " moves");

    }

    @Override
    public void fly() {
        System.out.println();
    }

    @Override
    public void teleport() {

    }
}
