public class longestPalindromSubsequence {
    public static void main(String[] args){
        String s = "cddad";
        System.out.println(longest(s));
    }
    /* Given a string s, find the longest palindromic subsequence's length in s.
    Example:
    Input: "bbbab"
    Output: 4
    * */
    /*
    dp[i][j]: the longest palindromic subsequence's length of substring(i, j), here i, j represent left, right indexes in the string
    State transition:
    dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
    otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
    Initialization: dp[i][i] = 1
    * */
    public static int longest(String s){
        int [][] DP = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            //注意ROW + I < S.LENGTH()!!!
            for(int row = 0; row+i < s.length(); row ++){
                if(i == 0){
                    DP[row][row+i] = 1;
                }else{
                    if(s.charAt(row) == s.charAt(row+i)){
                        DP[row][row+i] = DP[row+1][row+i-1]+2;
                    }else{
                        DP[row][row+i] = Math.max(DP[row+1][row+i], DP[row][row+i-1]);
                    }
                }
            }
        }
        return DP[0][s.length()-1];
    }
}
