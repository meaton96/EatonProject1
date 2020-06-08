package entities;


import util.UserInputHelper;

/**
 * Class representing an entity/player that can perform actions and has basic attributes
 * such as name lives and health
 */
public abstract class Entity implements Comparable<Entity>
{

	public static final int ID = 0;

	private static int numEntities;
	private int idNum;


	private String name;
	private int lives, health;

	/**
	 * default constructor init name lives and health to default values
	 */
	protected Entity() {
		numEntities++;
		name = getClass().getSimpleName() + " " + numEntities;
		lives = 1;
		health = 100;
	}

	/**
	 * @param name   String name of entity
	 * @param lives  Integer number of lives
	 * @param health Integer amount of health
	 */
	protected Entity(String name, int lives, int health) {
		numEntities++;
		this.name = name;
		this.lives = lives;
		this.health = health;
	}

	/**
	 * to String for printing
	 *
	 * @return a string with basic information on the entity
	 */
	public String toString() {
		return "Information on Entity: " + name
				+ "\nLives: " + lives
				+ "\nHealth: " + health;
	}

	/**
	 * method for initializing the class fields with user entered values
	 *
	 * @return an object of type Entity, returns this class after setting the class fields
	 */
	public Entity build() {
		System.out.println("Enter Entity name: ");
		name = UserInputHelper.getStringInput();
		if (!name.chars().allMatch(Character::isLetter)) {
			System.out.println("Please only enter letters for entity names" +
					"\nPlease start over\n");
			build();
		}

		System.out.println("Enter Entity Health (integer): ");
		health = UserInputHelper.INVALID_INPUT;

		while (health == UserInputHelper.INVALID_INPUT) {
			health = UserInputHelper.getIntInput();
		}

		System.out.println("Enter Entity Lives (integer): ");
		lives = UserInputHelper.INVALID_INPUT;

		while (lives == UserInputHelper.INVALID_INPUT) {
			lives = UserInputHelper.getIntInput();
		}

		return this;
	}

	/**
	 * @param o Entity to compare this entity to
	 * @return integer comparing the health of the entities
	 * -1 if health is lower than the Entity o
	 * 0 if the health is the same
	 * 1 if the health is greater than the Entity o
	 */
	@Override
	public int compareTo(Entity o) {
		return Integer.compare(getHealth(), o.getHealth());
	}

	/**
	 * @return String name of entity
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name String name of entity
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return integer number of lives of the entity
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * @param lives integer number of lives
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}

	/**
	 * @return integer amount of health of the entity
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health integer amount of health
	 */
	public void setHealth(int health) {
		this.health = health;
	}
}
