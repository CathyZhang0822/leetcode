public class btlongestConSeq {
    public static void main(String[] args){
        Codec obj = new Codec();
        String data = "1,N,2,3,4,N,N,N,5,N,N,";
        TreeNode root = obj.deserilize2(data);
        btlongestConSeq obj2 = new btlongestConSeq();
        System.out.println(obj2.longest(root));
    }
    // simple top down
    // 遍历同时打擂台
    int max;
    public int longest(TreeNode root){
        if(root == null) return 0;
        max = 0;
        dfs(root, root.val-1,0);

        return max;
    }

    private void dfs(TreeNode root, int parent, int path){
        max = Math.max(max, path);
        if(root == null) return;
        if(root.val == parent + 1){
            path = path + 1;
        }else {
            path = 1;
        }

        dfs(root.left, root.val, path);
        dfs(root.right, root.val, path);
    }
}
