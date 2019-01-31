import java.util.Arrays;

public class nextPermutation {
    public static void main(String[] args){
        int[] nums = new int[]{3,2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void nextPermutation(int[] nums){
        int k = nums.length-2;
        int sign = 0;
        for(; k >=0; k--){
            if(nums[k] < nums[k+1]){
                Arrays.sort(nums, k+1, nums.length);
                sign = 1;
                break;
            }
        }




        if(sign == 0){
            int i = 0, j = nums.length-1;
            while(i < j){
                swap(nums, i, j);
                i ++;
                j --;
            }
        }else{
            for(int i = k; i < nums.length; i++){
                if(nums[i] > nums[k]){
                    swap(nums,i,k);
                    return;
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
