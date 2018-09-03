/* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
   (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
   Find the minimum element.
   Example:
   Input: [3,4,5,1,2]
   Output: 1
*/
public class findMinInRotatedSortedArray {
    public static void main(String[] args){
        findMinInRotatedSortedArray obj = new findMinInRotatedSortedArray();
        int[] nums = {2,3,4,5,0,1};
        System.out.println(obj.findMin(nums));
    }
    private int findMin(int[] nums){
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left+1 < right){
            mid = left + (right - left)/2;
            if(nums[mid] > nums[right]){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(nums[left] < nums[right]){
            return nums[left];
        }else{
            return nums[right];
        }
    }
}
