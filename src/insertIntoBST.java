public class insertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode suc = successor(root, val);
        TreeNode node = new TreeNode(val);
        if(suc != null){
            node.left = suc.left;
            suc.left = node;
            return root;
        }else{
            node.left = root;
            return node;
        }
    }

    private TreeNode successor(TreeNode root, int val){
        TreeNode prev = null;
        while(root != null){
            if(root.val <= val){
                root = root.right;
            }else{
                prev = root;
                root = root.left;
            }
        }
        return prev;
    }
}
