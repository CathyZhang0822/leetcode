import java.util.*;

// Time complexity: O(1) for add, O(n) for find. Space complesity: O(2n)
// It turns out iterating a list is much faster than iterating a count map
// F**k I got TLE, why?

class TwoSum{
    Map<Integer, Integer> map;
    List<Integer> list;

    /** Initialize */
    public TwoSum(){
        map = new HashMap<>();
        list = new LinkedList<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number){
        if(map.containsKey(number)){
            map.put(number, map.get(number)+1);
        }else{
            map.put(number,1);
            list.add(number);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int target){
        for (int i=0; i<list.size(); i++){
            int num1 = list.get(i);
            int num2 = target-num1;
            if((num1 == num2 && map.get(num1)>1) || (num1 != num2 && map.containsKey(num2))){
                return true;
            }
        }
        return false;
    }
}
public class twoSumDataStructure {
    public static void main(String[] args){
        TwoSum obj = new TwoSum();
        obj.add(1);
        obj.add(7);
        obj.add(5);
        obj.add(1);
        System.out.println(obj.map);
        System.out.println(obj.find(2));
        System.out.println(obj.find(8));
        System.out.println(obj.find(9));
    }

}
