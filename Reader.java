import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to read a file called 'vehicle.txt' for vehicle information.
 *
 * @author (Andrew Matysiak)
 * @version (v1.0)
 */

public class Reader
{
    /**
     * Default constructor which instantiates object of class Reader.
     *
     */
    public Reader()
    {
    }

    /**
     * Method 'readVehicles' reads 'vehicles.txt' and creates an ArrayList
     * 'vehicleList' of Vehicles.
     *
     *@return            ArrayList of Vehicles.
     */
    public ArrayList<Vehicle> readVehicles()
    {
        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
        try
        {
            FileReader reader = new FileReader("vehicles.txt");
            try
            {
                Scanner fileInput = new Scanner(reader);
                while (fileInput.hasNextLine())
                {
                    String firstElement;
                    int secondElement;
                    int thirdElement;
                    int fourthElement;
                    try
                    {
                        String[] item = fileInput.nextLine().split(",");
                        firstElement = item[0];
                        secondElement = Integer.parseInt(item[1]);
                        thirdElement = Integer.parseInt(item[2]);
                        fourthElement = Integer.parseInt(item[3]);
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error allocating data...");
                        continue;
                    }
                    /*
                    Code block below creates an ArrayList 'vehicleList' of new
                     Vehicle objects containing their 4 data attributes.
                    */
                    vehicleList.add(new Vehicle(firstElement, secondElement,
                            thirdElement, fourthElement));
                }
            }
            catch (Exception e)
            {
                System.out.println("Error reading file...");
                System.exit(0);
            }
            finally
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    System.out.println("Error closing file...");
                    System.exit(0);
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: File not found!..");
            System.exit(0);
        }
        return vehicleList;
    }
}
