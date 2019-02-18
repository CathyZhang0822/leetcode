import java.util.*;
import java.util.stream.Collectors;

/**
 * Intuition:
 Write a helper using sliding window,
 to get the number of subarrays with at most K distinct elements.
 Then f(exactly K) = f(atMost K) - f(atMost K-1).

 Of course, you can merge 2 for loop into ones, if you like.

 Time Complexity:
 O(N)
 * **/
public class subArrayKDifferentInteger {
    public static void main(String[] args){
        int[] A = {1,2,1,2,3};
        int K = 2;
        System.out.println(numOfSubarray(A, K));
    }

    public static int numOfSubarray(int[] A, int K){
        return atMostK(A, K) - atMostK(A,K-1);
    }

    public static int atMostK(int[] A, int K){
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int left = 0, right = 0; right < A.length; right ++){
            map.putIfAbsent(A[right],0);
            if(map.get(A[right]) == 0) count ++;
            map.put(A[right], map.get(A[right])+1);
            while(count > K){
                map.put(A[left], map.get(A[left])-1);
                if(map.get(A[left]) == 0) count --;
                left ++;
            }
            res += right - left + 1;
        }
        return res;
    }

}
