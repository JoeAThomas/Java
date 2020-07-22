import java.util.*; // imports all the java util packages. 

/**
 * Makes use of HashMaps (key andvalues) to set the pricing of the lithium
 * as this class is reponsable for ebsuring that each litium sample is given
 * a price. 
 * Makes use of three methods two of which assign the grades to the lithium 
 * other which prints the list of sorted grades and lithium
 * and the third returning the HashMap which allows for the HashMap to be 
 * called in other classes of the project.
 *
 * @Joe Thomas
 * @18/10/2019
 */
public class LithiumPricing
{
    /**
     * creates a hashmap which has the key set to a Integer for keys
     * and a Double for Values.
     */
    HashMap<Integer, Double> pricing = new HashMap<Integer, Double>();

    int[][] tray;

    /**
     * Constructor for object of the class LithiumGrading.
     * creating a method which calls the getTray which is returned in GenerateLithium.
     * calls the GenerateLithium class, creates new version and saves it in 
     * generatelithium which then allows us to access its methods.
     */
    public LithiumPricing(GenerateLithium generatelithium)
    {
        tray = generatelithium.getTray();
    }

    /**
     * setPrice assigns a Double to the Integer. 
     * utalises two for loops (inner and outer) allows method to gain int 
     * from the previously created Array tray. 
     * Makes a check on the gotten tray number, then compares it 
     * to a Double. If the statment is true then assignt elements to HashMap.
     * Does this untill all elements are assignted a value. Duplicates 
     * keys aren't supported in a HashMap so they aren't added to HashMap.
     */
    public void setPrice()
    { 
        for (int i = 0; i < 5; i++) //outer loop
        {
            for (int j = 0; j < 3; j++) //inner loop
            {
                if(tray[i][j] <= 9)//statment
                {
                    pricing.put(tray[i][j], 300.00);//action if statment = true
                }
                else if(tray[i][j] >= 10 && tray[i][j] <= 19){
                    pricing.put(tray[i][j], 600.00);
                }
                else if(tray[i][j] >= 20 && tray[i][j]<= 29){
                    pricing.put(tray[i][j], 900.00);
                }
                else if (tray[i][j] >= 30){
                    pricing.put(tray[i][j], 1250.00);
                }
            }   
        }  
    }

    /**
     * @return HashMap 
     * Allows HashMap to be accessed in BuyLithium class.
     * HashMap is called "pricing".
     */
    public HashMap<Integer, Double> getPrice()
    {
        return pricing;   
    }

    /**
     * returns the set of keys from the HashMap.
     * overall prints the Hashmap.
     */
    public void printPrice()
    {
        Set set = pricing.entrySet();//Set, unordered collection of elements (the HashMap)
        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();//allows us to work with the map
            System.out.print(mentry.getKey() + " ");//returns the key from HashMap.
            System.out.println(mentry.getValue());//returns the value from HashMap.
        }
    }

}

