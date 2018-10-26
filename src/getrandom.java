import java.util.*;
public class getrandom {
    /*
    不能只用一个hashset的原因：getrandom是获得一个random的index. hashset不能用index
    Use an arraylist to store numbers, when it comes to getRandom(), it creats
    a random index of the arraylist.
    When it comes to remove(), then we remove the value without messing up the
    other numbers' indexes. For this method, I use a hashmap to store the
    number's value and its position int the arraylist.

    */

    List<Integer> nums;
    Map<Integer, Integer> locs;
    Random rand;

    public getrandom(){
        nums = new ArrayList<>();
        locs = new HashMap<>();
        rand = new Random();
    }
    /** Inserts a value to the set.
     *  Returns true if the set did not already contain the specified element. */

    public boolean insert(int val) {
        if(!locs.containsKey(val)) return false;
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set.
     *  Returns true if the set contained the specified element. */
    public boolean remove(int val){
        if(!locs.containsKey(val)) return false;
        int loc = locs.get(val);
        if(loc < nums.size()-1){
            int lastNum = nums.get(nums.size()-1);
            nums.set(loc,lastNum);
            // don't forget to update the map
            locs.put(lastNum, loc);
        }
        locs.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
