package Entities;

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
    public void ready() {
        super.ready();
    }

    @Override
    public void speak() {
        super.speak();
    }

    @Override
    public void move() {
        super.move();
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
