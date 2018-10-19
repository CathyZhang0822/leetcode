import java.util.*;

public class smallestSubtree {
    public static void main(String[] args){
        Codec obj = new Codec();
        String data = "6,2,8,0,4,7,9,N,N,3,5,N,N,N,N,N,N,N,N,";
        TreeNode root = obj.deserilize2(data);
        TreeNode lca = subtreeWithAllDeepest(root);
        System.out.println(lca.val);
    }
/*
    method 1: BFS + Lowest Common Ancestor
    method 2: dfs (discuss 里面大佬说的) 学习一下
* */

    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
    // step 1: find deepest nodes
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> deepest = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> curLevel = new ArrayList<>();
            for(int i = 0; i < size; i ++){
                TreeNode cur = queue.remove();
                curLevel.add(cur);
                if(cur.left != null) {
                    queue.add(cur.left);
                    parents.put(cur.left, cur);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                    parents.put(cur.right, cur);
                }
            }
            deepest = new ArrayList<>(curLevel);
        }
    // step 2: find lowest common ancestor
        Set<TreeNode> set = new HashSet<>(deepest);
        List<TreeNode> prev = new ArrayList<>();
        while(set.size() > 1){
            prev = new ArrayList<>();
            for(TreeNode cur : set){
                prev.add(parents.get(cur));
            }
            set = new HashSet<>(prev);
        }
        return prev.get(0);
    }
}
