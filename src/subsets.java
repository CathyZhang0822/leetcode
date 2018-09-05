import java.util.*;
public class subsets {
    public static void main(String[] args){
        subsets obj = new subsets();
        int[] nums = {1,2,3};
        System.out.println(obj.subsets(nums));
    }
    /* 这道题是DFS经典中的经典
       关键是如何画出recursion tree。而画出recursion tree的关键在于清楚树有几层，每个Node有几个叉
       这道题可以用两种recursion tree来做
    * */
    private List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs2(nums,0, path, res);
        return res;
    }
    /* approach 1：二叉树
                  empty
                  /  \
                 1    _
                / \   / \
               12  1  2  _
              / \ / \ /\ /\
           123 12 13 1 23 2 3 _
          到最后一层的时候，把所有的path放进去
    * */
    private void dfs(int[] nums, int level, List<Integer> path, List<List<Integer>> res){
        if(level >= nums.length){
            System.out.println(path);
            res.add(new ArrayList<>(path));
            return;
        }
        dfs(nums, level+1, path, res);
        path.add(nums[level]);
        dfs(nums, level+1, path, res);
        path.remove(path.get(path.size()-1));
    }
    /* approach 2: n 叉树 （更容易处理含有duplicates的问题）
                    empty
                 /    |    \
                1     2     3
               / \    |
              2   3   3
             /
            3
       在每个NODE都把path放进去
    * */
    private void dfs2(int[] nums, int pos, List<Integer> path, List<List<Integer>> res){
        if(pos >= nums.length){
            return;
        }
        res.add(new ArrayList<>(path));
        for(int i = pos; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums, i+1, path, res);
            path.remove(path.size()-1);
        }
    }
}
