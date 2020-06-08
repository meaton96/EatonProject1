import entities.Entity;
import entities.enemies.Necromancer;
import entities.enemies.Rogue;
import entities.npc.Mage;
import entities.npc.Trainer;
import util.UserInputHelper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * The Class to run the project application
 */
public class ProjectApp {
    private static final List<String> ENTITY_NAME_LIST = List.of("Mage", "Necromancer", "Rogue", "Trainer");
    private final Map<String, Entity> entityMap;
    
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * init map and call first menu display
     */
    public ProjectApp() {
        entityMap = new LinkedHashMap<>();
        
        /* For testing purposes */
        
        Mage mage = new Mage("magey", 1, 70, "frostbolt", 1, "frost", 50);
        Trainer trainer = new Trainer("trainerguy", 1, 10, "spell", 1, "nothing");
        Trainer trainer1 = new Trainer("idiot", 1, 150, "spelll", 2, "nothing");
        entityMap.put(mage.getName(), mage);
        entityMap.put(trainer.getName(), trainer);
        entityMap.put(trainer1.getName(), trainer1);

    
        
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
        
        
        switch (UserInputHelper.getMenuInput(5)) {
            case 1:
                printEntities();
                break;
            case 2:
                addEntityMenu();
                break;
            case 3:
                removeEntity();
                break;
            case 4:
                performAction();
                break;
            case 5:
                System.out.println("Ending Program");
                break;
            default:
                System.out.println("Invalid input please try again\n");
                displayMenu();
                break;
        }
    }
    
    /**
     * Perform an action on an entity, action and entity are chosen by the user
     */
    public void performAction() {
        Entity e;
        System.out.println("Enter the name of the entity you would like to perform an action with: ");
        String input = UserInputHelper.getStringInput();
        e = findEntityInList(input);
        
        if (e != null) {
            System.out.println("Entity " + e.getName() + " found in list\n");
            boolean canFly = (e instanceof Mage || e instanceof Necromancer);
            
            System.out.println("Choose an action to perform (Enter a number): "
                                + "\n1. Speak"
                                + "\n2. Ready Up"
                                + "\n3. Move"
                                + (canFly ? "\n4. Fly" + "\n5. Teleport" : ""));
            
            int action = UserInputHelper.INVALID_INPUT;
            while (action == UserInputHelper.INVALID_INPUT)
                    action = UserInputHelper.getMenuInput(canFly ? 3 : 5);
            
            
            //not having these methods in the base class makes this so much messier
            switch (action) {
                case 1 :
                    if (e instanceof Mage)
                        ((Mage) e).speak();
                    else if (e instanceof Necromancer)
                        ((Necromancer) e).speak();
                    else if (e instanceof Trainer)
                        ((Trainer) e).speak();
                    else
                        ((Rogue) e).speak();
                    break;
                    
                case 2 :
                    if (e instanceof Mage)
                        ((Mage) e).ready();
                    else if (e instanceof Necromancer)
                        ((Necromancer) e).ready();
                    else if (e instanceof Trainer)
                        ((Trainer) e).ready();
                    else
                        ((Rogue) e).ready();
                    break;
                    
                case 3 :
                    if (e instanceof Mage)
                        ((Mage) e).move();
                    else if (e instanceof Necromancer)
                        ((Necromancer) e).move();
                    else if (e instanceof Trainer)
                        ((Trainer) e).move();
                    else
                        ((Rogue) e).move();
                    break;
                    
                case 4 :
                    if (e instanceof Mage)
                        ((Mage) e).fly();
                    else if (e instanceof Necromancer)
                        ((Necromancer) e).fly();
                    break;
    
                case 5 :
                    if (e instanceof Mage)
                        ((Mage) e).teleport();
                    else if (e instanceof Necromancer)
                        ((Necromancer) e).teleport();
                    break;
            }
            displayMenu();
        }
        System.out.println("Entity " + input + " not found in the list. Would you like to retype the name? (Enter y/n)");
    
        if (UserInputHelper.getBooleanInput())
            performAction();
        else
            displayMenu();
    }
    
    /**
     * remove an entity from the list
     * get user input for name of entity, compare to the list
     * and delete from list if it exists
     */
    public void removeEntity() {
        String name;
        System.out.println("Enter entity's name for deletion: ");
        name = UserInputHelper.getStringInput();
        //System.out.println(entityMap);
        
        if (entityMap.remove(name) != null) {
            System.out.println("Entity " + name + " was successfully removed from the list");
            return;
        }
        System.out.println("Entity " + name + " was not found in the list would you like to try entering the name again? (Enter y/n)");
        char c = ' ';
        while (c != 'y' && c != 'n') {
            c = UserInputHelper.getStringInput().charAt(0);
            if (c < 97) {
                c += 32;
            }
            //System.out.println("**" + c);
            if (c != 'y' && c != 'n') {
                System.out.println("Invalid input enter y/n");
            }
        }
        if (c == 'y') {
            removeEntity();
        }
        
        displayMenu();
    }
    
    /**
     * @param name String to search the list for
     * @return the Entity in the list if it exists
     * if it doesn't exist return null
     */
    private Entity findEntityInList(String name) {
        if (entityMap.isEmpty()) {
            return null;
        }
        return entityMap.get(name.toLowerCase());
    }
    
    /**
     * display choices of entities for adding to the list
     */
    public void addEntityMenu() {
        System.out.println("\nChoose an Entity to add: ");
        for (int i = 0; i < ENTITY_NAME_LIST.size(); i++) {
            String name = ENTITY_NAME_LIST.get(i);
            System.out.println(i + 1 + ". " + name);
        }
        
        System.out.println("Enter a number between 1 and " + ENTITY_NAME_LIST.size() + " to add to the list");
        Entity entityToAdd = null;
        
        //Mage Necromancer Rogue Trainer
        switch (UserInputHelper.getMenuInput(ENTITY_NAME_LIST.size())) {
            case -1:
                addEntityMenu();
                break;
            case 1:
                entityToAdd = getEntityInformation(Mage.ID);
                break;
            case 2:
                entityToAdd = getEntityInformation(Necromancer.ID);
                break;
            case 3:
                entityToAdd = getEntityInformation(Rogue.ID);
                break;
            case 4:
                entityToAdd = getEntityInformation(Trainer.ID);
                break;
            default:
                System.out.println("Invalid input please try again");
                addEntityMenu();
        }
        if (entityToAdd != null) {
            System.out.println("\nEntity: " + entityToAdd.getName() + " successfully added to list\n");
            entityMap.put(entityToAdd.getName().toLowerCase(), entityToAdd);
        }
        displayMenu();
    }
    
    /**
     * @param entityID Unique ID of Entity Type
     * @return returns an object of a subclass of Entity
     * object type depends on entityID
     */
    Entity getEntityInformation(int entityID) {
        switch (entityID) {
            case Rogue.ID:
                return new Rogue().build();
            case Necromancer.ID:
                return new Necromancer().build();
            case Mage.ID:
                return new Mage().build();
            case Trainer.ID:
                return new Trainer().build();
            default:
                break;
        }
        return null;
    }
    
    /**
     * print the list of entities
     */
    public void printEntities() {
    
        if (entityMap.isEmpty()) {
            System.out.println("List is empty");
            displayMenu();
        }
        
        Map<String, Entity> sortedMap = new LinkedHashMap<>();
    
        entityMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        
        
        for (Entity e : sortedMap.values()) {
            System.out.println(e + "\n");
        }
        displayMenu();
    }
}
