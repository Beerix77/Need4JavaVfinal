import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for entering player's name, difficulty selection and 
 * vehicle selection.
 *
 * @author (Andrew Matysiak)
 * @version (v1.0)
 */

public class Player
{
    private String name;
    private String difficultyLevel;
    private Vehicle vehicle;


    /**
     * Default constructor which instantiates object of class Player.            
     *
     */
    public Player()
    {
        name = "Unknown";
        difficultyLevel = "Unknown";
        vehicle = new Vehicle();
    }

    /**
     * Method 'difficultySelect' stores difficulty level chosen.
     *
     */
    public void difficultySelect()
    {
        Scanner keyboard = new Scanner(System.in);
        String choice = "";
        do
        {
            System.out.print("Select difficulty level: EASY, MODERATE or ");
            System.out.print("HARD: ");
            choice = keyboard.nextLine().toLowerCase().trim();
        }
        while(!choice.equals("e") && !choice.equals("easy") &&
                !choice.equals("m") && !choice.equals("moderate") &&
                !choice.equals("h") && !choice.equals("hard"));

        // store difficulty level chosen.
        switch (choice)
        {
            case "easy", "e" ->
            {
                System.out.println("You have chosen Easy");
                this.difficultyLevel = "EASY";
            }
            case "moderate", "m" ->
            {
                System.out.println("You have chosen Moderate");
                this.difficultyLevel = "MODERATE";
            }
            case "hard", "h" ->
            {
                System.out.println("You have chosen Hard");
                this.difficultyLevel = "HARD";
            }
        }
        System.out.print("**********************");
    }

    /**
     * Display method.
     *
     */
    public void display()
    {
        System.out.print("Name is: " + this.name + " Difficulty chosen is: ");
        System.out.print(this.difficultyLevel + " Vehicle: ");
        System.out.println(vehicle.getVehicleType());
    }

    /**
     * Getter method to return difficultyLevel.
     *
     * @return            String representing difficulty level chosen.
     */
    public String getDifficultyLevel()
    {
        return this.difficultyLevel;
    }

    /**
     * Getter method to return name value.
     *
     * @return            String representing player name.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Getter method to return Vehicle chosen.
     *
     * @return            returns selection as Vehicle object.
     */
    public Vehicle getVehicleSelect()
    {
        return this.vehicle;
    }

    /**
     * Method 'initialisePlayer' stores player name whilst checking it meets
     * criteria.
     *
     */
    public void initialisePlayer()
    {
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        System.out.println();
        System.out.println("**** NEED 4 JAVA ****");
        System.out.println("*********************");
        do
        {
            System.out.println("Please enter your name ");
            System.out.print("Name must be (3-12) characters and not be ");
            System.out.print("BLANK....");
            System.out.print("\n> ");
            input = keyboard.nextLine();
        }
        while (Utility.isBlank(input) ||
                !Utility.isLengthCorrect(input, 3, 12));
        setName(input);
    }

    /**
     * Setter method to set difficulty level chosen.
     *
     * @param newLevel            String representing chosen difficulty.
     */
    public void setDifficultyLevel(String newLevel)
    {
        this.difficultyLevel = newLevel;
    }

    /**
     * Setter method to set name value.
     *
     * @param newName             String representing player name.
     */
    public void setName(String newName)
    {
        this.name = newName;
    }

    /**
     * Setter method to set vehicle chosen.
     *
     * @param newVehicleSelect             representing chosen vehicle.
     */
    public void setVehicleSelect(Vehicle newVehicleSelect)
    {
        this.vehicle = newVehicleSelect;
    }

    /**
     * Method 'vehicleSelect' lists vehicle menu and stores selection.
     *
     * @param listOfVehicles              an ArrayList of Vehicles.
     */
    public void vehicleSelect(ArrayList<Vehicle> listOfVehicles)
    {
        while (true)
        {
            Scanner keyboard = new Scanner(System.in);
            try
            {
                System.out.println();
                System.out.print("Select ESCAPE VEHICLE using Numerals only");
                System.out.println("..." + "(1-" + listOfVehicles.size() +
                        ")");
                System.out.println();

                for (int i = 0; i < listOfVehicles.size(); i++)
                {
                    System.out.println((i + 1) + ") " +
                            listOfVehicles.get(i).getVehicleType() + " - BOOST: " +
                            listOfVehicles.get(i).getBoostSpeed() + ", FUEL: " +
                            listOfVehicles.get(i).getMaxFuel() + ", DAMAGE: " +
                            listOfVehicles.get(i).getMaxDamage());
                }
                System.out.println();
                System.out.print("Vehicle selection: ");
                int choice = Integer.parseInt(keyboard.nextLine());
                Utility.isBlank(Integer.toString(choice));
                System.out.println("**********************");
                vehicle = new Vehicle();
                vehicle.setVehicleType(listOfVehicles.get(choice - 1).
                        getVehicleType());
                vehicle.setBoostSpeed(listOfVehicles.get(choice - 1).
                        getBoostSpeed());
                vehicle.setMaxFuel(listOfVehicles.get(choice - 1).
                        getMaxFuel());
                vehicle.setMaxDamage(listOfVehicles.get(choice - 1).
                        getMaxDamage());
                System.out.println("You have chosen: " +
                        vehicle.getVehicleType());
                System.out.println();
                break;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Invalid entry. Input must be numerical.");
            }
            catch(IndexOutOfBoundsException e)
            {
                System.out.println("Invalid entry. Input out of bounds.");
            }
        }
    }
}
            