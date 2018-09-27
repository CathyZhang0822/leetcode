import java.util.*;
public class baiduoa {
    /*
    1-n 有多少个不上升序列，有多少个不下降序列
    * */
    static int res;
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args){
        res = 0;
        int n = 3;
        int[] nums = new int[n];
        for(int i=0; i < n; i++){
            nums[i] = i+1;
        }
        dfs(0, 0, "", nums);
        System.out.println(res);
        System.out.println(mmdfs(0,0,nums));
    }

    public static void dfs(int level, int index, String path, int[] nums){
        if(level == nums.length){
            res ++;
            System.out.println(path);
            return;
        }
        for(int i = index; i < nums.length; i++){
            dfs(level+1, i, path+nums[i], nums);
        }
    }

    // method2: memorized dfs
    public static int mmdfs(int level, int index, int[] nums){
        String key = level+","+index;
        if(map.containsKey(key)) return map.get(key);
        if(level == nums.length) return 1;
        int sum = 0;
        for(int i = index; i < nums.length; i++){
            sum += mmdfs(level+1, i, nums);
        }
        return sum;
    }

}
