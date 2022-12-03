import java.util.ArrayList;

/** Main class of game.
 *
 * @author (Andrew Matysiak)
 * @version (v1.0)
 */

public class Game
{
    /**
     * Method 'main' of class Game is entry point of program.
     *
     * @param args      an array ofStrings representing commands.
     */
    public static void main(String[] args)
    {
        boolean isEscaped = false;
        Reader reader = new Reader();
        ArrayList<Vehicle> listOfVehicles = reader.readVehicles();

        Player player = new Player();
        player.initialisePlayer();
        System.out.println("Welcome " + player.getName().trim() + "!");
        player.difficultySelect();
        player.vehicleSelect(listOfVehicles);

        Adjustment adjustment = new Adjustment();
        adjustment.fuelAdjustment(player.getDifficultyLevel(),
                player.getVehicleSelect().getMaxFuel());
        adjustment.highwayLength(player.getDifficultyLevel());
        System.out.print("Length of Highway: ");
        System.out.println(adjustment.getHighwayLength());
        System.out.print("MAX FUEL level due to Difficulty ");
        System.out.print(player.getDifficultyLevel() + " is: ");
        System.out.println((int) adjustment.getNewFuel());
        System.out.print("MAX DAMAGE sustainable to Vehicle ");
        System.out.print(player.getVehicleSelect().getVehicleType() + " is: ");
        System.out.println(player.getVehicleSelect().getMaxDamage());

        Obstacles obstacles = new Obstacles();
        obstacles.populate(adjustment.getHighwayLength(),
                player.getDifficultyLevel());

        Highway highway = new Highway();
        highway.addPlayerStart(obstacles.getRoad());

        Movement move = new Movement(player.getVehicleSelect().getBoostSpeed(), (int) adjustment.getNewFuel(), player.getVehicleSelect().getMaxDamage());
        highway.displayHighway(obstacles.getRoad());
        move.movement(highway.playerLocation(obstacles.getRoad()), obstacles.getRoad());

        try
        {
            do
            {
                highway.displayHighway(obstacles.getRoad());
                move.movement(highway.playerLocation(obstacles.getRoad()), obstacles.getRoad());
            }
            while (move.getCurrentFuel() > 0 && move.getCurrentDamage() < move.MAXIMUM_DAMAGE);   //todo: && move.getCurrentDamage() > 0);
            System.out.println("GAME OVER!!! ... YOU LOSE!");
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.print("CONGRATULATIONS " + player.getName() + "!! ");
            System.out.println("YOU HAVE ESCAPED!... END OF HIGHWAY REACHED!");
            System.out.print("Total FUEL remaining: " + move.getCurrentFuel()
                    + " of ");
            System.out.println(move.MAXIMUM_FUEL);
            System.out.print("Total DAMAGE accumulated: " + move.getCurrentDamage()
                    + " of ");
            System.out.println(move.MAXIMUM_DAMAGE);
            System.out.print("Distance Travelled: " + move.getDistance());
            System.out.println();
            isEscaped = true;
        }

        Output finalOutput = new Output();
        finalOutput.output(player.getVehicleSelect().getVehicleType(),
                move.getDistance(), move.getCurrentFuel(), move.getCurrentDamage(),
                move.MAXIMUM_FUEL, move.MAXIMUM_DAMAGE, isEscaped);
    }
}
