import java.util.Arrays;

public class longestPalindromicSubstring {
    public static void main(String[] args){
        String s = "cbbdbb";
        System.out.println(lPS(s));
        System.out.println(lPSExpand(s));
    }
/* Approach 1: DP
   define DP[i][j] = true if s.substring(i,j) is palindrom
   else:             false
   So DP[i][j] = (DP[i+1][j-1] && s[i] == s[j]) 从公式可以看出这个二维网格是从对角线沿斜上方走的
   else: false
* */
    public static String lPS(String s){
        String res = "";
        boolean DP[][] = new boolean[s.length()][s.length()];
        // default is false
        //System.out.println(Arrays.deepToString(DP));
        for(int i = 0; i < s.length(); i++){
            // i代表行坐标和列坐标之间的间隔，I = 0时代表对角线
            for(int row = 0; row + i < s.length(); row ++){
                if(i == 0){
                    DP[row][row+i] = true;
                }else if(i==1){
                    DP[row][row+i] = (s.charAt(row) == s.charAt(row+i));
                }else{
                    DP[row][row+i] = (s.charAt(row) == s.charAt(row+i)) && DP[row+1][row+i-1];
                }
                if(DP[row][row+i]){
                    res = s.substring(row,row+i+1);
                }
            }
        }
        return res;
    }

    public static String lPSExpand(String s){
        int[] res = new int[2];
        for(int i=0; i < s.length(); i++){
            expand(s, i, i, res);
            expand(s, i, i+1, res);
        }
        return s.substring(res[0], res[0]+res[1]);
    }

    private static void expand(String s, int i, int j, int[] res){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i --;
            j ++;
        }
        // int[0]: starting index  int[1]: length of substring
        if(j - i - 1 > res[1]){
            res[0] = i+1;
            res[1] = j-i-1;
        }
    }
}
