import java.util.*;
public class Heap {
    public static void main(String[] args){
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(comp);
        pq.add(1);
        pq.add(2);
        System.out.println(pq.peek());
    }
}
