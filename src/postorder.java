import java.util.*;
public class postorder {
    public List<Integer> postorderTraversal(TreeNode root) {
        // post: 左 右 root
        // pre: root 左 右
        // 观察出是reverse preorder之后再把list reverse一下
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode move = root;
        while(!stack.isEmpty() || move != null){
            if(move != null){
                stack.push(move);
                res.add(move.val);
                move = move.right;
            }else{
                TreeNode p = stack.pop();
                move = p.left;
            }
        }
        Collections.reverse(res);
        return res;
    }
}
