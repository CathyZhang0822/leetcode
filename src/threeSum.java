import java.util.*;
public class threeSum {
    public static void main(String[] args){
        int[] nums = new int[] {-2,0,1,1,2};
        threeSum obj = new threeSum();
        System.out.println(obj.threeSum(nums));
    }
    /* Approach: for loop + two sum
       Time: O(n^2)
       Space: O(1)
    * */
    private List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList();
        if(nums == null || nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            // 关键要想清楚，2SUM面对duplicate怎么办，3SUM面对duplicate怎么办
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            // two sum
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi){
                //consider duplicates
                //2 sum应对duplica
                if(nums[lo] + nums[hi] == 0 - nums[i]){
                    result.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                    while(lo < hi && nums[lo] == nums[lo+1]){
                        lo ++;
                    }
                    while(lo < hi && nums[hi] == nums[hi-1]){
                        hi --;
                    }
                    lo ++;
                    hi --;
                }else if(nums[lo] + nums[hi] < 0 - nums[i]){
                    lo ++;
                }else{
                    hi --;
                }
            }
        }
        return result;
    }
}
