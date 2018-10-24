import java.util.*;
/*
    Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5

    Output: [3, 4]
* */
public class mht {
    public static void main(String[] args){
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}};
        int n = 6;
        System.out.println(findMinHeightTrees(n, edges));
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // step1: build graph and indegree array
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i ++) graph.add(i, new HashSet<>());
        int[] indegree = new int[n];
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]] ++;
            indegree[edge[1]] ++;
        }

        // step2: BFS start from leaves [indegree == 1]
        boolean[] visited = new boolean[n];
        int numRemoved = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 1) {
                q.add(i);
            }
        }
        // 剩下一个或两个没有被visit, 就是我们想要的answer!
        while(numRemoved < n - 2){
            int size = q.size();
            for(int i = 0; i < size; i++){
                // remove的时候标记为visited!
                int cur = q.remove();
                if(visited[cur]) continue;
                numRemoved ++;
                visited[cur] = true;
                System.out.println("cur: " + cur);
                for(int child : graph.get(cur)){
                    indegree[child] --;
                    if(indegree[child] == 1){
                        q.add(child);
                    }
                }
            }
        }
        System.out.println(q);
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!visited[i]) res.add(i);
        }
        return res;
    }
}
