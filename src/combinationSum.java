import java.util.*;
/* 跟COINS那道题一摸一样，别换了个马甲就不认识了
* */
public class combinationSum {
    public static void main(String[] args){
        combinationSum obj = new combinationSum();
        int[] nums = {2,2,3,7};
        int target = 7;
        System.out.println(obj.cS(nums,target));
    }

    private List<List<Integer>> cS(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(target, 0, candidates, path, res);
        return res;
    }

    private void dfs(int target, int index, int[] nums, List<Integer> path, List<List<Integer>> res){
        if(target <= 0){
            if(target == 0){
                // don't forget to new an arraylist
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i=index; i < nums.length; i++){
            /* remove duplicates: remove replicate branches of a node
            * */
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            dfs(target - nums[i],i,nums,path,res);
            path.remove(path.size()-1);
        }
    }
}
