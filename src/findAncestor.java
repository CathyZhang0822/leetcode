import java.util.*;
public class findAncestor {
    /*
    输入是int[][] input, input[0]是input[1] 的parent，比如 {{1,4}, {1,5}, {2,5}, {3,6}, {6,7}}会形成上面的图
    第一问是只有0个parents和只有1个parent的节点
    第二问是 两个指定的点有没有公共祖先 
    第三问是就一个点的最远祖先，如果有好几个就只需要输出一个就好，举个栗子，这里5的最远祖先可以是1或者2，输出任意一个就可以 
    * */
    public static void main(String[] args){
        int[][] edges = {{1,4}, {1,5}, {2,5}, {3,6}, {7,2}};
        int a = 4;
        int b = 5;
        System.out.println(hasCommon(edges,a,b));
    }
    // 第一问：就假设输出有一个parent的吧
    public static List<Integer> findparent(int[][] edges, int n){
        int[] indegree = new int[n];
        for(int[] edge: edges){
            int child = edge[1];
            indegree[child] ++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 1) res.add(i);
        }
        return res;
    }

    // 第二问：两个指定的点有没有公共祖先
    // 思路：找出a,b的所有ancestors,这时候就要用map来存所有点的parent了
    // 思考，如果a就是b的parent。。。
    public static boolean hasCommon(int[][] edges, int a, int b){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge:edges){
            int parent = edge[0];
            int child = edge[1];
            map.putIfAbsent(child, new ArrayList<>());
            map.get(child).add(parent);
        }
        Set<Integer> a_parents = allAncestors(map, a);
        Set<Integer> b_parents = allAncestors(map, b);
        for(int x : b_parents){
            if(a_parents.contains(x)) return true;
        }
        return false;
    }

    //用的BFS找出所有ancestor，也可以用DFS
    private static Set<Integer> allAncestors(Map<Integer, List<Integer>> map, int a){
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        while(!queue.isEmpty()){
            int cur = queue.remove();
            set.add(cur);
            List<Integer> parents = map.get(cur);
            if(parents == null) continue;
            for(int p : parents){
                queue.add(p);
            }
        }
        return set;
    }

    // 第三问：一个点的最远祖先，感觉就是用DFS做
    // int[] res来作为helper int[]， res[0] = 当前level, res[1]就是当前level的ancestor。用来打擂台
    public static void dfs(Map<Integer, List<Integer>> map, int a, int[] res, int level){
        if(level > res[0]){
            // find a higher ancestor
            // update highest level and hightes ancestor
            res[0] = level;
            res[1] = a;
        }
        List<Integer> parents = map.get(a);
        if(parents != null && parents.size()!=0){
            for(int parent:parents){
                dfs(map, parent, res, level+1);
            }
        }
    }
}
