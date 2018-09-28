import java.util.*;
public class subArraySumk {
    public static void main(String[] args){
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
    // 这次是返回多少个
    public static int subarraySum(int[] nums, int k) {
        int presum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // don't forget to put initial zero into map
        map.put(0,1);
        for(int i = 0; i < nums.length; i ++){
            presum += nums[i];
            if(map.containsKey(presum-k)){
                res += map.get(presum-k);
            }
            map.putIfAbsent(presum, 0);
            map.put(presum, map.get(presum)+1);
        }
        return res;
    }
}
