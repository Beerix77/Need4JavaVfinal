import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for setting new player position upon movement selection and check for
 * collisions with obstacles while calculating adjustments to fuel and damage
 * levels.
 * Additional features include displaying any obstacles landed on while moving,
 * or traversed while boosting, current Fuel level, current Damage sustained
 * and current Distance travelled.
 *
 * @author (Andrew Matysiak)
 * @version (v1.0)
 */

public class Movement
{
    public final int BOOST_SPEED;
    public final int MAXIMUM_FUEL;
    public final int MAXIMUM_DAMAGE;
    private int currentFuel;
    private int currentDamage;
    private int distance;


    /**
     * Default constructor which instantiates object of class Movement.
     *
     */
    public Movement()
    {
        BOOST_SPEED = 0;
        MAXIMUM_FUEL = 0;
        MAXIMUM_DAMAGE = 0;
        currentFuel = 0;
        currentDamage = 0;
        distance = 0;
    }

    /**
     * Non-Default constructor which instantiates object of class Movement.
     *
     */
    public Movement(int boostSpeed, int maximumFuel, int maximumDamage)
    {
        BOOST_SPEED = boostSpeed;
        MAXIMUM_FUEL = maximumFuel;
        MAXIMUM_DAMAGE = maximumDamage;
        currentFuel = MAXIMUM_FUEL;
        currentDamage = MAXIMUM_DAMAGE;
        distance = 0;
    }

    /**
     * Display method.
     *
     */
    public void display()
    {
        System.out.print("Current Fuel: " + this.currentFuel);
        System.out.print(" Current Damage: " + this.currentDamage);
        System.out.println(" Distance: " + this.distance);
    }

    /**
     * Getter method to return current Damage.
     *
     * @return       int representing current damage value.
     */
    public int getCurrentDamage()
    {
        return this.currentDamage;
    }

    /**
     * Getter method to return current Fuel.
     *
     * @return       int representing current fuel value.
     */
    public int getCurrentFuel()
    {
        return this.currentFuel;
    }

    /**
     * Getter method to return current Distance.
     *
     * @return       int representing current distance.
     */
    public int getDistance()
    {
        return this.distance;
    }

    /**
     * Method 'movement' for input movement and calculate/determine
     * resource/collision outcomes and display extra features.
     *
     * @param playerLane       int of player index location.
     * @param road                 ArrayList<ArrayList<String>> of highway.
     */
    public void movement(int playerLane, ArrayList<ArrayList<String>> road)
    {
        Scanner keyboard = new Scanner(System.in);
        int fuel = 0;
        int block = 0;
        int spikes = 0;
        int manhole = 0;
        int playerIndex = road.get(playerLane).indexOf("@");
        String itemBeneath = "";
        String moveChoice = "";

        do
        {
            System.out.println();
            System.out.println("Forward: 'F'");
            System.out.println("Swerve Up: 'U'");
            System.out.println("Swerve Down: 'D'");
            System.out.println("Boost: 'B'");
            System.out.println("Quit: 'Q'");
            System.out.println();
            System.out.print("Enter choice: ");
            moveChoice = keyboard.nextLine().toUpperCase();
            System.out.println("******************************");
        }
        while(!moveChoice.equals("F") && !moveChoice.equals("U") &&
                !moveChoice.equals("D") && !moveChoice.equals("B") &&
                !moveChoice.equals("Q") && !moveChoice.equals("QUIT"));
        if (moveChoice.equals("Q") || moveChoice.equals("QUIT"))
        {
            System.out.println("You QUIT the game...");
            System.exit(0);
        }

        // 'FORWARD' movement below.
        else if (moveChoice.equals("F") && road.get(playerLane).size() > 10)
        {
            currentFuel--;
            distance++;
            if(!road.get(playerLane).get(1).equals("."))
            {
                itemBeneath = road.get(playerLane).get(1);
                System.out.print("Moved FORWARD. Item landed on was: ");
                System.out.println(itemBeneath);

                switch (itemBeneath)
                {
                    case "F" -> fuel++;
                    case "B" -> block++;
                    case "S" -> spikes++;
                    case "O" -> manhole++;
                    default ->
                    {
                    }
                }
            }

            road.get(playerLane).set(playerIndex + 1, "@");
            road.get(0).remove(0);
            road.get(1).remove(0);
            road.get(2).remove(0);
        }
        // 'FORWARD' movement below if 10 sections remaining.
        else if (moveChoice.equals("F") && road.get(playerLane).size() <= 10)
        {
            currentFuel--;
            distance++;

            if(!road.get(playerLane).get(playerIndex + 1).equals("."))
            {
                itemBeneath = road.get(playerLane).get(playerIndex + 1);
                System.out.print("Moved FORWARD. Item landed on was: ");
                System.out.println(itemBeneath);

                switch (itemBeneath)
                {
                    case "F" -> fuel++;
                    case "B" -> block++;
                    case "S" -> spikes++;
                    case "O" -> manhole++;
                    default ->
                    {
                    }
                }
            }
            road.get(playerLane).set(playerIndex, ".");
            road.get(playerLane).set(playerIndex + 1, "@");
        }

        //'SWERVE UP' movement if all highway sections not yet displayed.
        else if (moveChoice.equals("U") && playerLane != 0 && road.get(playerLane).size() > 10)
        {
            currentFuel -= 2;
            distance += 2;

            if(!road.get(playerLane - 1).get(1).equals("."))
            {
                itemBeneath = road.get(playerLane - 1).get(1);
                System.out.print("Swerved UP. Item landed on was: ");
                System.out.println(itemBeneath);

                switch(itemBeneath)
                {
                    case "F" -> fuel++;
                    case "B" -> block++;
                    case "S" -> spikes++;
                    case "O" -> manhole++;
                    default ->
                    {
                    }
                }
            }

            road.get(playerLane - 1).set(playerIndex + 1, "@");
            road.get(0).remove(0);
            road.get(1).remove(0);
            road.get(2).remove(0);
        }
        //'SWERVE UP' movement below if 10 sections remaining.
        else if (moveChoice.equals("U") && playerLane != 0 &&
                road.get(playerLane).size() <= 10)
        {
            currentFuel -= 2;
            distance += 2;

            if(!road.get(playerLane - 1).get(playerIndex + 1).equals("."))
            {
                itemBeneath = road.get(playerLane - 1).get(playerIndex + 1);
                System.out.print("Swerved UP. Item landed on was: ");
                System.out.println(itemBeneath);

                switch(itemBeneath)
                {
                    case "F" -> fuel++;
                    case "B" -> block++;
                    case "S" -> spikes++;
                    case "O" -> manhole++;
                    default ->
                    {
                    }
                }
            }

            road.get(playerLane).set(playerIndex, ".");
            road.get(playerLane - 1).set(playerIndex + 1, "@");
        }

        /*
        'SWERVE DOWN' movement below if highway sections still not
        displayed ie > 10.
        */
        else if (moveChoice.equals("D") && playerLane != 2 &&
                road.get(playerLane).size() > 10)
        {
            currentFuel -= 2;
            distance += 2;

            if(!road.get(playerLane + 1).get(1).equals("."))
            {
                itemBeneath = road.get(playerLane + 1).get(1);
                System.out.print("Swerved DOWN. Item landed on was: ");
                System.out.println(itemBeneath);

                switch(itemBeneath)
                {
                    case "F" -> fuel++;
                    case "B" -> block++;
                    case "S" -> spikes++;
                    case "O" -> manhole++;
                    default ->
                    {
                    }
                }
            }

            road.get(playerLane + 1).set(playerIndex + 1, "@");
            road.get(0).remove(0);
            road.get(1).remove(0);
            road.get(2).remove(0);
        }
        //'SWERVE DOWN' movement below if 10 sections remaining.
        else if (moveChoice.equals("D") && playerLane != 2 &&
                road.get(playerLane).size() <= 10)
        {
            currentFuel -= 2;
            distance += 2;

            if(!road.get(playerLane + 1).get(playerIndex + 1).equals("."))
            {
                itemBeneath = road.get(playerLane + 1).get(playerIndex + 1);
                System.out.print("Swerved DOWN. Item landed on was: ");
                System.out.println(itemBeneath);

                switch(itemBeneath)
                {
                    case "F" -> fuel++;
                    case "B" -> block++;
                    case "S" -> spikes++;
                    case "O" -> manhole++;
                    default ->
                    {
                    }
                }
            }
            road.get(playerLane).set(playerIndex, ".");
            road.get(playerLane + 1).set(playerIndex + 1, "@");
        }


        /*
         'BOOST' movement below also checks if sufficient fuel for BOOST and
         tallies all obstacles traversed.
        */

        //'BOOST' consequence if less than 'BOOST SPEED' sections remaining.
        else if (moveChoice.equals("B") && road.get(playerLane).indexOf("@")
                >= (10 - BOOST_SPEED) && (road.get(playerLane).size() == 10))
        {
            System.out.print("Cannot do BOOST as remaining highway is too ");
            System.out.println("short!...\n");
        }
        //'BOOST' if final 10 sections of highway displaying.
        else if (moveChoice.equals("B") && currentFuel >= (BOOST_SPEED * 3) &&
                (road.get(playerLane).size() <= 10))
        {
            currentFuel = currentFuel - (BOOST_SPEED * 3);
            distance = distance + BOOST_SPEED;

            for (int i = playerIndex; i <= playerIndex + BOOST_SPEED; i++)
            {
                switch(road.get(playerLane).get(i))
                {
                    case "F" -> fuel++;
                    case "B" -> block++;
                    case "S" -> spikes++;
                    case "O" -> manhole++;
                    default ->
                    {
                    }
                }
            }

            road.get(playerLane).set(playerIndex, ".");
            playerIndex += BOOST_SPEED;
            road.get(playerLane).set(playerIndex, "@");

            System.out.print("Items traversed while BOOSTING:\n");
            System.out.print("FUEL: " + fuel);
            System.out.print("\nROADBLOCKS: " + block);
            System.out.print("\nTYRE SPIKES: " + spikes);
            System.out.print("\nMANHOLES: " + manhole);
            System.out.println();
        }
        //'BOOST' if GREATER than 10 sections of highway remaining.
        else if (moveChoice.equals("B") && currentFuel >= (BOOST_SPEED * 3) &&
                (road.get(playerLane).size() > 10))
        {
            currentFuel = currentFuel - (BOOST_SPEED * 3);
            distance = distance + BOOST_SPEED;

            for (int i = playerIndex; i <= playerIndex + BOOST_SPEED; i++)
            {
                switch(road.get(playerLane).get(i))
                {
                    case "F" -> fuel++;
                    case "B" -> block++;
                    case "S" -> spikes++;
                    case "O" -> manhole++;
                    default ->
                    {
                    }
                }
            }

            int playerIndexBoostLarge = road.get(playerLane).indexOf("@");
            playerIndexBoostLarge += BOOST_SPEED;
            road.get(playerLane).set(playerIndexBoostLarge, "@");
            /*
            if 'BOOST' selected, and consequently it results in Highway
            having to display 'remaining' 10 sections (nested).
            */
            if (road.get(playerLane).size() > 10 && road.get(playerLane).size()
                    <= (10 + BOOST_SPEED))
            {
                int playerIndexBoostSmall = road.get(playerLane).size();
                for(int i = 10; i < playerIndexBoostSmall; i++)
                {
                    road.get(0).remove(0);
                    road.get(1).remove(0);
                    road.get(2).remove(0);
                }
            }
            else
            {
                for(int i = 0; i < BOOST_SPEED; i++)
                {
                    road.get(0).remove(0);
                    road.get(1).remove(0);
                    road.get(2).remove(0);
                }
            }

            System.out.print("Items traversed while BOOSTING:\n");
            System.out.print("FUEL: " + fuel);
            System.out.print("\nROADBLOCKS: " + block);
            System.out.print("\nTYRE SPIKES: " + spikes);
            System.out.print("\nMANHOLES: " + manhole);
            System.out.println();
        }
        else if (moveChoice.equals("B") && currentFuel <= (BOOST_SPEED * 3))
        {
            System.out.println("Not enough FUEL remaining for BOOST move...\n");
            System.out.println();
        }
        else
        {
            System.out.println("You cannot swerve off the Highway...\n");
            System.out.println();
        }

        // Calculate FUEL pickups:
        currentFuel = (currentFuel + (fuel * 10));
        if (currentFuel > MAXIMUM_FUEL)
        {
            currentFuel = MAXIMUM_FUEL;
        }
        else if(currentFuel <= 0)
        {
            System.out.println("You are out of FUEL!!!...");
        }

        // Calculate DAMAGE sustained:
        int damage = (block * 20) + (spikes * 45) + (manhole * 60);
        if (damage >= currentDamage)
        {
            System.out.println("Vehicle has been Destroyed!!!...");
            currentDamage = 0;
        }
        else
        {
            currentDamage = currentDamage - damage;
        }
        System.out.print("Current FUEL remaining: " + currentFuel + " of ");
        System.out.println(this.MAXIMUM_FUEL);
        System.out.print("Current DAMAGE remaining: " + currentDamage +
                " of ");
        System.out.println(this.MAXIMUM_DAMAGE);
        System.out.print("Current Distance Travelled: " + distance);
        System.out.println();
    }

    /**
     * Setter method to set current damage level.
     *
     * @param newCurrentDamage      int representing current damage level.
     */
    public void setCurrentDamage(int newCurrentDamage)
    {
        this.currentDamage = newCurrentDamage;
    }

    /**
     * Setter method to set current fuel level.
     *
     * @param newCurrentFuel      int representing current fuel level.
     */
    public void setCurrentFuel(int newCurrentFuel)
    {
        this.currentFuel = newCurrentFuel;
    }

    /**
     * Setter method to set current distance travelled.
     *
     * @param newDistance    int representing current total distance travelled.
     */
    public void setDistance(int newDistance)
    {
        this.distance = newDistance;
    }
}
