import java.util.*;
public class add1Row {
    public static void main(String[] args){
        Codec obj = new Codec();
        String tree = "1,2,3,4,N,N,N";
        TreeNode root = obj.deserilize2(tree);
        addOneRow(root, 5, 4);
        System.out.println(obj.serialize2(root));
    }

    public static TreeNode addOneRow(TreeNode root, int v, int d){
        if(d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while(!queue.isEmpty() && level <= d){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.remove();
                if(cur == null) continue;
                TreeNode left = cur.left;
                TreeNode right = cur.right;
                    if(level == d-1){
                        TreeNode newLeft = new TreeNode(v);
                        cur.left = newLeft;
                        newLeft.left = left;
                    }
                    queue.add(left);
                    if(level == d-1){
                        TreeNode newRight = new TreeNode(v);
                        cur.right = newRight;
                        newRight.right = right;
                    }
                    queue.add(right);

            }
            level ++;
        }
        return root;
    }
}
