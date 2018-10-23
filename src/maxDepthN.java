public class maxDepthN {
    // bottom to up 超时了，可以考虑top down dfs 或者 bfs
    // 现在写一下top down dfs
    int max = 0;
    public int maxDepth(Node root) {
        dfs(root, 1);
        return max;
    }
    private void dfs(Node root, int depth){
        if(root == null) return;
        max = Math.max(max, depth);
        for(Node child : root.children){
            dfs(child, depth+1);
        }
    }
}
