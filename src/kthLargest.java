import java.util.Arrays;

public class kthLargest {
    public static void main(String[] args){
        int[] nums = new int[] {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums,4));

    }
    public static int findKthLargest(int[] nums, int k) {

        int low = 0, high = nums.length-1;
        int position = partition(nums, low, high);
        while(position != k-1){
            // partition
            if(position < k -1){
                low = position+1;
                position = partition(nums, low, high);
            }else{
                high = position-1;
                position = partition(nums, low, high);
            }
        }
        return nums[k-1];
    }
    private static int partition(int[] nums, int low, int high){
        int pivot = nums[high];
        // use two pointer to re-arrange the array.
        // all larger numbers locate at it's left. all (smaller or equal) numbers locate at it's right
        int i = low-1;
        for(int j = low; j <= high; j ++){
            // 注意这个判断语句 > or >=
            if(nums[j] > pivot){
                i ++;
                // swap
                swap(nums, i,j);

            }
        }
        // 画本子画出来的，注意这里
        // don't forget to put pivot to the right location!
        i ++;
        // swap
        swap(nums, i, high);
        // return the position of pivot
        return i;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
