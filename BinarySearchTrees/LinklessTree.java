import java.util.*;
/**
 * Trees without explicit links.
 * Notice that various fields/methods have the protected modifier
 * when normally they would/should be private.
 * The reason is that this supports whitebox testing.
 *
 * @author Joe Thomas
 * @version 1
 */
//note the constraint on A is a slight generalisation of A extends Comparable<A>
//and is generally recommended when one wants a comparison operation
//it basically allows that the comparison op is implemented at a supertype
//of A, instead of A itself;
//for the assessment itself it makes no discernable difference
public class LinklessTree<A extends Comparable<? super A>>
{
    //sizes of subtrees at that node index
    protected int[] sizes;
    protected Object[] elems;
    protected Object[] newElems;

    //for annoying technical reason this has to be an array of objects

    /**
     * Constructor for objects of class LinklessTree
     */
    private static final int STARTSIZE=15;

    LinklessTree<A> root;
    public LinklessTree()
    {
        int node = 0;
        assert STARTSIZE>0;
        elems = freshElemArray(STARTSIZE);
        sizes = new int[STARTSIZE];
        sizes[0]=0; 

    }
    //size of whole tree is the size of the subtree rooted at 0
    public int size() {
        return getSize(0);
    }

    public A getValue(int index) {
        return (A)elems[index];
    }

    //auxiliary methods to index the arrays out of bounds too
    //they may help to reduce case distinctions
    protected A getKey(int subtree) {
        if (subtree>=elems.length) return null; // out of bounds
        return getValue(subtree);
    }

    protected int getSize(int subtree) {
        if (subtree>=elems.length) return 0; // out of bounds
        return sizes[subtree];
    }

    //encapsulates the cast on the allocation
    protected Object[] freshElemArray(int capacity) {
        return new Object[capacity];
    }

    //remainder needs to be modified

    //find index position of val in tree, if there, or where it goes, if not there
    //
    public int findIndex(A val){
        int node = 0;

        while(node<elems.length){
            if(elems[node] == null){
                return node; 
            }

            if ((val.compareTo((A)elems[node])) == 0 ) {
                return node;

            } else if((val.compareTo((A)elems[node])) < 0 ){ //if value entered less than the root.
                node = 2 * node + 1; //then move to the left of the tree. 

            } else { 
                node = 2 * node + 2;} //else go to the right. 

        }
        return node;
    }

    //is value in tree
    public boolean contains(A val) {
        boolean inArray = false;

        for(int j = 0; j < elems.length; j++){//loops through elems
            if(elems[j] == val){//if elems equal to var (entered number)
                j = j + (elems.length)+1; 
                inArray = true; // if in elems return true
            }

            else{
                inArray = false; //if not in elems return false 
            }
        }
        return inArray;
    }

    //grow the space in which we can palce the tree, so that at least one insertion will succeed

    //array into tempary array
    //balence tree, have mid point make the root.
    //void (A[]a, int offset())
    protected void grow(){
        // Create an array newElems[] of same size as elems[] 
        Object newElems[] = new Object[elems.length*2]; 
        int newSizes[] = new int[sizes.length*2];

        // Copy elements of elems[] to newElems[] 
        for (int i=0; i<elems.length; i++) {
            newElems[i] = elems[i]; 
            newSizes[i] = sizes[i];
        }

        Object elems[] = new Object[newElems.length]; 
        int sizes[] = new int[newSizes.length];
        // Copy elements of sizes[] to newSizes[] 
        for (int i=0; i<elems.length; i++) {
            elems[i] = newElems[i];
            sizes[i] = newSizes[i];
        }

    }
    //fetch the i-th element, in comparsion order
    public A get(int i){  
        ArrayList<A> newElems = new ArrayList<>();

        // Create an Integer ArrayList.
        // Loop over our array and add each element separately.
        for (int j = 0; j < elems.length;){
            if (getValue(j)!= null && !newElems.contains(getValue(j))){
                newElems.add(getValue(j));
            }
            j =  2 * j + 1;
        }

        // Create an Integer ArrayList.
        // Loop over our array and add each element separately.
        for (int f = 0; f < elems.length;){
            if (getValue(f)!= null && !newElems.contains(getValue(f))){
                newElems.add(getValue(f));
            }
            f =  2 * f + 2;
        }
        Collections.sort(newElems);

        return (A)newElems.get(i); 
    }

    //add x to tree, return true if tree was modified
    //we do not allow multiple copies of the equal objects in tree
    //equality is decided by using compareTo
    public boolean insert(A x){ 
        boolean added = false;

        if(contains(x) == false){
            int index = 0;
            while (index < elems.length && (!added)){
                if(elems[index]==null){
                    elems[index] = x;
                    added = true;

                    sizes[index]++;
                    int j = index;

                    //increases the sizes of the parent. 
                    while(j !=0){
                        j = (j - 1) / 2;
                        sizes [j]++;; 
                    }

                    return true;
                }
                else if((x.compareTo((A)elems[index])) < 0 ){ //treverses through the left side of tree
                    index = 2 * index + 1; 

                } else { 
                    index = 2 * index + 2; //treverses through the right side of tree

                }
            }

            if(index>elems.length){
                grow();// if not in elems, double elems and insert.
                insert(x);// insert into elems
                return true;
            }
        }
        return false;
    }
    //remove x from tree, return true if tree was modified
    public boolean delete(A x){ return false; }

    //not requested, but these might be useful auxiliary ops for delete
    private A deleteLargest(int subtree) { return null; }

    private A deleteSmallest(int subtree) { return null; }
}