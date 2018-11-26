import java.util.*;

public class minIncreUnique {
    public static void main(String[] args){
        int[] A = {1, 2, 2 , 2};
        System.out.println(minIncre(A));
    }

    public static int minIncre(int[] A){
        int res = 0;
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        for(int num : A){
//            treeMap.putIfAbsent(num, 0);
//            treeMap.put(num, treeMap.get(num) + 1);
//        }
//        System.out.println(treeMap);
//        for(int key : treeMap.keySet()){
//           int value = treeMap.get(key);
//            if(value > 1){
//                res += value - 1;
//                int nextKey = key + 1;
//                treeMap.putIfAbsent(nextKey, 0);
//                int nextValue = treeMap.get(nextKey) + value - 1;
//                treeMap.put(nextKey, nextValue);
//            }
//            System.out.println(key);
//        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : A){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        max = Math.max(max, A.length);
        int[] bucket = new int[2*max];
        for(int num : A){
            bucket[num] += 1;
        }
        for(int i = 0; i < bucket.length; i++){
            int value = bucket[i];
            if(value > 1){
                res += value - 1;
                bucket[i+1] += value - 1;
            }
            System.out.println(Arrays.toString(bucket));
        }
        return res;
    }
}
