/**
 * Class for Vehicle template with all attributes.
 *
 * @author (Andrew Matysiak)
 * @version (v1.0)
 */

public class Vehicle
{
    private String vehicleType;
    private int boostSpeed;
    private int maxFuel;
    private int maxDamage;


    /**
     * Default constructor which instantiates object of class Vehicle.
     *
     */
    Vehicle()
    {
        vehicleType = "Unknown";
        boostSpeed = 0;
        maxFuel = 0;
        maxDamage = 0;
    }

    /**
     * Non-Default constructor which instantiates object of class Vehicle.
     * Attributes are read from file 'vehicles.txt' using Reader Class.
     *
     * @param vehicleType         String of vehicle type.
     * @param boostSpeed          int of boost speed for vehicle.
     * @param maxFuel             int of maximum fuel prior to adjustment.
     * @param maxDamage           int of maximum damage prior to adjustment.
     *
     */
    Vehicle(String vehicleType, int boostSpeed, int maxFuel, int maxDamage)
    {
        this.vehicleType = vehicleType;
        this.boostSpeed = boostSpeed;
        this.maxFuel = maxFuel;
        this.maxDamage = maxDamage;
    }

    /**
     * Display method.
     *
     */
    public void display()
    {
        System.out.print("Vehicle: " + this.vehicleType + " Boost: " +
                this.boostSpeed + "Fuel: " + this.maxFuel + "Damage: " +
                this.maxDamage);
    }

    /**
     * Getter method to return Boost Speed.
     *
     * @return            int representing boost speed.
     */
    public int getBoostSpeed()
    {
        return this.boostSpeed;
    }

    /**
     * Getter method to return Damage level.
     *
     * @return            int representing damage level.
     */
    public int getMaxDamage()
    {
        return this.maxDamage;
    }

    /**
     * Getter method to return maximum Fuel level.
     *
     * @return            int representing fuel level.
     */
    public int getMaxFuel()
    {
        return this.maxFuel;
    }

    /**
     * Getter method to return Vehicle Type.
     *
     * @return            String representing vehicle.
     */
    public String getVehicleType()
    {
        return this.vehicleType;
    }

    /**
     * Setter method to set boost speed.
     *
     * @param newBoostSpeed           int representing Boost speed.
     */
    public void setBoostSpeed(int newBoostSpeed)
    {
        boostSpeed = newBoostSpeed;
    }

    /**
     * Setter method to set maximum Damage.
     *
     * @param newMaxDamage          int representing maximum damage.
     */
    public void setMaxDamage(int newMaxDamage)
    {
        maxDamage = newMaxDamage;
    }

    /**
     * Setter method to set maximum Fuel.
     *
     * @param newMaxFuel           int representing maximum fuel.
     */
    public void setMaxFuel(int newMaxFuel)
    {
        maxFuel = newMaxFuel;
    }

    /**
     * Setter method to set Vehicle type.
     *
     * @param newVehicleType           String representing vehicle.
     */
    public void setVehicleType(String newVehicleType)
    {
        vehicleType = newVehicleType;
    }
}
