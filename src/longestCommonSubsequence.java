import java.util.Arrays;

public class longestCommonSubsequence {
    public static void main(String[] args){
        String s = "adqecf";
        String t = "qbef";
        System.out.println(LCS(s,t));
    }
    /*
    Time complexity of the above naive recursive approach is O(2^n)
    If we draw the complete recursion tree, then we can see that there are many subproblems which are solved again and again.
    So this problem has Overlapping Substructure property.
    Recomputation of same subproblems can be avoided by either using Memoization or Tabulation.
    Let dp[i+1][j+1] be the length of the longest common subsequence of substring a(0,i) & b(0,j)
    if(s[i] == t[j]): DP[i][j] = DP[i-1][j-1] + 1;
    else: DP[i][j] = max(DP[i-1][j],DP[i][j-1])
    (对于二维网格，也是一行一行走下来的)
    * */
    public static int LCS(String s, String t){
        int res = 0;
        int[][] DP = new int[s.length()+1][t.length()+1];
        for(int i=1; i <= s.length(); i++){
            for(int j=1; j <= t.length(); j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    DP[i][j] = DP[i-1][j-1] + 1;
                    res = Math.max(res, DP[i][j]);
                }else{
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(DP));
        return res;
    }
}
