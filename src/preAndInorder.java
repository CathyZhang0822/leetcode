public class preAndInorder {
    /*       3
           /   \
          2     9
         / \   /  \
        1   4  5   17
    * */
    public static void main(String[] args){
        Codec obj = new Codec();
        int[] inorder = {1,2,4,3,5,9,17};
        int[] preorder = {3,2,1,4,9,5,17};
        TreeNode root = construct(inorder, preorder);
        System.out.println(obj.serialize2(root));
    }

    public static TreeNode construct(int[] inorder, int[] preorder){
        TreeNode root = helper(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1);
        return root;
    }
    // 其实这个helper function里面的preEnd 可以省略的，因为除了传递函数里面，并没有用上。
    // 但是如果有的话会有助于理解
    private static TreeNode helper(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd){
        System.out.println(preStart);
        // base case
        if(inStart == inEnd) return new TreeNode(inorder[inStart]);
        if(inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int i = inStart;
        for(; i <= inEnd; i++){
            if(inorder[i] == root.val) break;
        }
        // left tree: inorder(inStart -> i) preorder(prestart+1 -> prestart+1+i-inStart)
        // right tree: inorder(i+1, inEnd) preorder(prestart+1+i-inStart -> preend)
        TreeNode left = helper(inorder, preorder, inStart, i-1, preStart+1, preStart+1+i-inStart);
        TreeNode right = helper(inorder, preorder, i+1, inEnd, preStart+1+i-inStart, preEnd);
        root.left = left;
        root.right = right;
        return root;
    }
}
