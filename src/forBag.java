import java.util.*;
public class forBag {
    static int res ;
    public static void main(String[] args){
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= 8; i++){
            for(int j = 1; j<= i; j++){
                nums.add(i);
            }
        }
        System.out.println(nums.size());
        res = 0;
        List<Integer> path = new ArrayList<>();
        dfs(0,0,nums, path);
        System.out.println(res);
    }
    private static void dfs(int index, int sum,  List<Integer> nums, List<Integer> path){
        if(sum <= 23){
            res ++;
            //System.out.println(pprint(path));
        }else{
            return;
        }
        for(int i = index; i < nums.size(); i ++){
            int cur = nums.get(i);
            path.add(cur);
            dfs(i+1, sum + cur, nums, path);
            path.remove(path.size()-1);
        }
    }
}

