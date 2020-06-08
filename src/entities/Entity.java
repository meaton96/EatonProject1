package entities;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import util.UserInputHelper;
/**
 * @author Michael Eaton
 */

/**
 * Class representing an entity/player that can perform actions and has basic attributes
 * such as name lives and health
 */
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public abstract class Entity implements Comparable<Entity>
{

	public static final int ID = 0;

	private static int numEntities;
	private int idNum;


	private String name;
	private int lives, health;

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
	 * @param e Entity to compare this entity to
	 * @return integer comparing the health of the entities
	 * -1 if health is lower than the Entity o
	 * 0 if the health is the same
	 * 1 if the health is greater than the Entity o
	 */
	@Override
	public int compareTo(Entity e) {
		return Integer.compare(getHealth(), e.getHealth());
	}


}
