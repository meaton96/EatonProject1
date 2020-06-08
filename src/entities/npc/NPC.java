package entities.npc;

import entities.Entity;
import util.UserInputHelper;

/**
 * Class representing a non player character helpful/friendly entity
 */
public abstract class NPC extends Entity {

    public static final int ID = 2;

    private final String DEFAULT_SKILL = "Heal";
    private final int DEFAULT_SKILL_LEVEL = 1;

    private String helpfulSkill;
    private int skillLevel;

    /**
     * default constructor to init class fields to default values
     */
    protected NPC() {
        super();
        this.helpfulSkill = DEFAULT_SKILL;
        this.skillLevel = DEFAULT_SKILL_LEVEL;
    }

    /**
     * @param name         String name of NPC passed to parent
     * @param lives        integer number of lives of NPC passed to parent
     * @param health       integer amount of health of NPC passed to parent
     * @param helpfulSkill String name of the NPC's helpful skill
     * @param skillLevel   integer skill level of the NPC
     */
    protected NPC(String name, int lives, int health, String helpfulSkill, int skillLevel) {
        super(name, lives, health);
        this.helpfulSkill = helpfulSkill;
        this.skillLevel = skillLevel;
    }

    /**
     * method to assist in initializing the class fields with user provided values
     *
     * @return this class
     */
    @Override
    public NPC build() {
        super.build();

        System.out.println("Enter " + getName() + "'s helpful skill name: ");
        helpfulSkill = UserInputHelper.getStringInput();
        System.out.println("Enter " + getName() + "'s helpful skill level: ");
        skillLevel = UserInputHelper.INVALID_INPUT;

        while (skillLevel == UserInputHelper.INVALID_INPUT) {
            skillLevel = UserInputHelper.getIntInput();
        }
        return this;
    }

    /**
     * to String to assist in printing information on the NPC
     *
     * @return String of information of the NPC
     */
    @Override
    public String toString() {
        return super.toString()
                + "\nSkill: " + helpfulSkill
                + "\nSkill Level: " + skillLevel;
    }

    /**
     * @return String of the name of the helpful skill of this NPC
     */
    public String getHelpfulSkill() {
        return helpfulSkill;
    }

    /**
     * @param helpfulSkill String of the name of the helpful skill of this NPC
     */
    public void setHelpfulSkill(String helpfulSkill) {
        this.helpfulSkill = helpfulSkill;
    }

    /**
     * @return integer skill level of the NPC
     */
    public int getSkillLevel() {
        return skillLevel;
    }

    /**
     * @param skillLevel integer skill level of the NPC
     */
    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }


}
