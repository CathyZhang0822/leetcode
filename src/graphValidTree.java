import java.util.*;
public class graphValidTree {
    // method 1: DFS
    public static boolean validTreeDFS(int n, int[][] edges) {
        // 1: build the graph
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i = 0; i < n; i++) adjlist.add(i, new ArrayList<>());
        for(int[] edge : edges){
            adjlist.get(edge[0]).add(edge[1]);
            adjlist.get(edge[1]).add(edge[0]);
        }
        // 2: check whether there is a cycle
        boolean[] visited = new boolean[n];
        if(hasCycle(adjlist, visited, -1, 0)) return false;
        // 3: check whether all nodes are connected
        for(boolean i : visited) if(!i) return false;

        return true;
    }
    // dfs helper function: check whether there is a cycle
    // 感觉有点像visit matrix ,运用visited。当访问到一个visited node时，说明走出来个环
    private static boolean hasCycle(List<List<Integer>> graph, boolean[] visited, int parent, int node){
        visited[node] = true;
        for(int next : graph.get(node)){
            if (next == parent) continue; // avoid visiting parent node
            if(visited[next] || hasCycle(graph,visited,node,next)) return true;
        }
        return false;
    }


    // method 2: BFS
    // 0: not visited
    // 1: visiting 该node在queue里面，add 进queue的时候标为1
    // 2：visited 从 queue 里remove出来的时候标记为2
    public static boolean validTreeBFS(int n, int[][] edges){
        // 1: build the graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(i, new ArrayList<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        // 2: BFS check whether there is a cycle in it
        int[] visited = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = 1;
        while(!q.isEmpty()){
            //感觉似乎没有必要用size 然后分层traverse了
            int cur = q.remove();
            visited[cur] = 2;
            for(int next : graph.get(cur)){
                if(visited[next] == 1) return false;
                if(visited[next] == 0){
                    q.add(next);
                    visited[next] = 1;
                }else if(visited[next] == 2){
                    continue;
                }
            }
        }
        // 3: check whether all nodes are connected
        for(int i : visited){
            if(i!=2) return false;
        }
        return true;
    }
}
