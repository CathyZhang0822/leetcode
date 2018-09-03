public class searchInsertPosition {
    public static void main(String[] args){
        searchInsertPosition obj = new searchInsertPosition();
        int[] nums = new int[] {1,3,5,6};
        System.out.println(obj.searchInsert(nums,5));
        System.out.println(obj.searchInsert(nums,2));
        System.out.println(obj.searchInsert(nums,7));
        System.out.println(obj.searchInsert(nums,0));
    }
    public int searchInsert(int[] nums, int target){
        int left = 0, right = nums.length-1;
        int mid;
        while(left + 1 < right){
            mid = left + (right-left)/2;
            if(nums[mid]>target){
                right = mid;
            }else{
                left = mid;
            }
        }
        if(target > nums[right]){
            return right+1;
        }else if(target <= nums[left]){
            return left;
        }else{
            return left+1;
        }
    }
}
