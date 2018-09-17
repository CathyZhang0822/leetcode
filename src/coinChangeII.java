import java.util.*;
public class coinChangeII {

    public static void main(String[] args){
        int[] coins = new int[] {1,2,5};
        int amount = 11;
        map = new HashMap<>();
        map.put(Arrays.asList(1,3), 0);
        List<Integer> key = Arrays.asList(1,3);
        System.out.println(map.containsKey(key));
        System.out.println(dfs(coins, 0, amount));
    }
    /* DP solution:
       Think about this question from very easy sub-problem: if we only use coin 1, how can we build that
       then we add coin 2.. coin 5..
       int[] coins = [1,2,5]
    * */
    public static int coinChange(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    /* 折腾半天终于写出了memorized DFS solution
    * */
    // List<index, amount>; Integer: count
    // 用来做memorized dfs的map
    // 注意要用list！不要用int[]！！！
    static Map<List<Integer>, Integer> map;
    public static int dfs(int[] coins, int index, int amount){
        // map里面有可以直接返回
        List<Integer> key = Arrays.asList(index, amount);
        if(map.containsKey(key)){
            System.out.println(key);
            return map.get(key);
        }
        // base case
        if (amount <= 0) {
            if(amount == 0){
                return 1;
            }
            return 0;
        }
        int cnt = 0;
        for(int i = index; i < coins.length; i++){
            // 终于理解了 应该memorize 什么了
            // 观察每次调用dfs的时候，是index和amount两个参数在变化（int[] coins一直不变）。
            // 当index和amount与之前的相同时，说明曾经出现过，我们做了相同的work
            // 理解：重复解决子问题：用index之后的coins，去满足这个amount
            cnt += dfs(coins, i, amount-coins[i]);
        }
        map.put(key, cnt);
        return cnt;
    }
}
