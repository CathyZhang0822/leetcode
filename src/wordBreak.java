import java.util.*;
/*
  对于wordbreak I, II(一个是判断true/false 一个是找到所有的paths)
  分别有两种方法可以做，一个是DP,一个是DF（with memorization）
  这里是DFS方法
* */
public class wordBreak {
    public static void main(String[] args){
        wordBreak obj = new wordBreak();
        String s= "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        wordDict.add("leetcode");
        System.out.println(obj.wB(s, wordDict));
        Set<String> words = new HashSet<>(wordDict);
        System.out.println(obj.wB2(s, words));

    }
    // find true/false
    public boolean wB(String s, List<String> wordDict){
        Set<String> words = new HashSet<>(wordDict);
        Map<String, Boolean> map = new HashMap<>();
        return dfs(s, words, map);
    }

    private boolean dfs(String s, Set<String> words, Map<String, Boolean> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        if(words.contains(s)){
            map.put(s, true);
            return true;
        }
        if(s.length() == 1 && !words.contains(s)){
            map.put(s, false);
            return false;
        }
        for(int i = 1; i < s.length(); i++){
            boolean left = dfs(s.substring(0,i), words, map);
            boolean right = dfs(s.substring(i, s.length()),words, map);
            if(left && right){
                map.put(s, true);
                return true;
            }else{
                map.put(s, false);
            }
        }
        return false;
    }

    // find all paths
    //map: string -> its results
    Map<String, List<String>> map = new HashMap<>();
    public List<String> wB2(String s, Set<String> words){
        if(map.containsKey(s)){
            return map.get(s);
        }
        List<String> res = new ArrayList<>();
        if(s.length() == 0){
            res.add("");
        }
        for(int i = 0; i < s.length(); i++){
            if(words.contains(s.substring(i,s.length()))){
                System.out.println(s.substring(i,s.length()));
                List<String> pre = wB2(s.substring(0,i), words);
                for(String e: pre){
                    res.add(e + (e.equals("")? "": " ") + s.substring(i,s.length()));
                }
            }
        }
        map.put(s,res);
        return res;
    }

}
