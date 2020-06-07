package entities.npc;

import util.UserInputHelper;

public class Trainer extends NPC{

    public static final int ID = 22;

    private final String DEFAULT_EXPERTISE = "None";

    private String expertise;

    @Override
    public String toString() {
        return super.toString()
                + "\nExpertise: " + expertise;
    }

    @Override
    public Trainer build() {
        super.build();

        System.out.println("Enter " + getName() + "'s expertise (area of study): ");
        expertise = UserInputHelper.getStringInput();

        return this;
    }

    public void ready() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " is ready to teach new spells");
    }


    public void speak() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " says \"An'u belore delen'na.\"");
    }


    public void move() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " moves to a new location");
    }

    public Trainer() {
        expertise = DEFAULT_EXPERTISE;
    }

    public Trainer(String name, int lives, int health, String helpfulSkill, int skillLevel, String expertise) {
        super(name, lives, health, helpfulSkill, skillLevel);
        this.expertise = expertise;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
}
