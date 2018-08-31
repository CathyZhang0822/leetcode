import java.util.Arrays;

public class twoSumSorted {
    public static void main(String[] args){
        twoSumSorted obj = new twoSumSorted();
        System.out.println(Arrays.toString(obj.twoSum(new int[]{1,2,7,9},9)));
        System.out.println(Arrays.toString(obj.twoSumv2(new int[]{1,2,7,9},9)));

    }

    // Approach 1: two pointers
    /* use two pointers.
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
    /* Fix the first element nums[i] and do binary search on the remaining elements.
       Time complexity:  lg(n-1) + lg(n-2) + ... + lg(1) ~ O(lg(n!)) ~ O(nlgn)
       Space complexity: O(1)ir
    * */
    private int[] twoSumv2(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            int j = bs(nums, i + 1, nums.length-1, target - nums[i]);
            if(j != -1){
                return new int[] {i+1,j+1};
            }
        }
        throw new IllegalArgumentException("No valid solutions");
    }

    private int bs(int[] nums, int lo, int hi, int target){
        int mid;
        while(lo + 1 < hi){
            mid = lo + (hi - lo)/2;
            if(nums[mid] < target){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        if(nums[lo] == target){
            return lo;
        }else if(nums[hi] == target){
            return hi;
        }else{
            return -1;
        }
    }

}
