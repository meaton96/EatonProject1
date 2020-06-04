package Entities;

public abstract class Entity {

    public static final int ID = 0;

    private static int numEntities;
    private final int BASE_LIVES = 1, BASE_HEALTH = 100;
    private int idNum;



    private String name;
    private int lives, health;

    protected Entity() {
        numEntities++;
        name = getClass().getSimpleName() + " " + String.valueOf(numEntities);
        lives = BASE_LIVES;
        health = BASE_HEALTH;
    }

    /**
     * @param name
     * @param lives
     * @param health
     */
    protected Entity(String name, int lives, int health) {
        numEntities++;
        this.name = name;
        this.lives = lives;
        this.health = health;
    }

    public void ready() {
        System.out.println(name + " is ready");
    }
    public void speak() {
        System.out.println(name + " is speaking");
    }
    public void move() {
        System.out.println(name + " is moving");
    }

    public String toString() {
        return "Information on Entity: " + name
                + "\nLives: " + lives
                + "\nHealth: " + health;
    }


    public boolean equals(String otherName) {
        return this.getName().toLowerCase().equals(otherName.toLowerCase());
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getLives() { return lives; }
    public void setLives(int lives) { this.lives = lives; }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    //public static int getNumEntities() { return numEntities; }
    public int getIdNum() { return idNum; }
}
