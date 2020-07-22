import java.util.*;
/**
 * This class is resonsible for generating and printing a tray of lithium
 * in the form of five lines of three integers. This is the starting point
 * of the project and creates an Array (called tray) which can be passed
 * throughout the other classes.
 *
 * Joe Thomas
 * 06/10/2019
 */
public class GenerateLithium
{
    /**
     * Created of a two dimentional Array.
     * Assigning the "grading" the in of 0.
     */
    int tray [][] = new int [5][3];
    private int grading = 0;
    private Random randomGenerator; //saving randomly generated numbers to Random

    /**
     * Constructor for objects of class GenerateLithium
     */
    public GenerateLithium()
    {
        randomGenerator = new Random();
    }

    /**
     * Uses a for loop to generate 15 integers which are equal and less than 50
     * When assingns the elemets to the two dimential Array "tray".
     */
    public void generateSample()
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                grading = randomGenerator.nextInt(50);  
                tray[i][j] = grading;
            }
        }
    }

    /**
     * Prints the generated lithium from generateSample().
     * Prints on five by three grid which is seperated by "||" to for the border.
     * uses two for loops, if and else statment.
     */
    public void printTray()
    {
        for (int i = 0; i < 5; i++)//outer loop
        {
            for (int j = 0; j < 3; j++)//inner loop
            {
                if (tray[i][j]>=10) { //allows grid to line up.
                    System.out.print(tray[i][j] + "||");//if int is two digits then don't input a space nect to "||".
                }
                else System.out.print(tray[i][j] + " ||");//if single digit input space.
            }
            System.out.println();
        }
    }

    /**
     * @return the two dimentional Array, tray. 
     * so that can be called amungst other classes.
     */
    public int [][] getTray()
    {
        return tray;
    }
}

