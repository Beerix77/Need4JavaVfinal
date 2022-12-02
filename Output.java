import java.io.FileWriter;
import java.io.IOException;

/**
 * Class used to 'Write' player achievements to file 'output.txt'.
 *
 * @author (Andrew Matysiak)
 * @version (v1.0)
 */

public class Output
{
    /**
     * Method 'output' writes player achievements to file 'output.txt'.
     *
     * @param vehicle         String of vehicle chosen.
     * @param distance        int of total distance travelled.
     * @param remainingFuel   int of remaining fuel.
     * @param remainingDamage int of remaining damage.
     * @param maximumFuel     int of initial, difficulty adjusted fuel.
     * @param maximumDamage   int of initial, difficulty adjusted damage.
     * @param isEscaped       boolean value of whether player has escaped.
     *
     */
    public void output(String vehicle, int distance, int remainingFuel,
                       int remainingDamage, int maximumFuel, int maximumDamage,
                       boolean isEscaped)
    {
        try
        {
            FileWriter summary = new FileWriter("output.txt");
            summary.write("**** NEED 4 JAVA Endgame Result ****\n\n" +
                    "Vehicle: " + vehicle + "\nFuel remaining: " + remainingFuel +
                    " of " + maximumFuel + "\nDamage remaining: " + remainingDamage +
                    " of " + maximumDamage + "\nDistance covered: " + distance +
                    "\nPlayer escaped?: " + isEscaped);
            try
            {
                summary.close();
            }
            catch(IOException e)
            {
                System.out.println("Error closing to file...");
                System.exit(0);
            }
        }
        catch(IOException e)
        {
            System.out.println("Error writing to file...");
            System.exit(0);
        }
    }
}
