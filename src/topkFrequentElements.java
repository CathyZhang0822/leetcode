import java.util.*;
public class topkFrequentElements {
    public static void main(String[] args){
        int[] nums = new int[] {1,1,1,2,2,3};
        int k = 2;
        System.out.println(topKFreq(nums,k));
        System.out.println(bucketSort(nums,k));
    }
    /*
    Approach 1: use Priority Queue(max heap)
    Put map entry into maxHeap so we can always poll a number with largest frequency
    Time: n + k*log(n)
    * */
    public static List<Integer> topKFreq(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
            System.out.println(map.get(num));
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println(entry);
            maxHeap.add(entry);
        }
        List<Integer> res = new ArrayList<>();
        while(res.size() < k){
            Map.Entry<Integer, Integer> entry = maxHeap.remove();
            //System.out.println(entry);
            res.add(entry.getKey());
        }
        return res;
    }

    /* Approach 2: Use Bucket Sort Time: O(n)
       Build an array of list to be buckets to sort
       List<Integer>[] array
       index: frequency, array[index]:a list of elements whose frequence == index
    * */
    public static List<Integer> bucketSort(int[] nums, int k){
        //注意创建 List<element> []的语法！
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int num : map.keySet()){
            int frequency = map.get(num);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(num);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = bucket.length-1; i >= 0; i--){
            if(bucket[i] != null){
                res.addAll(bucket[i]);
            }
            if(res.size() >= k){
                break;
            }
        }
        return res;
    }
}
