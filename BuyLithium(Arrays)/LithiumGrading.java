import java.util.*;

/**
 * This calss makes use of the tray of lithium created in the GenaerateLithium class
 * so that the lithium can be graded, as it is important for customers
 * to buy highly graded lithium.
 * Sorts grades of lithium from high to low. 
 * Consists of two methods which seperates the grades into two ArrayLists
 * and then sorts them in accending order.
 *
 * @Joe Thomas
 * @11/10/2019
 */
public class LithiumGrading 
{ 
    //Creates two ArrayLists which will then store the integers Array in GenerateLithium class.
    private ArrayList<Integer> highGrade = new ArrayList<Integer>();; //Creates first ArrayList called "highGrade"
    private ArrayList<Integer> lowGrade = new ArrayList<Integer>(); //Creates second ArrayList called "LowGrades"

    int [][] tray;

    /**
     * Constructor for object of the class LithiumGrading.
     * creating a method which calls the getTray which is returned in GenerateLithium.
     * calls the GenerateLithium class, creates new version and saves it in 
     * generatelithium which then allows us to access its methods.
     */
    public LithiumGrading(GenerateLithium generatelithium)
    {
       tray = generatelithium.getTray(); 
    }

    /**
     * @param takes Array from GenerateLithium as a parameter.
     * Determins if it's a high quality of lithium or not. If integer in tray
     * is higher than 25 put the integer into the "highGrade" ArrayList
     * else store it in "lowGrade"
     * Class makes use of two for loops. An outer and inner.
     * Takes the fist integer from the tray. compares it again the max int of 25.
     */
    public void GenerateGrades(int[][] tray) 
    {
        int max = 25; //setting the maxium limit. Given the if statment for comparison.
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (tray[i][j]> max)
                {
                    highGrade.add(tray[i][j]);
                }
                else
                {
                    lowGrade.add(tray[i][j]);
                }
            }
        }
    }

    /**
     * Two bubble sorts which sort low-grades as well as high-grades in ascending order.
     * Iterates through the highGrade ArrayList, compares elements with one another
     * swaps if the first one is larger than second one. Repeated untill entire 
     * arraylist sorted. 
     */
    public void sortingLithium()
    { //First Bubble sort
        int temp;
        if (highGrade.size()>1) // check if the number of orders is larger than 1
        {
            for (int x=0; x<highGrade.size(); x++) // bubble sort outer loop
            {
                for (int i=0; i < highGrade.size() - x - 1; i++){ //buuble sort inner loop
                    if (highGrade.get(i).compareTo(highGrade.get(i+1)) > 0)
                    {
                        temp = highGrade.get(i);
                        highGrade.set(i,highGrade.get(i+1) );
                        highGrade.set(i+1, temp);
                    }
                }
            }
        }
        
        //Second Bubble sort
        /**
         * Iterates through the lowGrade ArrayList, compares elements with one another
         * swaps if the first one is larger than second one. Repeated untill entire 
         * arraylist sorted into accending order. 
         */
        if (lowGrade.size()>1) // check if the number of orders is larger than 1
        {
            for (int x=0; x<lowGrade.size(); x++) // bubble sort outer loop
            {
                for (int i=0; i < lowGrade.size() - x - 1; i++){ //bubble sort inner loop
                    if (lowGrade.get(i).compareTo(lowGrade.get(i+1)) > 0)
                    {
                        temp = lowGrade.get(i);
                        lowGrade.set(i,lowGrade.get(i+1) );
                        lowGrade.set(i+1, temp);
                    }
                }
            }
        }
        
        System.out.println("High Grade");// print statment which displays the highest grades in accending order.
        for(Integer grades : highGrade) { //Iterates over the lowGrade ArrayList
            System.out.println(grades.intValue());//returns a primative int value.
        }

        System.out.println("Low Grade"); // print statment which displays the lowest grades in accending order.
        for(Integer grades : lowGrade) { //Iterates over the lowGrade ArrayList
            System.out.println(grades.intValue()); //returns a primative int value.
        }

    }
}