import java.util.*;
public class BSTIterator {

    Stack<TreeNode> stack;
    TreeNode move;
    public BSTIterator(TreeNode root){
        stack = new Stack<>();
        move = root;
    }

    public boolean hasNext(){
        return (move != null || !stack.isEmpty());
    }

    public TreeNode next(){
        while(move != null){
            stack.push(move);
            move = move.left;
        }
        TreeNode node = stack.pop();
        move = node.right;
        return node;
    }

}
