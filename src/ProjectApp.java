import Entities.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ProjectApp {

    private final String[] ENTITY_NAME_LIST = {"Mage", "Necromancer", "Rogue", "Trainer"};

    private ArrayList<Entity> entities;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public ProjectApp() {

        entities = new ArrayList<>();
        displayMenu();
    }


    /**
     * Display the list of menu options for performing actions on the list of entities
     */
    public void displayMenu() {

        System.out.println("____________________________________________________"
                        + "\n1. View Entities"
                        + "\n2. Add Entity"
                        + "\n3. Remove Entity"
                        + "\n4. Perform an Action"
                        + "\n5. End Program"
                        + "\nEnter a number 1-5 to perform an action");


        switch (getUserMenuInput(5)) {
            case -1: displayMenu();
            break;
            case 1 : printEntities();
            break;
            case 2 : addEntityMenu();
            break;
            case 3 : removeEntity();
            break;
            case 4 : performAction();
            break;
            case 5 :
                System.out.println("Ending Program");
            break;
            default:
                System.out.println("Invalid input please try again\n");
                displayMenu();
            break;
        }
    }

    public void performAction() {
        //Todo

    }

    /**
     * remove an entity from the list
     * get user input for name of entity, compare to the list
     * and delete from list if it exists
     */
    public void removeEntity() {
        String name;
        System.out.println("Enter entity's name for deletion: ");
        name = getUserInputAnswer();

        if (entities.remove(findEntityInList(name))) {
            System.out.println("Entity " + name + " was successfully removed from the list");
            return;
        }
        System.out.println("Entity " + name + " was not found in the list would you like to try entering the name again? (Enter y/n)");
        char c = ' ';
        while (c != 'y' && c != 'n') {
            c = getUserInputAnswer().charAt(0);
            if (c > 97)
                c -= 32;
            if (c != 'y' && c != 'n')
                System.out.println("Invalid input enter y/n");
        }
        if (c == 'y')
            removeEntity();

        displayMenu();
    }

    /**
     *
     * @param name String to search the list for
     * @return the Entity in the list if it exists
     *              if it doesn't exist return null
     */
    private Entity findEntityInList(String name) {
        if (entities.isEmpty())
            return null;
        for (Entity x : entities) {
            if (x.equals(name))
                return x;
        }
        return null;
    }

    /**
     * display choices of entities for adding to the list
     *
     */
    public void addEntityMenu() {


        System.out.println("\nChoose an Entity to add: ");
        for (int x = 1; x <= ENTITY_NAME_LIST.length; x++) {
            System.out.println(x + ". " + ENTITY_NAME_LIST[x - 1]);
        }
        System.out.println("Enter a number between 1 and " + ENTITY_NAME_LIST.length + " to add to the list");

        Entity entityToAdd = null;

        //Mage Necromancer Rogue Trainer
        switch (getUserMenuInput(ENTITY_NAME_LIST.length)) {
            case -1: addEntityMenu();
            break;
            case 1 : entityToAdd = getEntityInformation(Mage.ID);
            break;
            case 2 : entityToAdd = getEntityInformation(Necromancer.ID);
            break;
            case 3 : entityToAdd = getEntityInformation(Rogue.ID);
            break;
            case 4 : entityToAdd = getEntityInformation(Trainer.ID);
            break;
            default:
                System.out.println("Invalid input please try again");
                addEntityMenu();
        }
        entities.add(entityToAdd);
        if (entityToAdd != null)
            System.out.println("\nEntity: " + entityToAdd.getName() + " successfully added to list\n");
        displayMenu();
    }

    /**
     *
     * @param entityID Unique ID of Entity Type
     *                 0 - Base class (never should be called)
     *                 IDs beginning with 1 are Enemies
     *                 IDs beginning with 2 are NPC/Friendlies
     * @return returns an object of a subclass of Entity
     *          object type depends on entityID
     */
    Entity getEntityInformation(int entityID) {
        String name;
        int lives, health;

        System.out.println("Enter Entity name: ");
        name = getUserInputAnswer();
        System.out.println("Enter Entity Lives: ");
        lives = Integer.parseInt(getUserInputAnswer());
        System.out.println("Enter Entity Health: ");
        health = Integer.parseInt(getUserInputAnswer());



        /*

        would much rather init all these values in the classes constructors
        this looks very messy

         */

        switch (firstDigit(entityID)) {

            case NPC.ID :

                String helpfulSkill;
                int skillLevel;

                System.out.println("Enter " + name + "'s helpful skill name");
                helpfulSkill = getUserInputAnswer();
                System.out.println("Enter " + name + "'s skill level: ");
                skillLevel = Integer.parseInt(getUserInputAnswer());

            switch (entityID) {
                case Mage.ID:

                    String damageType;
                    int yearsPracticing;

                    System.out.println("Enter " + name + "'s damage type:");
                    damageType = getUserInputAnswer();
                    System.out.println("Enter " + name + "'s amount of years spent practicing: ");
                    yearsPracticing = Integer.parseInt(getUserInputAnswer());

                    return new Mage(name, lives, health, helpfulSkill, skillLevel, damageType, yearsPracticing);
                case Trainer.ID:

                    String expertise;

                    System.out.println("Enter " + name + "'s expertise");
                    expertise = getUserInputAnswer();

                    return new Trainer(name, lives, health, helpfulSkill, skillLevel, expertise);
                default:
                break;
            }
            break;

            case Enemy.ID :

                String damageType;
                int damageLevel;

                System.out.println("Enter " + name + "'s damage type: ");
                damageType = getUserInputAnswer();
                System.out.println("Enter " + name + "'s damage level");
                damageLevel = Integer.parseInt(getUserInputAnswer());

            switch (entityID) {
                case Rogue.ID :

                    int sneakLevel;
                    boolean master;

                    System.out.println("Enter " + name + "'s sneak level: ");
                    sneakLevel = Integer.parseInt(getUserInputAnswer());
                    System.out.println("Is " + name + " a master? (Enter y/n)");
                    char c = ' ';
                    while (c != 'y' && c != 'n') {
                        c = getUserInputAnswer().charAt(0);
                        if (c != 'y' && c != 'n')
                            System.out.println("Invalid input enter y/n");
                    }
                    master = c == 'y';

                    return new Rogue(name, lives, health, damageType, damageLevel, sneakLevel, master);

                case Necromancer.ID :

                    int numMinions;
                    boolean elite;

                    System.out.println("Enter " + name + "'s number of minions: ");
                    numMinions = Integer.parseInt(getUserInputAnswer());
                    System.out.println("Is " + name + "elite? (Enter y/n)");
                    c = ' ';
                    while (c != 'y' && c != 'n') {
                        c = getUserInputAnswer().charAt(0);
                        if (c != 'y' && c != 'n')
                            System.out.println("Invalid input enter y/n");
                    }
                    elite = c == 'y';

                    return new Necromancer(name, lives, health, damageType, damageLevel, elite, numMinions);

                default:
                break;

            }
            break;

            default:
            break;
        }
        return null;
    }

    /**
     *
     * @param x integer to reduce to 1 digit
     * @return integer the first digit of the parameter
     */
    private int firstDigit(int x) {
        while (x > 9) {
            x /= 10;
        }
        return x;
    }

    /**
     * get one line of input from the user
     * @return the string input from the user
     */
    private String getUserInputAnswer() {

        String inputString = "";
        try {

            inputString = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return inputString;
    }

    /**
     * print the list of entities
     */
    public void printEntities() {

        if (entities.isEmpty()) {
            System.out.println("List is empty");
            displayMenu();
        }
        for (Entity e : entities) {
            System.out.println(e + "\n");
        }
        displayMenu();

    }

    /**
     *
     * @param max the maximum allowed user input
     *                  ex. menu options 1-5 then 5 would be max input
     * @return the user choice, an integer (0, max]
     *                  return -1 if an invalid option was entered
     *
     */
    private int getUserMenuInput(int max) {

        try {
            String inputString = reader.readLine();
            if (inputString.charAt(0) < 49 || inputString.charAt(0) > max + 48) {
                System.out.println("Invalid Input. Enter anything to start over");
                reader.read();
                return -1;
            }

            return inputString.charAt(0) - 48;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return -1;

    }


    

}