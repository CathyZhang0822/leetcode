public class bstFromPreorder {
    public static void main(String[] args){
        int[] preorder = {8,5,1,7,10,12};
        TreeNode root = bstFromPreorder(preorder);
        System.out.println(pre(root));
    }

    public static TreeNode bstFromPreorder(int[] preorder){
        return dAC(preorder, 0, preorder.length-1);
    }

    public static TreeNode dAC(int[] preorder, int s, int e){
        if(s == -1 || s > e){
            return null;
        }
        TreeNode root = new TreeNode(preorder[s]);
        if(s  == preorder.length-1 || s == e){
            return root;
        }
        int p = -1;
        for(int i = s+1; i <= e; i++){
            if(preorder[i] > root.val){
                p = i;
                break;
            }
        }
        TreeNode left = dAC(preorder, s+1, (p == -1 ? e : (p-1)));
        TreeNode right = dAC(preorder, p, e);
        root.left = left;
        root.right = right;
        return root;
    }

    public static String pre(TreeNode root){
        StringBuilder sb = new StringBuilder();
        if(root == null){
            return "null, ";
        }
        sb.append(root.val + ", ");
        sb.append(pre(root.left));
        sb.append(pre(root.right));
        return sb.toString();
    }
}
