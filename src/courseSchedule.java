import java.util.*;
public class courseSchedule {
    /*
    There are a total of n courses you have to take, labeled from 0 to n-1.

    Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

    Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

    example:
    Input: 2, [[1,0]]
    Output: true
    Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
    * */
    public static void main(String[] args){
        int numCourses = 2;

    }

    public boolean canFinish(int numCourses, int[][] prerequisites){
        // 1st: build directed graph and indegree array
        int n = numCourses;
        int[][] pres = prerequisites;
        // the directed graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];

        for(int i =0; i<n; i++) graph.put(i, new HashSet<>());

        for(int[] pre : pres){
            int child = pre[0];
            int parent = pre[1];
            // 注意这里是parent : children 形式
            graph.get(parent).add(child);
            indegree[child] ++;
        }
        // BFS topological sort
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            int cur = q.remove();
            count ++;
            for(int child : graph.get(cur)){
                indegree[child] --;
                if(indegree[child] == 0) q.add(child);
            }
        }
        return count == n;
    }


}
