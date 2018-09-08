import java.util.*;
public class inorder {

    public static void main(String[] args){
        Codec obj = new Codec();
        String tree = "1,N,2,3,N,N,N";
        TreeNode root = obj.deserilize2(tree);
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root,res);
        System.out.println(res);
        System.out.println(inorderInterative(root));
    }
    // recursive
    public static void inorderTraversal(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        // inorder: left -> v -> right
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }

    // iterative method using a stack
    public static List<Integer> inorderInterative(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            // at this time: cur == null
            // need to pop one and add new nodes into the stack
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
