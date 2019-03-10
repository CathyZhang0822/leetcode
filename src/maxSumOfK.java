import java.util.LinkedList;
import java.util.PriorityQueue;

public class maxSumOfK {
    public static void main(String[] args){

    }

    public static int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int element : A){
            pq.add(element);
        }
        for(int i = 0; i < K; i ++){
            int cur = pq.remove();
            int transfer = 0 - cur;
            pq.add(transfer);
        }
        int res = 0;
        while(!pq.isEmpty()){
            res += pq.remove();
        }
        return res;
    }
}
