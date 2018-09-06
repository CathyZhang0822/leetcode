import java.util.*;
public class generateParentheses {
    public static void main(String[] args){
        generateParentheses obj = new generateParentheses();
        System.out.println(obj.generate(3));
    }
    private List<String> generate(int n){
        List<String> res = new ArrayList<>();
        dfs(2*n,0,0, "",res);
        return res;
    }
    private void dfs(int level, int left, int right, String path, List<String> res){
        // base case 不是单指最小的case,而是recursion tree最下面触底反弹的case
        if(level == 0){
            if(left == right){
                res.add(path);
            }
            return;
        }
        dfs(level-1,left+1,right,path+"(",res);
        if(right<left){
            dfs(level-1, left, right+1,path+")",res);
        }
    }
}
