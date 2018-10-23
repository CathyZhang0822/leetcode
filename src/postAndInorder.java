public class postAndInorder {
    /*       3
           /   \
          2     9
         / \   /  \
        1   4  5   17
    * */
    public static void main(String[] args){
        Codec obj = new Codec();
        int[] inorder = {1,2,3,4};
        int[] postorder = {3,2,4,1};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(obj.serialize2(root));
    }
    // postorder reverse之后，就是左右对称的preorder
    // debug 了好久，各种细节问题。印象比较深的一个细节就是，要用postend 减了，而不是用poststart 加
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] reverse_post = new int[postorder.length];
        for(int i = 0; i < postorder.length; i++){
            reverse_post[i] = postorder[postorder.length-1-i];
        }
        // 注意范围，小心不要越界了
        return helper(inorder, reverse_post, 0, inorder.length-1, 0, postorder.length-1);
    }
    // 果然用postend有好处的，这里就用上了。
    private static TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart == inEnd) return new TreeNode(inorder[inStart]);
        if(inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postStart]);
        int i = inStart;
        for(; i <= inEnd; i++){
            if(inorder[i] == root.val) break;
        }
        // left tree:
        TreeNode left = helper(inorder, postorder, inStart, i-1, postEnd+1-(i-inStart), postEnd);
        // right tree:
        TreeNode right = helper(inorder, postorder, i+1, inEnd, postStart+1, postEnd-(i-inStart));

        root.left = left;
        root.right = right;
        return root;
    }
}
