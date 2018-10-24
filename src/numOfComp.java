import java.util.*;
public class numOfComp {
    // 跟 count number of islands 很像
    public int count(int n, int[][] edges){
        // build the graph
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int res = 0;
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                res ++;
                dfs(map, visited, i);
            }
        }
        return res;
    }

    private void dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, int i){
        if(visited.contains(i)) return;
        visited.add(i);
        for(int child : map.get(i)){
            dfs(map, visited, child);
        }
    }
}
