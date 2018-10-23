import java.util.*;
public class closetLeaf {
    // step1: dfs traverse the tree to find the target node and build parent hashmap
    // step2: bfs traverse the graph, find the closest leaf
    HashMap<TreeNode, TreeNode> map;
    TreeNode target;
    public int findClosestLeaf(TreeNode root, int k) {
        // step 1
        map = new HashMap<>();
        target = null;
        dfs(root, null, k);

        // step 2
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        // 注意这里的细节，是add 进queue里面的时候标记为visited
        queue.add(target);
        visited.add(target);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.remove();
                if(cur.left == null && cur.right == null) {
                    return cur.val;
                }
                // 3 directions
                // left
                if(cur.left != null && !visited.contains(cur.left)){
                    queue.add(cur.left);
                    visited.add(cur.left);
                }
                // right
                if(cur.right != null && !visited.contains(cur.right)){
                    queue.add(cur.right);
                    visited.add(cur.right);
                }
                // parent
                if(map.get(cur) != null && !visited.contains(map.get(cur))){
                    queue.add(map.get(cur));
                    visited.add(map.get(cur));
                }
            }
        }
        return -1;
    }

    private void dfs(TreeNode root, TreeNode parent, int k){
        if(root == null) return;
        if(root.val == k) target = root;
        map.put(root, parent);
        dfs(root.left, root, k);
        dfs(root.right, root, k);
    }
}
