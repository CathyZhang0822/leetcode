import java.util.*;

public class test {
    public static void main(String[] args){
        String[] nums = {"12","34"};
        String a = nums[0];
        a = "ab";
        System.out.println(Arrays.toString(nums));
        Comparator<Map.Entry<Integer, Integer>> comp = new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        };
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(comp);
    }

}
