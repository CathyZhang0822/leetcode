import java.util.*;
public class combinations {
    public static void main(String[] args){
        combinations obj = new combinations();
        int[] nums = {1,2,3,4,5};
        int k = 3;
        System.out.println(obj.combine(nums,k));
    }
    /*
    原题目要求：Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
    自己做一下改编：Given an int array and an integer k, return all possible combinations of k number out of that array.
    主要是想自己考一下自己遇到duplicates的情况
    Time: O(C(n,k)/C(k)) ~= O(n!)
     */
    private List<List<Integer>> combine(int[] nums, int k){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0,k,nums, path, res);
        return res;
    }

    private void dfs(int index, int k, int[] nums, List<Integer> path, List<List<Integer>> res){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1])
                continue;
            path.add(nums[i]);
            dfs(i+1,k,nums,path,res);
            path.remove(path.size()-1);
        }
    }
}
