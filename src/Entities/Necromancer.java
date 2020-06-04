package Entities;

public class Necromancer extends Enemy{

    public static final int ID = 12;

    private final int DEFAULT_NUM_MINIONS = 1;
    private final boolean DEFAULT_ELITE  = false;

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
                +"\nMax Number of Minions: " + numMinions
                +"\nElite: " + (elite ? "Yes" : "No");
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
