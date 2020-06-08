package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author Michael Eaton
 */

/**
 * Class to help with user input for this program
 */
public abstract class UserInputHelper
{
	public static final int INVALID_INPUT = -1;

	private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * get one line of input from the user
	 *
	 * @return the string input from the user
	 */
	public static String getStringInput()
	{
		String inputString = "";
		try
		{
			inputString = READER.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return inputString;
	}

	/**
	 * get an integer input from the user
	 *
	 * @return the integer input that the user entered, if they entered a non integer string returns -1
	 * only positive integers are allowed to be returned
	 */
	public static int getIntInput()
	{
		int temp;
		try
		{
			temp = Integer.parseInt(UserInputHelper.getStringInput());
		}
		catch (NumberFormatException e)
		{
			System.out.println("Please only enter an integer!\n");
			return INVALID_INPUT;
		}
		if (temp <= 0)
		{
			System.out.println("Please entire a number above 0");
			return INVALID_INPUT;
		}
		return temp;
	}

	/**
	 * get an integer input from the user
	 *
	 * @param max integer maximum value the method will accept from the user, exlusive
	 * @param min integer minimum value the method will accept fromthe user, exclusive
	 * @return the integer input that the user entered, if they entered a non integer string returns -1
	 * only integers between min and max, inclusive, will be returned
	 */
	public static int getIntInput(int min, int max)
	{
		int temp;
		try
		{
			temp = Integer.parseInt(UserInputHelper.getStringInput());
		}
		catch (NumberFormatException e)
		{
			System.out.println("Please only enter an integer!\n");
			return INVALID_INPUT;
		}
		if (temp < min || temp > max)
		{
			return INVALID_INPUT;
		}
		return temp;
	}

	/**
	 * get a yes or no answer from the user
	 *
	 * @return boolean value true if yes answer was given
	 * false if no was given
	 */
	public static boolean getBooleanInput()
	{
		char c = ' ';
		while (c != 'y' && c != 'n')
		{
			c = getStringInput().charAt(0);
			if (c < 97)
			{
				c += 32;
			}
			if (c != 'y' && c != 'n')
			{
				System.out.println("Invalid input enter y/n");
			}
		}
		return c == 'y';
	}

	/**
	 * @param max the maximum allowed user input
	 *            ex. menu options 1-5 then 5 would be max input
	 * @return the user choice, an integer (0, max]
	 * return -1 if an invalid option was entered
	 */
	public static int getMenuInput(int max) {
		try {
			String inputString = READER.readLine();
			if (inputString.isEmpty())
				return INVALID_INPUT;
			if (inputString.charAt(0) < 49 || inputString.charAt(0) > max + 48) {
				return INVALID_INPUT;
			}

			return inputString.charAt(0) - 48;
		} catch (IOException e)
		{
			e.printStackTrace();
			return INVALID_INPUT;
		}
	}
}
