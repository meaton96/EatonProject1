package Entities;

public class Rogue extends Enemy{

    private final int DEFAULT_SNEAK = 1;
    private final boolean DEFAULT_MASTER = false;

    int sneakLevel;
    boolean master;

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
        String mastery = master ? "yes" : "no";
        return super.toString()
                + "\n Sneak Level: " + sneakLevel
                + "\n Masterful: " + mastery;
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
}
