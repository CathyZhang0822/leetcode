import java.util.LinkedList;
import java.util.Queue;

public class bipartition {
    public static void main(String[] args){
        int [][] dislikes = {{1,2},{1,3},{2,4}};
        int N = 4;
        System.out.println(canBipBFS(N, dislikes));
    }
    public static boolean canBipBFS(int N, int[][] dislikes){
        // graph 没有像785那样直接给出来，我们就构造一个: adjacent matrix
        int[][] graph = new int[N][N];
        for(int[] edegs:dislikes){
            graph[edegs[0]-1][edegs[1]-1] = 1;
            graph[edegs[1]-1][edegs[0]-1] = 1;
        }
        int[] colors = new int[N];
        for(int i = 0; i < N; i ++){
            if(colors[i] == 0){
                //BFS
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                colors[i]=1;
                while(!queue.isEmpty()){
                    int cur = queue.remove();
                    for(int node = 0; node < N; node ++){
                        if(graph[cur][node] == 1){
                            if(colors[node] == 0){
                                colors[node] = -colors[cur];
                                queue.add(node);
                            }else if(colors[node] == colors[cur]){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
