public class inorderBST {
    TreeNode prev;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        prev = dummy;
        inorder(root);
        return dummy.right;
    }

    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        prev.right = root;
        root.left = null;
        prev = root;
        inorder(root.right);
    }
}
