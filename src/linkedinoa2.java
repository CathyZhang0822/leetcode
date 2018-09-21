import java.util.*;
public class linkedinoa2 {
    public static void main(String[] args){
        int[] a = new int[]{2,3,10,2,8,1};
        System.out.println(maxDifferent(a));
    }
    public static int maxDifferent(int[] a){
        int res = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : a){
            if(pq.size() > 0 && pq.peek() < num){
                res = Math.max(res, num-pq.peek());
            }
            pq.add(num);
        }
        return res;
    }
}
