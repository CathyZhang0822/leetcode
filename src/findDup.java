import java.util.*;
public class findDup {
    /*
    虽然这道题有这么多要求：
    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.
    * */
    public static void main(String[] args){
        int[] nums = new int[] {1,1,1,2,4};
        findDuplicate(nums);
    }
    public static int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int i = 0;
        while(i < nums.length){
            if(nums[i] == i+1){
                i ++;
            }
            else if (nums[i] == nums[nums[i]-1]){
                i ++;
            }
            else{
                swap(nums, nums[i]-1, i);
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - 1];
    }
    public static void swap(int[] nums, int p, int q){
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
    /* Approach 2:
       This solution is based on binary search.

    At first the search space is numbers between 1 to n.
    Each time I select a number mid (which is the one in the middle) and count all the numbers equal to or less than mid.
    Then if the count is more than mid, the search space will be [1 mid] otherwise [mid+1 n].
    I do this until search space is only one number.
    Let's say n=10 and I select mid=5.
    Then I count all the numbers in the array which are less than equal mid.
    If the there are more than 5 numbers that are less than 5,
    then by Pigeonhole Principle one of them has occurred more than once.
    So I shrink the search space from [1 10] to [1 5].
    Otherwise the duplicate number is in the second half so for the next step the search space would be [6 10].
    * */
    public static int findDuplicate2(int[] nums) {
        // low = 1, high = n
        int low = 1, high = nums.length - 1;
        int mid;
        int count = 0;
        while(low < high){
            mid = low + (high - low)/2;
            count = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid){
                    count ++;
                }
            }
            if(count > mid){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
