import java.util.*;
public class subsetsII {
    public static void main(String[] args){
        subsetsII obj = new subsetsII();
        int[] nums = {1,2,2,4};
        System.out.println(obj.subsetsWithDup(nums));
    }
    private List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int pos, List<Integer> path, List<List<Integer>> res){
        if(pos > nums.length){
            return;
        }
        res.add(new ArrayList<>(path));
        for(int i = pos; i < nums.length; i++){
            /* remove duplicates
            In the recursion tree, for each node, we need to remove duplicate branches.
            * */
            if(i > pos && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i+1, path, res);
            path.remove(path.size()-1);
        }
    }
}
