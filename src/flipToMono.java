import java.util.Arrays;

public class flipToMono {
    public static void main(String[] args){
        String s = "0";
        int res = minFlip(s);
        System.out.println(res);
    }
    public static int minFlip(String S){
        int res = S.length();
        // how many 1s in the first part
        int[] dp1 = new int[S.length() + 1];
        // how many 0s in the second part
        int[] dp0 = new int[S.length() + 1];
        int sum1 = 0;
        int sum0 = 0;
        for(int i = 0; i < S.length(); i ++){
            if(S.charAt(i) == '1') sum1 ++;
            dp1[i+1] = sum1;
        }
        for(int j = S.length()-1; j >= 0; j --){
            if(S.charAt(j) == '0') sum0 ++;
            dp0[j] = sum0;
        }
        for(int k = 0; k < dp1.length; k ++){
            if(dp1[k] + dp0[k] < res){
                res = dp1[k] + dp0[k];
            }
        }
        System.out.println(Arrays.toString(dp1));
        System.out.println(Arrays.toString(dp0));
        return res;
    }
}
