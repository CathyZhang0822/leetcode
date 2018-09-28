import java.util.*;
class pair{
    int val;
    int index;
    pair(int val, int index){
        this.val = val;
        this.index = index;
    }
}

public class forBackpack {
    static int res ;
    public static void main(String[] args){
        List<pair> nums = new ArrayList<>();
        for(int i = 1; i <= 8; i++){
            for(int j = 1; j<= i; j++){
                pair cur = new pair(i,j);
                nums.add(cur);
            }
        }
        System.out.println(nums.size());
        res = 0;
        List<pair> path = new ArrayList<>();
        dfs(0,0,nums, path);
        System.out.println(res);
    }
    private static void dfs(int index, int sum,  List<pair> nums, List<pair> path){
        if(sum <= 23){
            res ++;
            //System.out.println(pprint(path));
        }else{
            return;
        }
        for(int i = index; i < nums.size(); i ++){
            pair cur = nums.get(i);
            path.add(cur);
            dfs(i+1, sum + cur.val, nums, path);
            path.remove(path.size()-1);
        }
    }

    private static String pprint(List<pair> nums){
        StringBuilder sb = new StringBuilder();
        for(pair num : nums){
            sb.append("(" + num.val + ", " + num.index + ")");
        }
        return sb.toString();
    }
}
