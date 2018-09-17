import java.util.*;
public class coinChange {
    public static void main(String[] args){
        int[] coins = new int[] {1,2,5};
        int amount = 5;
        System.out.println(coinChangeFewest(coins, amount));
        System.out.println(coinChangeAll(coins, amount));
    }
    /* 1st Problem: return fewest number of coins(DP)
       You are given coins of different denominations and a total amount of money amount.
       Write a function to compute the fewest number of coins that you need to make up that amount.
       If that amount of money cannot be made up by any combination of the coins, return -1
       Example:
       Input: coins = [1, 2, 5], amount = 11
       Output: 3
       Explanation: 11 = 5 + 5 + 1
    * */
    public static int coinChangeFewest(int[] coins, int amount){
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int curAmt = 1; curAmt < dp.length; curAmt++){
            int res = -1;
            for(int coin : coins){
                if(curAmt - coin < 0 || dp[curAmt - coin] == -1){
                    continue;
                }
                res = res == -1 ? dp[curAmt - coin] : Math.min(res,dp[curAmt - coin]);
            }
            dp[curAmt] = res == -1 ? -1 : res + 1;
        }
        return dp[amount];
    }
    /* 2nd Problem: return all possible ways
       DFS
       回想视频课上老师讲的两种不同recursion tree: n^k vs k^n
       好吧这道题用DFS写竟然超时了
       专门开了一个新的写一下DP解法
    * */
    static int ways;
    public static int coinChangeAll(int[] coins, int amount){
        ways = 0;
        String path = "";
        List<String> res = new ArrayList<>();
        dfs(0, coins, amount, path, res);
        System.out.println(res);
        return ways;
    }
    private static void dfs(int level, int[] coins, int amount, String path, List<String> res){
        // base case 1: 超过amount了，不用往下走了
        if(amount <= 0){
            if(amount == 0){
                res.add(path);
                ways ++;
            }
            return;
        }
        // base case 2: 超过level
        if(level >= coins.length){
            return;
        }
        int cur = coins[level];
        // use this coin as many as possible before go to next coin
        for(int i = 0; i <= amount/cur; i++){
            dfs(level+1, coins, amount - cur*i, path + i + cur, res);
        }
        // base case 3, 于这道题而言（void），可有可无。返回一个值时，需要注意
        return;
    }
}
