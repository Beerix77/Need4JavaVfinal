import java.util.ArrayList;

/**
 * Class to display highway and player location.
 *
 * @author (Andrew Matysiak)
 * @version (v1.0)
 */

public class Highway
{
    /**
     * Default constructor which instantiates object of class Highway.
     *
     */
    public Highway()
    {
    }

    /**
     * Method 'addPlayerStart' to randomly place player in first section
     * of one of three lanes.
     *
     * @param road           ArrayList<ArrayList<String>> of highway.
     */
    public void addPlayerStart(ArrayList<ArrayList<String>> road)
    {
        int location = (int)(Math.random() * 3);
        road.get(location).set(0, "@");
    }

    /**
     * Method 'displayHighway' to display at most, 10 sections of populated
     * highway and player start position.
     *
     * @param road           ArrayList<ArrayList<String>> of highway.
     */
    public void displayHighway(ArrayList<ArrayList<String>> road)
    {
        if (road.get(1).size() > 10)          // using lane two for reference.
        {
            for (ArrayList<String> sections : road)
            {
                System.out.println();
                for (int j = 0; j < sections.size() - (sections.size() - 10);
                     j++)
                {
                    System.out.print(sections.get(j));
                }
            }
        }
        //Display remaining highway if distance to end is 10 or less.
        else if (road.get(1).size() <= 10)
        {
            for (ArrayList<String> i : road)
            {
                System.out.println();
                for (String section : i)
                {
                    System.out.print(section);
                }
            }
        }
        System.out.println();
    }

    /**
     * Method 'playerLocation' for determining player lane index location.
     *
     * @param road               ArrayList<ArrayList<String>> of highway.
     * @return playerIndex       int of player index location.
     */
    public int playerLocation(ArrayList<ArrayList<String>> road)
    {
        int playerIndex = -1;

        if (road.get(0).contains("@"))
        {
            playerIndex = 0;
        }
        else if (road.get(1).contains("@"))
        {
            playerIndex = 1;
        }
        else
        {
            playerIndex = 2;
        }
        return playerIndex;
    }
}
