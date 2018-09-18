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
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addLast(2);
        Set<Integer> a = new HashSet<>();
        String s = " the sky  is blue";
        String[] ss = s.split(" ");
        System.out.println(s.trim());
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i ++){
            if((i == 0 && chars[i] != ' ') || (chars[i]!= ' '&& chars[i-1]==' ')){
                System.out.println(String.valueOf(chars[i]));
            }
        }
    }
}
