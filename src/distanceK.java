import java.util.*;
/*
这道题太好了，我太喜欢了
创建一个新的含有parent的node，clone一遍tree。
然后再用BFS/DFS来做，感觉用BFS做简单点，但是这里我写的DFS
* */

public class distanceK {
    class Node {
        int val;
        Node parent;
        Node left;
        Node right;
        Node(int _val){
            val = _val;
        }
    }
    Node ntarget;
    Set<Node> visited;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        List<Integer> res = new ArrayList<>();
        // clone the tree
        Node newRoot = clone(root, null, target);
        visited = new HashSet<>();
        dfs(ntarget, res, k);
        return res;
    }
    // clone the tree with new feature
    private Node clone(TreeNode root, Node parent, TreeNode target){
        if(root == null) return null;
        Node nRoot = new Node(root.val);
        if(root == target) ntarget = nRoot;
        nRoot.parent = parent == null ? null : parent;
        Node nRootLeft = clone(root.left, nRoot, target);
        Node nRootRight = clone(root.right, nRoot, target);
        nRoot.left = nRootLeft;
        nRoot.right = nRootRight;
        return nRoot;
    }

    private void dfs(Node target, List<Integer> res, int k){
        if(target == null || visited.contains(target)|| k < 0) return;
        if(k == 0){
            res.add(target.val);
            return;
        }
        visited.add(target);
        dfs(target.parent, res, k-1);
        dfs(target.left, res, k-1);
        dfs(target.right, res, k-1);
        visited.remove(target);
    }
}
