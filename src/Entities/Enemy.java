package Entities;

public abstract class Enemy extends Entity{

    public static final int ID = 1;

    private final String DEFAULT_DAMAGE_TYPE = "Physical";
    private final int DEFAULT_DAMAGE_LEVEL = 1;

    private String damageType;
    private int damageLevel;

    protected Enemy() {
        super();
        damageLevel = DEFAULT_DAMAGE_LEVEL;
        damageType = DEFAULT_DAMAGE_TYPE;
    }

    protected Enemy(String name, int lives, int health, String damageType, int damageLevel) {
        super(name, lives, health);
        this.damageLevel = damageLevel;
        this.damageType = damageType;
    }



    public String getDamageType() { return damageType; }
    public void setDamageType(String damageType) { this.damageType = damageType; }

    public int getDamageLevel() { return damageLevel; }
    public void setDamageLevel(int damageLevel) { this.damageLevel = damageLevel; }

    @Override
    public String toString() {
        return super.toString()
                + "\nDamage Type: " + damageType
                + "\nDamage Level: " + damageLevel;
    }

    public void ready() {

    }


    public void speak() {

    }


    public void move() {

    }
}
