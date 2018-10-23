import java.util.Arrays;

public class btlongestConSeqII {
    public static void main(String[] args){
        Codec obj = new Codec();
        String data = "1,2,3,N,N,N,N,";
        TreeNode root = obj.deserilize2(data);
        btlongestConSeqII obj2 = new btlongestConSeqII();
        System.out.println(obj2.longest(root));
    }
    // top down then bottom up. O(n) time
    // 遍历同时打擂台
    int max;
    public int longest(TreeNode root){
        max = 0;
        dfs(root);
        return max;
    }

    // return int[]: longest increasing and longest decreasing
    private int[] dfs(TreeNode root){
        if(root == null) return new int[]{0,0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] cur = new int[] {1,1};
        if(root.left!=null && (root.left.val == root.val+1 || root.left.val == root.val-1)){
            if(root.left.val > root.val){
                cur[1] = Math.max(left[1]+1, cur[1]);
            }else{
                cur[0] = Math.max(left[0]+1, cur[0]);
            }
        }
        if(root.right!=null && (root.right.val == root.val+1 || root.right.val == root.val-1)){
            if(root.right.val > root.val){
                cur[1] = Math.max(right[1]+1, cur[1]);
            }else{
                cur[0] = Math.max(right[0]+1, cur[0]);
            }
        }
        System.out.println("root:" + root.val);
        System.out.println("int[]: " + Arrays.toString(cur));
        max = Math.max(max, cur[0]+cur[1]-1);
        return cur;
    }
}
