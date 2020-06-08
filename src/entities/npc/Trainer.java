package entities.npc;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import util.UserInputHelper;
/**
 * @author Michael Eaton
 */
/**
 * class representing a friendly Trainer to teach skills
 */
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Trainer extends NPC {

    public static final int ID = 22;
    private String expertise;

    /**
     * @param name         String name of entity
     * @param lives        integer number of lives
     * @param health       integer amount of health
     * @param helpfulSkill String name of helpful skill
     * @param skillLevel   integer skill level
     * @param expertise    String expertise of the trainer
     */
    public Trainer(String name, int lives, int health, String helpfulSkill, int skillLevel, String expertise) {
        super(name, lives, health, helpfulSkill, skillLevel);
        this.expertise = expertise;
    }
    /**
     * to string to assist in printing
     *
     * @return String with information of the Trainer
     */
    @Override
    public String toString() {
        return super.toString()
                + "\nExpertise: " + expertise;
    }

    /**
     * method to assist in initializing class fields with user entered values
     *
     * @return this class
     */
    @Override
    public Trainer build() {
        super.build();

        System.out.println("Enter " + getName() + "'s expertise (area of study): ");
        expertise = UserInputHelper.getStringInput();

        return this;
    }

    /**
     * Prints out a ready message
     */
    public void ready() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " is ready to teach new spells");
    }

    /**
     * prints out what the Trainer says
     */
    public void speak() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " says \"An'u belore delen'na.\"");
    }

    /**
     * prints out a movement message
     */
    public void move() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " moves to a new location");
    }

}
