import java.util.*;
public class permutations {
    public static void main(String[] args){
        permutations obj = new permutations();
        int[] nums = {1, 2, 3};
        System.out.println(obj.permute(nums));
        System.out.println(obj.permutev2(nums));
    }
    /* Approach 1: dfs 画出recursion tree
                    empty
                 /    |    \
                1     2     3
               / \   / \   / \
              2  3  1   3 1   2
              |  |  |   | |   |
              3  2  3   1 2   1
    * */
    private List<List<Integer>> permute(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> eles = new ArrayList<>();
        for(int num : nums){
            eles.add(num);
        }
        List<Integer> path = new ArrayList<>();
        dfs(path, res, eles);
        return res;
    }
    private void dfs(List<Integer> path, List<List<Integer>> res, List<Integer> nums){
        if(nums.size() ==0 ){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i<nums.size(); i++){
            //去重
            if(i > 0 && nums.get(i) == nums.get(i-1)){
                continue;
            }
            int cur = nums.get(i);
            path.add(cur);
            nums.remove(i);
            dfs(path, res, nums);
            nums.add(i,cur);
            path.remove(path.size()-1);
        }
    }

    // Approach 2: optimize approach 1. Use a boolean array instead of remove/add elements from arraylist everytime.
    private List<List<Integer>> permutev2(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        System.out.println(Arrays.toString(visited));
        List<Integer> path = new ArrayList<>();
        dfs2(path, nums, visited, res);
        return res;
    }

    private void dfs2(List<Integer> path, int[] nums, boolean[] visited, List<List<Integer>> res){
        // base case:
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            // 其实还包含隐含条件
            /* 这个去重条件是自己想出来的，跟标准答案不太一样，但是更加prefer自己的
               1 2 2
               V N N 这种条件下第二个2被跳过了，不然会构建两个 "1 2"
               1 2 2
               V V N 在这种条件下就不能跳过第二个2， 因为在构建 "1 2 2"
            * */
            if(i>0 && !visited[i-1] && nums[i] == nums[i-1]){
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            dfs2(path, nums, visited, res);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }

}
