import java.util.*;

public class test {
    public static void main(String[] args){
        int[] A = {2, 2, 4, 7, 8};
        //System.out.println(smallestRangeI(A, 3));
        //System.out.println(smallestRangeII(A, 5));
        String cur = "123";
        System.out.println(cur.substring(0,1) + cur.substring(2,3));
        List<Integer> res = Arrays.asList(1,2);
    }
    public  static int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : A){
            if(num < min){
                min = num;
            }
            if(num > max){
                max = num;
            }
        }
        System.out.println(min);
        System.out.println(max);
        return ((max-min) > 2*Math.abs(K)) ? (max-min) - 2*Math.abs(K) : 0;
    }
    public static int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        if(A.length == 1){
            return 0;
        }
        int min = A[0];
        int max = A[A.length-1];
        /*
        if(max - min > K){
            min = min + K;
            max = max - K;
            if(min > max){
                //swap
                int temp = min;
                min = max;
                max =temp;
            }
        }else{
            return max - min;
        }
        System.out.println("max: " + max);
        System.out.println("min: " + min);
        */
        for(int i = 0; i < A.length; i++){
            if((min <= A[i] + K && A[i] + K <= max) || (min <= A[i] - K && A[i] - K <= max)){
                continue;
            }else{
                // can avoid updating min/max -> increasing the different
                if(Math.abs(A[i] + K - max) < Math.abs(- A[i] + K + min)){
                    // need to add K
                    max = A[i] + K;
                    System.out.println("max:" + max);
                }else{
                    min = A[i] - K;
                    System.out.println("min:" + min);
                }

            }
        }
        System.out.println(Arrays.toString(A));
        return (A[A.length-1] - A[0]) > max - min ? max - min :(A[A.length-1] - A[0]);
    }
}
