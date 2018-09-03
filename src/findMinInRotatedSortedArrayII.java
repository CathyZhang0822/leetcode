import java.util.Arrays;
//  这道题目在面试中不会让写完整的程序
//  只需要知道最坏情况下 [1,1,1....,1] 里有一个0
//  这种情况使得时间复杂度必须是 O(n)
//  因此写一个for循环就好了。
//  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
//  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
public class findMinInRotatedSortedArrayII {
    public static void main(String[] args){
        findMinInRotatedSortedArrayII obj = new findMinInRotatedSortedArrayII();
        int[] nums = {2,2,2,2,2,2,2,2,3,4,0,1,2,2};
        System.out.println(obj.findMin(nums));
    }
    private int findMin(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while(left+1 < right){
            mid = left + (right - left)/2;
            System.out.println(Arrays.toString(new int[]{left,mid,right}));
            //System.out.println(Arrays.toString(new int[]{nums[left],nums[mid],nums[right]}));
            if(nums[mid] > nums[right]){
                left = mid;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }else{
                // if mid equals to end, that means it's fine to remove end
                // the smallest element won't be removed
                right --;
            }
        }
        if(nums[left] < nums[right]){
            return nums[left];
        }else{
            return nums[right];
        }
    }
}
