import java.util.*;
public class validBST {
    public static void main(String[] args){
        Codec obj = new Codec();
        String tree = "5,1,N,N,4,3,N,N,6,N,N,";
        /*
                        5
                       / \
                      1   4
                         / \
                        3   6
        * */
        TreeNode root = obj.deserilize1(tree);
        //以下验证了是对的
        //System.out.println(obj.serialize2(root)); // 5,1,4,N,N,3,6,N,N,N,N,
        //System.out.println(obj.serialize1(root)); // 5,1,N,N,4,3,N,N,6,N,N,
        validBST bst = new validBST();
        System.out.println(bst.isValid1(root));
        System.out.println(bst.isValid2(root));
        System.out.println(bst.isValid3(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public boolean isValid1(TreeNode root){
        List<Integer> res= new ArrayList<>();
        inorder(root, res);
        for(int i=1; i < res.size(); i++){
            if(res.get(i) <= res.get(i-1)){
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public boolean isValid2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        /* 我在这里是直接把最一开始的pre设成了integer的最小值，
           但是LC里面又一个case就是root是 integer MIN。所以可以设成 long pre = Long.MIN_VALUE;
        * */
        int pre = Integer.MIN_VALUE;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(cur.val <= pre){
                return false;
            }
            pre = cur.val;
            cur = cur.right;
        }
        return true;
    }

    public boolean isValid3(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }

        if(root.val <= min || root.val >= max){
            return false;
        }
        boolean left = isValid3(root.left, min, root.val);
        boolean right = isValid3(root.right, max, root.val);
        return left && right;
    }
}
