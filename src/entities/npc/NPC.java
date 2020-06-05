package entities.npc;

import entities.Entity;
import util.UserInputHelper;

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
    public NPC build() {
        super.build();

        System.out.println("Enter " + getName() + "'s helpful skill name: ");
        helpfulSkill = UserInputHelper.getStringInput();

        skillLevel = UserInputHelper.INVALID_INPUT;

        while (skillLevel == UserInputHelper.INVALID_INPUT)
            skillLevel = UserInputHelper.getIntInput();
        return this;
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


}
