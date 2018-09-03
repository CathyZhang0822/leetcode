public class searchInRotatedSortedArray {
    //Approach: 2 pass binary search
    /* first find the minimum num, where the rotate begins
       then I will find where will be the target. min's left or min's right.
       In the subarray, it will be an increasing array. So it's time to do regular binary search.
    * */
    public int search(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0, end = nums.length - 1;
        int mid;
        while(start + 1 < end){
            mid = start + (end - start)/2;
            if(nums[mid] < nums[end]){
                end = mid;
            }else{
                start = mid;
            }
        }
        int midpoint = (nums[start] < nums[end]) ? start : end;
        if(target > nums[nums.length - 1]){
            start = 0;
            end = -1 + midpoint == 0? 1 : midpoint;
        }else{
            start = midpoint;
            end = nums.length - 1;
        }
        while(start + 1 < end){
            mid = start + (end - start)/2;
            if(nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[start] == target){
            return start;
        }else if(nums[end] == target){
            return end;
        }else{
            return -1;
        }
    }
}
