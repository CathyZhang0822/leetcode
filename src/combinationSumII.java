import java.util.*;
/* Given a collection of candidate numbers (candidates) and a target number (target),
   find all unique combinations in candidates where the candidate numbers sums to target.
   Each number in candidates may only be used once in the combination.

    Note:
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
    Example:
    Input: candidates = [2,5,2,1,2], target = 5,
    A solution set is:
    [[1,2,2],[5]]
* */
// 相对于combination sum，每个元素不允许重复运用了
public class combinationSumII {
    public static void main(String[] args){
        combinationSumII obj = new combinationSumII();
        int[] nums = {2,2,3,4};
        int target = 7;
        System.out.println(obj.combinationSumII(nums,target));
    }

    private List<List<Integer>> combinationSumII(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        dfs(target,0,candidates,path, res);
        return res;
    }

    private void dfs(int target, int index, int[] nums, List<Integer> path, List<List<Integer>> res){
        if(target <= 0){
            if(target == 0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i = index; i < nums.length; i++){
            // remove duplicates: remove replicate branches of a node
            path.add(nums[i]);
            dfs(target - nums[i], i+1, nums, path, res);
            path.remove(path.size()-1);
        }
    }
}
