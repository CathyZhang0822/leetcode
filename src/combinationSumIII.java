import java.util.*;
/* Find all possible combinations of k numbers that add up to a number n,
   given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
   Example:
   Input: k = 3, n = 9
   Output: [[1,2,6], [1,3,5], [2,3,4]]
* */
public class combinationSumIII {
    public static void main(String[] args){
        combinationSumIII obj = new combinationSumIII();
        int n = 9;
        int k = 3;
        System.out.println(obj.cS3(n,k));
    }
    // k limits the depth of recursion tree
    private List<List<Integer>> cS3(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n,k,1,path, res);
        return res;
    }

    private void dfs(int target, int level, int index, List<Integer> path, List<List<Integer>> res){
        if(level == 0){
            System.out.println(path);
            if(target == 0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i = index; i <= 9; i++){
            path.add(i);
            dfs(target - i, level - 1, i+1, path, res);
            path.remove(path.size()-1);
        }
    }
}
