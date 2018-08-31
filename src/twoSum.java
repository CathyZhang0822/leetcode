import java.util.*;
public class twoSum {
    public static void main(String[] args){
        twoSum test = new twoSum();
        System.out.println(Arrays.toString(test.twoSum(new int[]{1,2,7,9},9)));
        System.out.println(Arrays.toString(test.twoSumv2(new int[]{1,2,7,9},9)));
    }
    // Approach 1: one-pass HashMap
    /* While we iterate elements in the array, we look back whether current element's complement exists.
       Use a hashmap to help.
       Time complexity: O(n)
       Space complexity: O(n)
    * */
    private int[] twoSum(int[] nums, int target){
        Map <Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[] {map.get(target - nums[i]), i};
            }else{
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("No valid solutions");
    }
    // Approach 2: two pointers
    /* Sort array first. Then use two pointers.
       Time complexity: O(nlogn)
       Space complesity: O(1)
    * */
    private int[] twoSumv2(int[] nums, int target){
        Arrays.sort(nums);
        int lo = 0, hi = nums.length-1;
        while(lo < hi){
            if(nums[lo] + nums[hi] == target){
                return new int[] {lo, hi};
            }
            if(nums[lo] + nums[hi] < target){
                lo ++;
            }else{
                hi --;
            }
        }
        throw new IllegalArgumentException("No valid solutions");
    }

}

