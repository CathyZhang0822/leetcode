import java.util.*;

/**
 * Explanation:
 Global integer i indicates next index in voyage v.
 If current node == null, it's fine, we return true
 If current node.val != v[i], doesn't match wanted value, return false
 If left child exist but don't have wanted value, flip it with right child.
 * **/
public class flipBinaryTree {
    public static void main(String[] args){

    }
    int index;
    List<Integer> ans;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        index = 0;
        ans = new ArrayList<>();
        return dfs(root,voyage) ? ans : Arrays.asList(-1);
    }

    public boolean dfs(TreeNode root, int[] v){
        if(root == null) return true;
        if(root.val != v[index]) return false;
        index ++;
        if(root.left != null && root.left.val!=v[index]){
            /** flip **/
            ans.add(root.val);
            return dfs(root.right,v) && dfs(root.left,v);
        }
        return dfs(root.left,v) && (dfs(root.right,v));
    }
}
