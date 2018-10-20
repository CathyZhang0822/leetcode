public class binaryTreeUpsideDown {
    /*
        思路跟reverse linked list非常像！
        也是有recursive 和 iterative的方法
    * */
    // method 1: recursive
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return null;
        if(root.left == null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        // do something: change edges
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    // method 2: iterative 的方法
    public TreeNode upsideDownBinaryTree2(TreeNode root) {
        TreeNode cur = root;
        TreeNode left = null;
        TreeNode right = null;
        while(cur != null){
            // store nodes which will be used next iteration before any changes
            // because if we change any node, those nodes can't be access
            TreeNode next = cur.left;
            TreeNode nextRight = cur;
            TreeNode nextLeft = cur.right;
            // change edges
            cur.left = left;
            cur.right = right;
            // update nodes using information we stored at first
            cur = next;
            left = nextLeft;
            right = nextRight;
        }
        return right;
    }
}
