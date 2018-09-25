import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class isBipartite {
    public static void main(String[] args){
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBip(graph));
    }
    /*
    The graph is given in the following form:
    graph[i] is a list of indexes j for which the edge between nodes i and j exists.
    非常经典的一道题：
    1。 从一个没有染色的node开始，BFS把所有与之构成graph的node染色
    2。 继续从另一个没有染色的node开始，直到所有的node都染色了
    * */
    public static boolean isBip(int[][] graph){
        // 0: no color 1:blue color -1: red color
        int[] colors = new int[graph.length];
        for(int i = 0; i < colors.length; i++){
            // find a node which is not colored yet
            if(colors[i] == 0){
                // bfs, fill colors to its connected nodes
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                colors[i] = 1;
                while(!queue.isEmpty()){
                    int cur = queue.remove();
                    for(int child:graph[cur]){
                        if(colors[child] == 0){
                            colors[child] = -colors[cur];
                            queue.add(child);
                        }else if(colors[child] == colors[cur]){
                            return false;
                        }else{
                            continue;
                        }
                    }
                }
            }
        }
        return true;
    }
}
