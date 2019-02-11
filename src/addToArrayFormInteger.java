import java.util.*;

public class addToArrayFormInteger {
    public static void main(String[] args){
        int[] A = new int[] {9,9,9,9,9};
        int K = 1;
        System.out.println(addToArrayForm(A, K));
    }

    public static List<Integer> addToArrayForm(int[] A, int K){
        int count = 0;
        int i = A.length-1;
        String kStr = String.valueOf(K);

        List<Integer> res = new ArrayList<>();
        int j = kStr.length()-1;
        while(count > 0 || i >= 0 || j >= 0){
            int cur = count + (i >= 0 ? A[i] : 0) + (j >= 0 ? (kStr.charAt(j)-'0') : 0);
            count = cur / 10;
            int mod = cur % 10;
            res.add(0,mod);
            if(i >= 0) i--;
            if(j >= 0) j--;
        }
        return res;
    }
}
