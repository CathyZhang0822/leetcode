public class longestCommonSubstring {
    public static void main(String[] args){
        String s = "abcf";
        String t = "qbc";
        System.out.println(LCSuff(s,t));
    }
/*A simple solution is to one by one consider all substrings of first string
  and for every substring check if it is a substring in second string.
  Keep track of the maximum length substring.
  There will be O(m^2) substrings and we can find whether a string is subsring on another string in O(n) time.
  So overall time complexity of this method would be O(n * m2)

  Dynamic Programming can be used to find the longest common substring in O(m*n) time.
  find the longest common suffix for all pairs of prefixes of the strings. The longest common suffix is
  if(s[i] == s[j]): DP[i][j] = DP[i-1][j-1] + 1
  if(s[i] == s[j]): DP[i][j] = 0
  DP[i][j] means longest substring ends at s[i]&t[j]
  (对于二维网格，是一行一行走下来的，先走一行再走下一行)
* */
    public static String LCSuff(String s, String t){
        String res = "";
        int[][] DP =new int [s.length()+1][t.length()+1];

        for(int i=1; i<s.length()+1; i++){
            for(int j=1; j<t.length()+1; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    DP[i][j] = DP[i-1][j-1] + 1;
                    res = t.substring(j-DP[i][j],j);
                }else{
                    DP[i][j] = 0;
                }
            }
        }
        return res;
    }
}
