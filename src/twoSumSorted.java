import java.util.Arrays;

public class twoSumSorted {
    public static void main(String[] args){
        twoSumSorted obj = new twoSumSorted();
        System.out.println(Arrays.toString(obj.twoSum(new int[]{1,2,7,9},9)));

    }

    // Approach 1: two pointers
    /* Sort array first. Then use two pointers.
       Time complexity: O(n)
       Space complexity: O(1)
    * */
    private int[] twoSum(int[] nums, int target){
        int lo = 0, hi = nums.length-1;
        while(lo < hi){
            if(nums[lo] + nums[hi] == target){
                return new int[] {lo+1, hi+1};
            }
            if(nums[lo] + nums[hi] < target){
                lo ++;
            }else{
                hi --;
            }
        }
        throw new IllegalArgumentException("No valid solutions");
    }

    // Approach 2: binary search

}
