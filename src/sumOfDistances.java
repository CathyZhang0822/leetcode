import java.util.*;
public class sumOfDistances {
    public static void main(String[] args){
        sumOfDistances obj = new sumOfDistances();
        int N = 2;
        int[][] edges = {{1,0}};
        obj.sumOfDis(N, edges);
        System.out.println(Arrays.toString(obj.count));
        System.out.println(Arrays.toString(obj.res));

    }
    /*
    An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.

    The ith edge connects nodes edges[i][0] and edges[i][1] together.

    Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.

    Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
    Output: [8,12,6,10,10,10]
    Explanation:
    Here is a diagram of the given tree:
      0
     / \
    1   2
       /|\
      3 4 5
    We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
    equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
    * */
    /*
    solution:
    1. build the tree/graph, can use a set array Set[]: tree[i] is Node i's connected children
       需要注意的是不要建成directed!
    2. post order traverse the tree(first traverse all children then root), count[i] : count of nodes of subtree rooted at node i
       count[root] = sum(count[i]) + 1
    3. pre order traverse the tree(from root 0): we know if we move the root to its connected nodes, one part of nodes get
       closer and one part of nodes get farther
       res[i] = res[root] + (N - count[i]) [get further part] - count[i] [get closer part]
    * */
    List<HashSet<Integer>> tree;
    int[] count;
    int[] res;
    public int[] sumOfDis(int N, int[][] edges){
        // step 1: build the tree (build 是directed反而)
        tree = new ArrayList<>();
        for(int i = 0; i < N; i++) tree.add(new HashSet<>());
        // 必须要构建undirected graph!
        for(int[] edge : edges){
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        count = new int[N];
        res = new int[N];
        // step 2: post order traverse the tree，find all count[i] and res[0]
        dfs(0, new HashSet<>());
        // step 3: update all res[i]
        dfs2(0, N, new HashSet<>());
        System.out.println(Arrays.toString(res));
        return res;
    }

    private int dfs(int root, Set<Integer> visited){
        int sum = 0;
        visited.add(root);
        for(int child : tree.get(root)){
            if(visited.contains(child)) continue;
            sum += dfs(child, visited);
            // 这一步很重要！post order traverse的时候顺便把res[root] 求出来！
            res[root] += res[child] + count[child];
        }
        count[root] = sum + 1;
        return sum + 1;
    }

    // key step: res[i] = res[root] + N - count[i] - count[i]
    private void dfs2(int root, int N, Set<Integer> visited){
        Set<Integer> children = tree.get(root);
        visited.add(root);
        for(int child : children){
            if(visited.contains(child)) continue;
            res[child] = res[root] + N - count[child] - count[child];
            dfs2(child, N, visited);
        }
    }

}
