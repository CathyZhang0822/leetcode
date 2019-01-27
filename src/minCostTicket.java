import java.util.*;
public class minCostTicket {
    public static void main(String[] args){
        int[] days = new int[]{1,2,3,4,6,8,9,10,13,14,16,17,19,21,24,26,27,28,29};
        int[] cost = new int[]{3,14,50};
        System.out.println(minCost(days, cost));
    }
    public static int minCost(int[] days, int[] cost){
        Set<Integer> set = new HashSet<>();
        for(int day:days){
            set.add(day);
        }
        System.out.println("days" + set);
        int res = 0;
        int dp[] = new int[days[days.length-1]+1];
        for(int i = 1; i < dp.length; i ++){
            if(!set.contains(i)){
                System.out.println("i: " + i);
                int prev = dp[i-1];
                System.out.println("prev: "+ prev);
                dp[i] = prev;
                continue;
            }
            int way1 = dp[i-1] + cost[0];
            int way2 = i >= 7 ? (dp[i-7] + cost[1]) : (dp[0] + cost[1]);
            int way3 = i >= 30 ? (dp[i-30] + cost[2]) : (dp[0] + cost[2]);
            dp[i] = Math.min(way1, Math.min(way2, way3));
        }
        System.out.println(Arrays.toString(dp));
        return dp[days[days.length-1]];
    }
}
