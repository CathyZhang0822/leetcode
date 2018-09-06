import java.util.*;
public class letterCombinations {
    String[] phone = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args){
        letterCombinations obj = new letterCombinations();
        String digits = "23";
        System.out.println(obj.letterCombinations(digits));
    }
    private List<String> letterCombinations(String digits){
        List<String> res = new ArrayList<>();
        //以数字，字母为KEY的hashmap其实都可以用个array来代替
        //String[] phone = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        dfs(0,digits, res,"");
        return res;
    }
    private void dfs(int level, String digits, List<String> res, String path){
        if (level == digits.length()){
            res.add(path);
            return;
        }
        String cur = phone [(int) digits.charAt(level)-'0'];
        System.out.println(cur);
        for(char c : cur.toCharArray()){
            /* 注意这里！
               不能 path += c; dfs(level+1, digits, phone, res,path);
               看来要系统学习一下call by reference/call by value
            * */
            dfs(level+1, digits, res,path+c);
        }
    }
}
