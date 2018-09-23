import java.util.*;
public class friendsOfAppropriateAge {
    public static void main(String[] args){
        int[] ages = {200, 107};
        System.out.println(numFQ(ages));
        System.out.println();
    }
    public static int numFQ(int[] ages){
        int sum = 0;
        int prev = 0;
        Integer[] nums = new Integer[ages.length];
        for(int i = 0; i < nums.length; i ++){
            nums[i] = ages[i];
        }
        Arrays.sort(nums, Collections.reverseOrder());
        System.out.println(Arrays.deepToString(nums));
        for(int i = 0; i < nums.length; i ++){
            if(i > 0 && nums[i] == nums[i-1]){
                sum += prev;
                continue;
            }
            int index = find(nums, 0.5*nums[i]+7, i, nums.length-1);
            System.out.println("index: " + index);
            sum += index-i;
            prev = index - i;
        }
        return sum;
    }

    public static int find(Integer[] ages, double target, int start, int end){
        int left = start;
        int right = end;
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(ages[mid] > target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(ages[right] <= target){
            return left;
        }else{
            return right;
        }
    }
}
