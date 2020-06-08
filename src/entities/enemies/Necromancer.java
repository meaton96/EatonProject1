package entities.enemies;

import interfaces.Transportable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import util.UserInputHelper;
/**
 * @author Michael Eaton
 */
/**
 * class representing a Necromancer type enemy
 */
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Necromancer extends Enemy implements Transportable {

    public static final int ID = 12;
    private boolean elite;
    private int numMinions;
    /**
     * @param name        String name of entity
     * @param lives       integer number of lives
     * @param health      integer amount of health
     * @param damageType  String damage type of the enemy
     * @param damageLevel integer damage level of the enemy
     * @param elite       boolean if the rogue is a elite necromancer or not
     * @param numMinions  integer maximum number of minions the necromancer can summon
     */
    public Necromancer(String name, int lives, int health, String damageType, int damageLevel, boolean elite, int numMinions) {
        super(name, lives, health, damageType, damageLevel);
        this.elite = elite;
        this.numMinions = numMinions;
    }

    /**
     * to string to assist in printing
     *
     * @return String with information on the Rogue
     */
    @Override
    public String toString() {
        return super.toString()
                + "\nMax Number of Minions: " + numMinions
                + "\nElite: " + (elite ? "Yes" : "No");
    }

    /**
     * method to assist in initializing class fields with user entered values
     *
     * @return this class
     */
    @Override
    public Necromancer build() {
        super.build();

        System.out.println("Enter " + getName() + "'s number of minions (integer): ");
        numMinions = UserInputHelper.getIntInput();
        System.out.println("Is " + getName() + "elite? (Enter y/n): ");
        elite = UserInputHelper.getBooleanInput();

        return this;
    }

    /**
     * Prints out a ready message
     */
    public void ready() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " is ready to summon more minions");
    }

    /**
     * prints out what the Necromancer says
     */
    public void speak() {
        System.out.println(getName() + " says \"the dead shall serve\"");
    }


    /**
     * prints out a movement message
     */
    public void move() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " moves");

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
