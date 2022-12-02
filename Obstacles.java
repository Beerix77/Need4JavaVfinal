import java.util.ArrayList;

/**
 * Class for generating obstacles.
 *
 * @author (Andrew Matysiak)
 * @version (v1.0)
 */

public class Obstacles
{
    public final int OBSTACLES_EASY = 12;
    public final int OBSTACLES_MODERATE = 24;
    public final int OBSTACLES_HARD = 45;

    private ArrayList<String> laneOne;
    private ArrayList<String> laneTwo;
    private ArrayList<String> laneThree;
    private ArrayList<ArrayList<String>> road;
    private int obstacleCount;
    private int totalObstacles;

    /**
     * Default constructor which instantiates object of class Obstacles.
     *
     */
    public Obstacles()
    {
        laneOne = new ArrayList<String>();
        laneTwo = new ArrayList<String>();
        laneThree = new ArrayList<String>();
        road = new ArrayList<ArrayList<String>>();
        obstacleCount = 0;
        totalObstacles = 0;
    }

    /**
     * Display method.
     *
     */
    public void display()
    {
        System.out.print("Lane 1: " + this.laneOne + "\nLane 2: ");
        System.out.print(this.laneTwo + "\nLane 3: " + this.laneThree);
        System.out.println("\nHighway Array " + this.road);
    }

    /**
     * Method 'generate' to randomly generate highway.
     *
     * @param highwayLength          int of highway length previously generated.
     */
    public ArrayList<String> generate(int highwayLength)
    {
        ArrayList<String> lane = new ArrayList<String>();
        //lane generation
        for (int i = 0; i < highwayLength; i++)
        {
            lane.add(".");
        }
        //use j = 3 in lane to not generate obstacle in first 3 sections.
        for (int j = 3; j < highwayLength; j++)
        {
            int randomObstacles = (int) (Math.random() * 3);
            if (randomObstacles != 0)       //this creates the 1/3 chance.
            {
                continue;
            }
            int random = (int) (Math.random() * 10 + 1);
            String obstacle = " ";
            switch (random)
            {
                case 1, 2, 3 -> obstacle = "F";
                case 4, 5, 6, 7 -> obstacle = "B";
                case 8, 9 -> obstacle = "S";
                case 10 -> obstacle = "O";
                default ->
                {
                }
            }
            if (obstacleCount < totalObstacles)
            {
                lane.set(j, obstacle);
                obstacleCount++;
            }
        }
        return lane;
    }

    /**
     * Getter method to return lane one.
     *
     * @return        ArrayList<String> representing as Array (lane one).
     */
    public ArrayList<String> getLaneOne()
    {
        return this.laneOne;
    }

    /**
     * Getter method to return lane three.
     *
     *@return        ArrayList<String> representing as Array (lane three).
     */
    public ArrayList<String> getLaneThree()
    {
        return this.laneThree;
    }

    /**
     * Getter method to return lane two.
     *
     *@return        ArrayList<String> representing as Array (lane two).
     */
    public ArrayList<String> getLaneTwo()
    {
        return this.laneTwo;
    }

    /**
     * Getter method to return obstacleCount.
     *
     *@return        int number of obstacle count.
     */
    public int getObstacleCount()
    {
        return this.obstacleCount;
    }

    /**
     * Getter method to return highway.
     *
     *@return        ArrayList<ArrayList<String>> representing an ArrayList
     *               of ArrayLists (lanes x3).
     */
    public ArrayList<ArrayList<String>> getRoad()
    {
        return this.road;
    }

    /**
     * Getter method to return total obstacles.
     *
     *@return        int number of total obstacles.
     */
    public int getTotalObstacles()
    {
        return this.totalObstacles;
    }

    /**
     * Method 'populate' to set up obstacle number based on difficulty and
     * construct highway with Arraylists.
     *
     * @param highwayLength          int of highway length previously generated.
     * @param levelChosen            String of the difficulty level chosen.
     */
    public void populate(int highwayLength, String levelChosen)
    {
        if (levelChosen.equals("HARD"))
        {
            totalObstacles = OBSTACLES_HARD;
        }
        else if (levelChosen.equals("MODERATE"))
        {
            totalObstacles = OBSTACLES_MODERATE;
        }
        else
        {
            totalObstacles = OBSTACLES_EASY;
        }

        laneOne = generate(highwayLength);
        road.add(this.laneOne);

        laneTwo = generate(highwayLength);
        road.add(this.laneTwo);

        laneThree = generate(highwayLength);
        road.add(this.laneThree);
    }

    /**
     * Setter method to set lane one.
     *
     * @param newLaneOne         ArrayList<String> representing lane one.
     */
    public void setLaneOne(ArrayList<String> newLaneOne)
    {
        this.laneOne = newLaneOne;
    }

    /**
     * Setter method to set lane three.
     *
     * @param newLaneThree         ArrayList<String> representing lane three.
     */
    public void setLaneThree(ArrayList<String> newLaneThree)
    {
        this.laneThree = newLaneThree;
    }

    /**
     * Setter method to set lane two.
     *
     * @param newLaneTwo         ArrayList<String> representing lane two.
     */
    public void setLaneTwo(ArrayList<String> newLaneTwo)
    {
        this.laneTwo = newLaneTwo;
    }

    /**
     * Setter method to set obstacle count.
     *
     * @param newObstacleCount      int representing number of obstacles.
     */
    public void setObstacleCount(int newObstacleCount)
    {
        this.obstacleCount = newObstacleCount;
    }

    /**
     * Setter method to set highway.
     *
     * @param newRoad      ArrayList<ArrayList<String>> representing a highway.
     */
    public void setRoad(ArrayList<ArrayList<String>> newRoad)
    {
        this.road = newRoad;
    }

    /**
     * Setter method to set total obstacle count.
     *
     * @param newTotalObstacles      int representing total obstacles.
     */
    public void setTotalObstacles(int newTotalObstacles)
    {
        this.totalObstacles = newTotalObstacles;
    }
}
