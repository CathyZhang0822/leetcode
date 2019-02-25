import java.util.HashMap;
import java.util.Map;

public class subarrayDivByK {
    public static void main(String[] args){
        int[] A = {4,5,0,-2,-3,1};
        int K = 5;
        System.out.println(divByK(A, K));
    }

    public static int divByK(int[] A, int K){
        int[] subSum = new int[A.length];
        int[] subRemainder = new int[A.length];
        subSum[0] = A[0];
        Map<Integer, Integer> map = new HashMap<>();
        subRemainder[0] = (subSum[0] % K) >= 0 ? (subSum[0] % K) : K+(subSum[0] % K);
        int res = 0;
        for(int i = 0; i < A.length; i++){
            if(i > 0){
                subSum[i] = subSum[i-1] + A[i];
                subRemainder[i] = (subSum[i] % K) >= 0 ? (subSum[i] % K) : K+(subSum[i] % K);
            }
            map.putIfAbsent(subRemainder[i], 0);
            res += map.get(subRemainder[i]);
            if(subRemainder[i] == 0) res ++;
            map.put(subRemainder[i],map.get(subRemainder[i])+1);
        }
        return res;
    }
}
