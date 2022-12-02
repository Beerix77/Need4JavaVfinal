/**
 * Utility Class to validate various user input.
 *
 * @author (Andrew Matysiak)
 * @version (v1.0)
 */

public class Utility
{
    /**
     * Method to check if String is blank
     *
     * @return      boolean value.
     */
    public static boolean isBlank(String data)
    {
        if (data.trim().length() == 0)
        {
            System.out.println("Input cannot be BLANK...");
            return true;
        }
        return false;
    }

    /**
     * Method to check if String length satisfies criteria.
     *
     * @return      boolean value.
     */
    public static boolean isLengthCorrect(String data, int minimumLength,
                                          int maximumLength)
    {
        if (data.trim().length() >= minimumLength &&
                data.trim().length() <= maximumLength)
        {
            return true;
        }
        System.out.println("Input must be between " + minimumLength + " and " +
                maximumLength + " characters inclusive.");
        return false;
    }
}
