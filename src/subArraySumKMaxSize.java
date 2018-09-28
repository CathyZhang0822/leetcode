import java.util.*;
public class subArraySumKMaxSize {
    public static void main(String[] args){

    }
    public static int maxSize(int[] nums, int k){
        int preSum = 0;
        int imax = 0;
        // preSum : index
        Map<Integer,Integer> map = new HashMap<>();
        // don't forget this one
        map.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            preSum += nums[i];
            if(map.containsKey(preSum-k)){
                imax = Math.max(imax, i-map.get(preSum-k));
            }
            map.putIfAbsent(preSum,i);
        }
        return imax;
    }
}
