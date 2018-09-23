import java.util.*;
public class canUSort {
    public static void main(String[] args){
        int[] arr = new int[] {1,4,2,1,4,3};
        pr(arr);
    }
    private static void pr(int[] arr){
        List<Integer>[] bucket = new List[arr.length+1];
        System.out.println(bucket[0]);
        // key : value = num : frequency
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            if(!map.containsKey(num)){
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        System.out.println(map);
        // put elements into bucket
        for(int num : arr){
            int freq = map.get(num);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        for(int i = bucket.length-1; i > 0; i --){
            if(bucket[i] != null){
                Collections.sort(bucket[i]);
                for(int ele : bucket[i]){
                    System.out.println(ele);
                }
            }
        }
    }
}
