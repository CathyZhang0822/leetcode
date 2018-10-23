import java.util.*;
public class preorder {
    public static void main(String[] args){
        Codec obj = new Codec();
        String tree = "1,N,2,3,N,N,N";
        TreeNode root = obj.deserilize2(tree);
        System.out.println(interativeTraverse(root));
    }
    // method 1: 跟inorder traverse的方法很相近
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
    // method 2: 发现这种方法的时候三观都碎了
    // 很适合继续发展成n-ary
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
        return res;
    }
}
