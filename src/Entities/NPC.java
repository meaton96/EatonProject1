package Entities;

public abstract class NPC extends Entity {

    public static final int ID = 2;

    private final String DEFAULT_SKILL = "Heal";
    private final int DEFAULT_SKILL_LEVEL = 1;

    private String helpfulSkill;
    private int skillLevel;

    protected NPC() {
        super();
        this.helpfulSkill = DEFAULT_SKILL;
        this.skillLevel = DEFAULT_SKILL_LEVEL;
    }

    protected NPC(String name, int lives, int health, String helpfulSkill, int skillLevel) {
        super(name, lives, health);
        this.helpfulSkill = helpfulSkill;
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nSkill: " + helpfulSkill
                + "\nSkill Level: " + skillLevel;
    }

    public String getHelpfulSkill() { return helpfulSkill; }
    public void setHelpfulSkill(String helpfulSkill) { this.helpfulSkill = helpfulSkill; }

    public int getSkillLevel() { return skillLevel; }
    public void setSkillLevel(int skillLevel) { this.skillLevel = skillLevel; }

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
