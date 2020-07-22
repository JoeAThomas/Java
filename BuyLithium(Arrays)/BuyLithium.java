import java.util.*;
/**
 * This class conisists of 2 methods, the first one allows the user to enter
 * an integer in which will then print all of the avalible less than and equal
 * to the entered price.
 * The second allows the user to enter anther integer which will sort through
 * the keys saved in the HashMap to print the elements less and and equal to it.
 *
 * @Joe Thomas
 * @22/10/2019
 */
public class BuyLithium
{
    /**
     * Initialises HashMap.
     */
    HashMap<Integer, Double> pricing;

    /**
     * Constructor for objects of class BuyLithium, allows us to call methods
     * from LithiumPricing.
     * calls on the "getPrice()" method from LithiumPricing.
     */
    public BuyLithium(LithiumPricing lithiumpricing)
    {
        pricing = lithiumpricing.getPrice();
    }

    /**
     * Iterates through a for loop to gain values through the HashMap "pricing".
     * @param takes a parameter entered by the user.
     * Will print all of the values and keys lower than the int the
     * user enetered.
     */
    public void findBestPrice(int searchvalue)
    {
        int count = 0;//counts avaliable values. 
        for(Integer integer : pricing.keySet()) //interates over pricing
        {
            if(searchvalue >= pricing.get(integer))//searches the values from pricing
            {
                System.out.println(integer.toString() + "    " + pricing.get(integer).toString());
                count++; //when the proccess in complete it adds an int to the count.
            }
        }
        System.out.print("There are " + count + " choices available to you.");
    }

    /**
     *Iterates through a for loop to gain values through the HashMap "pricing".
     *@param takes a parameter entered by the user.
     *Will print all of the keys and values available.
     */
    public void  findHighQuality(int searchkey)
    {
        int count = 0;// tracks avaliable keys.
        for(Integer integer : pricing.keySet())//interates over pricing
        {
            if(searchkey >= integer)//searches the keys from pricing
            {
                System.out.println(integer.toString() + "  " + pricing.get(integer).toString());
                count++;//when the proccess in complete it adds an int to the count.
            }
        }
        System.out.print("There are " + count + " choices available to you.");
    }

}
