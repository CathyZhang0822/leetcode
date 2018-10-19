import java.util.*;
public class inorderSuccessor {
    public static void main(String[] args){
        Codec obj = new Codec();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n3.left = n1;
        n3.right = n4;
        n1.right = n2;
        System.out.println(obj.serialize2(n3));
        TreeNode successor = suc(n3, n2);
        System.out.println(successor.val);
    }
    // optimal solution: time: O(h) take advantage of BST !!
    public static TreeNode sucOpt(TreeNode root, TreeNode p){
        TreeNode prev = null;
        while(root != null){
            if(root.val <= p.val){
                root = root.right;
            }else{
                prev = root;
                root = root.left;
            }
        }
        return prev;
    }
    // 自己想用stack的方法做 time: O(N) space: O(H) | （可用于一般的Binary Tree!）
    // 关键是自己想到，在stack pop的时候，每个pop出的都是按照顺序的(这点熟练掌握！！)(不仅仅是按照大小顺序，而且是inorder顺序)
    // 所以我就从大到小pop，（reverse inorder）的顺序。顺便记录prev的值。当pop出的是target时，返回prev
    public static TreeNode suc(TreeNode root, TreeNode p){
        Stack<TreeNode> sucStack = new Stack<>();
        TreeNode move = root;
        TreeNode prev = null;
        while(move != null || !sucStack.isEmpty()){
            if(move != null){
                sucStack.push(move);
                move = move.right;
            }else{
                TreeNode node = sucStack.pop();
                // do something
                if(node == p) return prev;
                prev = node;
                move = node.left;
            }
        }

        return null;
    }
}
