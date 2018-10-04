import java.util.*;

public class test {
    public static void main(String[] args){
        String s = "\"id\": 142, \"ip\": \"123.221.14.56\", \"datestring\": \"[20/Dec/2016:01:14:35 +0000]\", \"timestamp\": 1482196475.303, \"request\": \"GET /img/email.gif HTTP/1.1\", \"code\": \"200\", \"useragent\": \"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0)\", \"size\": 26957";
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
