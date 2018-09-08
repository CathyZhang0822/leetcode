import java.util.*;
public class preorder {
    public static void main(String[] args){
        Codec obj = new Codec();
        String tree = "1,N,2,3,N,N,N";
        TreeNode root = obj.deserilize2(tree);
        System.out.println(interativeTraverse(root));
    }
    // preorder: v -> left -> right
    // iterative method using a stack
    public static List<Integer> interativeTraverse(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            // at this time: cur == null
            // need to pop one and add new nodes into the stack
            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }
}
