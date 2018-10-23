public class preAndPost {
    /*       3
           /   \
          2     9
         / \   /  \
        1   4  5   17
    * */
    public static void main(String[] args){
        Codec obj = new Codec();
        int[] pre = {3,2,1,4,9,5,17};
        int[] post = {1,4,2,5,17,9,3};
        TreeNode root = constructFromPrePost(pre, post);
        System.out.println(root.right.val);
        System.out.println(obj.serialize2(root));
    }
    /*
        pre: 3,   2,   1,   4,   9,   5,   17
            root  ---left----    ---right---
      re-po: 3,   9,   17,  5,   2,   4,   1
            root  ---right---    ---left----
    * */
    public static TreeNode constructFromPrePost(int[] pre, int[] post){
        int[] reverse_post = new int[post.length];
        for(int i = 0; i < post.length; i++){
            reverse_post[i] = post[post.length-1-i];
        }
        return helper(pre, reverse_post, 0, pre.length-1, 0, reverse_post.length-1);
    }

    private static TreeNode helper(int[] pre, int[]repost, int prest, int prend, int repostsrt, int repostend){
        if(prest > prend) return null;
        if(prest == prend) return new TreeNode(pre[prest]);

        TreeNode root = new TreeNode(pre[prest]);

        int i = prest+1;
        for(; i <= prend; i++){
            if(pre[i] == repost[repostsrt + 1]) break;
        }

        TreeNode left = helper(pre, repost, prest+1, i-1, repostend -(i-prest-1)+1, repostend);
        TreeNode right = helper(pre, repost, i, prend, repostsrt+1, repostend -(i-prest-1));

        root.left = left;
        root.right = right;

        return root;
    }
}
