/**
 * Class for determining length of Highway and calculating Fuel amount based
 * on difficulty level chosen.
 *
 * @author (Andrew Matysiak)
 * @version (v1.0)
 */

public class Adjustment
{
    private int highwayLength;
    private double newFuel;

    /**
     * Default constructor which instantiates object of class Adjustment.
     *
     */
    public Adjustment()
    {
        highwayLength = 0;
        newFuel = 0.0;
    }

    /**
     * Display method.
     *
     */
    public void display()
    {
        System.out.print("Highway length: " + this.highwayLength);
        System.out.println(" New fuel level: " + this.newFuel);
    }

    /**
     * Method 'fuelAdjustment' to calculate new fuel maximum capacity.
     *
     *@param levelChosen         String representing difficulty level chosen.
     *@param fuelToBeAdjusted    int representing the current unadjusted
     *                           maximum fuel level.
     */
    public void fuelAdjustment(String levelChosen, int fuelToBeAdjusted)
    {
        if (levelChosen.equals("HARD"))
        {
            this.newFuel = fuelToBeAdjusted * 0.5;
        }
        else if (levelChosen.equals("MODERATE"))
        {
            this.newFuel = fuelToBeAdjusted * 0.8;
        }
        else
        {
            this.newFuel = fuelToBeAdjusted;
        }
    }

    /**
     * Getter method to return highway length.
     *
     * @return       int representing highway length.
     */
    public int getHighwayLength()
    {
        return this.highwayLength;
    }

    /**
     * Getter method to return new adjusted fuel level.
     *
     * @return       int representing adjusted fuel level.
     */
    public double getNewFuel()
    {
        return this.newFuel;
    }

    /**
     * Method 'highwayLength' to randomise highway length based on difficulty.
     *
     *@param levelChosen         String representing difficulty level chosen.
     *
     */
    public void highwayLength(String levelChosen)
    {
        if (levelChosen.equals("HARD"))
        {
            this.highwayLength = (int)(29 + Math.random() * 21 + 1);
        }
        else if (levelChosen.equals("MODERATE"))
        {
            this.highwayLength = (int)(14 + Math.random() * 16 + 1);
        }
        else
        {
            this.highwayLength = (int)(9 + Math.random() * 6 + 1);
        }
    }

    /**
     * Setter method to set highway length.
     *
     * @param newHighwayLength       int representing highway length.
     */
    public void setHighwayLength(int newHighwayLength)
    {
        this.highwayLength = newHighwayLength;
    }

    /**
     * Setter method to set adjusted maximum fuel level.
     *
     * @param newNewFuel      int representing adjusted maximum fuel level.
     */
    public void setNewFuel(int newNewFuel)
    {
        this.newFuel = newNewFuel;
    }
}
