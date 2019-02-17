import java.util.Arrays;
import java.util.PriorityQueue;

public class kBitFlip {
    public static void main(String[] args){
        int[] A = {1,1,0};
        System.out.println(minKBitFlips2(A, 6408));
    }

    public static int minKBitFlips2(int[] A, int K){
        int[] add = new int[A.length];
        int res = 0;
        int prev = -1;
        int i = 0;
        for(; i < A.length; i++){
            //System.out.println(Arrays.toString(add));
            if((A[i]+add[i]) % 2 == 0){
                res ++;
                int start = (i + K) > A.length ? (A.length - K) : i;
                if(start == prev) return -1;
                prev = start;
                for(int interval = 0; interval < K; interval++){
                    add[start+interval] ++;
                }
                i = start - 1;

            }
        }

        return res;
    }

}
