import java.util.Arrays;

public class maxTurbulenceSize {
    public static void main(String[] args){
        int[] A = new int[]{37,199,60,296,257,248,115,31,273,176};
        System.out.println(maxSize(A));
    }

    public static int maxSize(int[] A){
        if(A.length < 2){
            return A.length;
        }
        int max = 1;
        int[] dp = new int[A.length];
        dp[0] = 1;
        for(int i = 0; i < A.length-1; i++){
            if(A[i] == A[i+1]){
                dp[i+1] = 1;
            }
            else if(i==0 || (A[i] > A[i-1] && A[i] > A[i+1]) ||(A[i] < A[i-1] && A[i] < A[i+1])){
                dp[i+1] = dp[i] + 1;
                max = Math.max(max, dp[i+1]);
            }else{
                dp[i+1] = 2;
            }
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
}
