import java.lang.Math;
import java.io.File;
import java.io.IOException;
import java.util.*;
/**
 * Calcuates Memory Cache via LRU. 
 *
 * @author jt539
 * @version (10/04/2020)
 */
public class Programme
{
    // instance variables - replace the example below with your own
    private int blocks; //How many Blocks there are Variable.
    private int index; //Number of bits in index  Variable.
    private int offset; //Number of bits in offset  Variable.

    private final int w; //max number of bits on the string.
    private final int k; //number of lines in a block.
    private final int fileNumber;

    private final int tagLen; //Length of a tag. Final means that cant be cahnged.
    private final int retIndex; //length of the index and offset.

    private String indexValue;

    private int n;

    private int counter; //creates the counter variable used to hold the Tag index value. 

    ArrayList<Long> decimal = new ArrayList<>();// Creates arrayList to store decimal numbers.
    ArrayList<String> Binary = new ArrayList<>();// Creates arrayList to store decimal numbers.

    ArrayList<String> Tag = new ArrayList<>();// Creates arrayList to store decimal numbers. (Hash set)
    ArrayList<String> WLongBinary = new ArrayList<>();
    ArrayList<String> StoreIndex = new ArrayList<>();

    ArrayList<String> Block00 = new ArrayList<>();
    ArrayList<String> Block01 = new ArrayList<>();
    ArrayList<String> Block02 = new ArrayList<>();
    ArrayList<String> Block03 = new ArrayList<>();
    ArrayList<String> Block04 = new ArrayList<>();
    ArrayList<String> Block05 = new ArrayList<>();
    ArrayList<String> Block06 = new ArrayList<>();
    ArrayList<String> Block07 = new ArrayList<>();
    ArrayList<String> Block08 = new ArrayList<>();
    ArrayList<String> Block09 = new ArrayList<>();
    ArrayList<String> Block10 = new ArrayList<>();
    ArrayList<String> Block11 = new ArrayList<>();
    ArrayList<String> Block12 = new ArrayList<>();
    ArrayList<String> Block13 = new ArrayList<>();
    ArrayList<String> Block14 = new ArrayList<>();
    ArrayList<String> Block15 = new ArrayList<>();

    /**
     * Constructor for objects of class Programme
     * holds the values for the W, C, B and K
     */
    public Programme(int w1, int c, int b, int k1, int fileNumber1)// initialise instance variables
    {
        w = w1; // number of bits.
        c = c; // number of data bytes in the cache.
        b = b; // number of bytes in one cache block.
        k = k1; // number of lines in a block
        
        fileNumber = fileNumber1; // takes the question number as a parameter so dont need to keep going into code and changing the pathway. 

        blocks = c/b; // number of blocks
        index = (int) (Math.log(blocks) / Math.log(2));
        offset = (int) (Math.log(b / k) / Math.log(2)); 

        tagLen = w-index-offset; //length of a tag
        retIndex = index + offset; //length of the index and offset.

        counter = 0; //initialises counter value at 0.  
        overalCalc(); // calls every method when the parameters are entered. 
    }

    public void loadCacheFile() {
        try{
            File file = new File("C:/Users/User/Desktop/CacheQuestion/"+fileNumber +".txt");
            Scanner scan = new Scanner(file);// Scans each line of the file.
            while(scan.hasNextLine()){
                decimal.add(Long.parseLong(scan.nextLine())); // Adds scanned ints and adds to arrayList (decimal).
            }
            System.out.print(decimal + "\n");
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void binaryConversion(){
        for (int i=0; i<decimal.size(); i++) {
            Binary.add((Long.toBinaryString(decimal.get(i)))); //uses toBinaryString to convert the Long value to a binary string. 
        }
        System.out.println(Binary);
    }

    public void packBinary(){
        for (int i=0; i<Binary.size(); i++) { // loops throught the Binary arraylist.
            String S1 = Binary.get(i); 
            while(S1.length() < w){ // if the length is less than w then concat 0 to the start of it. 
                S1 = "0".concat(S1); 
            }      
            WLongBinary.add(S1); // adds this to a new arraylist called WLongBinary.
        }
        System.out.println(WLongBinary);
    }

    public void calculationTag(){
        String t;
        for (int i=0; i<WLongBinary.size(); i++) {
            t = WLongBinary.get(i).substring(0,tagLen); //taking index off end
            Tag.add(t);

            indexValue = WLongBinary.get(i).substring((w - retIndex), w - offset); //The index value
            StoreIndex.add(indexValue); //Just the index
        }
        System.out.println(Tag);
        System.out.println(StoreIndex);
    }

    public void calCachMemory(){ //if the index value is any of the cases then proceed and run the LRUCache methods which takes a given block as a parameter.
        for (int i=0; i<StoreIndex.size(); i++) { //then check the given tag value is in the block or not and produces a string consisting of Ms and Cs. 
            if(StoreIndex.get(i).equals("") || StoreIndex.get(i).equals("0") || StoreIndex.get(i).equals("00") || StoreIndex.get(i).equals("000") || StoreIndex.get(i).equals("0000") ){
                LRUCache(Block00); 
            }
            else if(StoreIndex.get(i).equals("1") || StoreIndex.get(i).equals("01") || StoreIndex.get(i).equals("001") || StoreIndex.get(i).equals("0001")){ //1
                LRUCache(Block01);
            }
            else if(StoreIndex.get(i).equals("10") || StoreIndex.get(i).equals("010") || StoreIndex.get(i).equals("0010")){ //2
                LRUCache(Block02);
            }
            else if(StoreIndex.get(i).equals("11") || StoreIndex.get(i).equals("011") || StoreIndex.get(i).equals("0011")){ //3
                LRUCache(Block03);
            }
            else if(StoreIndex.get(i).equals("100") || StoreIndex.get(i).equals("0100")){ //4
                LRUCache(Block04);
            }
            else if(StoreIndex.get(i).equals("101") || StoreIndex.get(i).equals("0101")){ //5
                LRUCache(Block05);
            }
            else if(StoreIndex.get(i).equals("110") || StoreIndex.get(i).equals("0110")){ //6
                LRUCache(Block06);
            }
            else if(StoreIndex.get(i).equals("111") || StoreIndex.get(i).equals("0111")){ //7
                LRUCache(Block07);
            }
            else if(StoreIndex.get(i).equals("1000")){ //8
                LRUCache(Block08);
            }
            else if(StoreIndex.get(i).equals("1001")){ //9
                LRUCache(Block09);
            }
            else if(StoreIndex.get(i).equals("1010")){ //10
                LRUCache(Block10);
            }
            else if(StoreIndex.get(i).equals("1011")){ //11
                LRUCache(Block11);
            }
            else if(StoreIndex.get(i).equals("1100")){ //12
                LRUCache(Block12);
            }
            else if(StoreIndex.get(i).equals("1101")){ //13
                LRUCache(Block13);
            }
            else if(StoreIndex.get(i).equals("1110")){ //14
                LRUCache(Block14);
            }
            else if(StoreIndex.get(i).equals("1111")){ //15
                LRUCache(Block15);
            }
        }
    }

    public void LRUCache(ArrayList<String> Block){
        if(!(Block.contains(Tag.get(counter))) && Block.size() < k){ //Not in the block.
            Block.add(Tag.get(counter));
            System.out.print("M"); //prints an M as isn't in the block.
        }else if(!(Block.contains(Tag.get(counter))) && Block.size() == k){ //Not in the block and block is full.
            Block.remove(0);
            Block.add(Tag.get(counter));
            System.out.print("M"); //prints M is it's not in the block and block is full. 
        } else if((Block.contains(Tag.get(counter))) && Block.size() < k){ //Block isn't full but has the same value.
            int numin = Block.indexOf(Tag.get(counter)); //IndexOf() returns the index value of element entered. 
            Block.remove(numin);
            Block.add(Tag.get(counter));
            System.out.print("C"); //prints C if its in block and block isnt full 
        } else if((Block.contains(Tag.get(counter))) && Block.size() == k){ //Block is full and has same value.
            int numin = Block.indexOf(Tag.get(counter));
            Block.remove(numin);
            Block.add(Tag.get(counter));
            System.out.print("C"); //prints C if its in block and block is full 
        }
        counter++; // everytime iterates through loop adds a int in order to keep track of the index value inside the Tag arrayList. 
    }

    public void overalCalc(){
        loadCacheFile();
        binaryConversion();
        packBinary();
        calculationTag();
        calCachMemory();
    }
}
