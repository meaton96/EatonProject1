package entities;

import org.jetbrains.annotations.NotNull;
import util.UserInputHelper;

public abstract class Entity implements Comparable<Entity>
{

	public static final int ID = 0;

	private static int numEntities;
	private int idNum;


	private String name;
	private int lives, health;

	protected Entity()
	{
		numEntities++;
		name = getClass().getSimpleName() + " " + numEntities;
		lives = 1;
		health = 100;
	}

	/**
	 * @param name
	 * @param lives
	 * @param health
	 */
	protected Entity(String name, int lives, int health)
	{
		numEntities++;
		this.name = name;
		this.lives = lives;
		this.health = health;
	}

	public String toString()
	{
		return "Information on Entity: " + name
			+ "\nLives: " + lives
			+ "\nHealth: " + health;
	}

	public Entity build()
	{
		System.out.println("Enter Entity name: ");
		name = UserInputHelper.getStringInput();
		if (!name.chars().allMatch(Character::isLetter))
		{
			System.out.println("Please only enter letters for entity names" +
				"\nPlease start over\n");
			build();
		}

		System.out.println("Enter Entity Health (integer): ");
		health = UserInputHelper.INVALID_INPUT;

		while (health == UserInputHelper.INVALID_INPUT)
		{
			health = UserInputHelper.getIntInput();
		}

		System.out.println("Enter Entity Lives (integer): ");
		lives = UserInputHelper.INVALID_INPUT;

		while (lives == UserInputHelper.INVALID_INPUT)
		{
			lives = UserInputHelper.getIntInput();
		}

		return this;
	}
	
	@Override
	public int compareTo(@NotNull Entity o) {
		if (getHealth() == o.getHealth())
			return 0;
		if (getHealth() > o.getHealth())
			return 1;
		return -1;
	}
	
	public boolean equals(String otherName)
	{
		return this.getName().toLowerCase().equals(otherName.toLowerCase());
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getLives()
	{
		return lives;
	}

	public void setLives(int lives)
	{
		this.lives = lives;
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	//public static int getNumEntities() { return numEntities; }
	public int getIdNum()
	{
		return idNum;
	}
}
