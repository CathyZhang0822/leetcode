import java.util.Comparator;
import java.util.PriorityQueue;

public class kClosetPoints {
    public static void main(String[] args){

    }
    public static int[][] kCloset(int[][] points, int K){
        int[][] res = new int[K][2];
        PriorityQueue<int[]> pqueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]*o1[0]+o1[1]*o1[1])-(o2[0]*o2[0]+o2[1]*o2[1]);
            }
        });
        for(int[] point : points){
            pqueue.add(point);
        }

        for(int i = 0; i < K; i++){
            res[i] = pqueue.poll();
        }
        return res;
    }
}
