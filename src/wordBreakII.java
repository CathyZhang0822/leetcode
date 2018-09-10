import java.util.*;
public class wordBreakII {
    public static void main(String[] args){
        wordBreakII obj = new wordBreakII();
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cat", "cats", "sand", "and", "dog"));
        System.out.println(obj.wordBreak(s, wordDict));
        System.out.println(obj.wordBreakII(s, wordDict));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        // convert the worddict into a hashset
        Set<String> words = new HashSet<>(wordDict);
        boolean[] DP = new boolean[s.length() +1];
        DP[0] = true;
        for(int i = 1; i < DP.length; i++){
            for(int pre = 0; pre < i; pre ++){
                if(DP[pre] && words.contains(s.substring(pre,i))){
                    DP[i] = true;
                    break;
                }
                DP[i] = false;
            }
            //System.out.println(Arrays.toString(DP));
        }

        return DP[s.length()];
    }

    public List<String> wordBreakII(String s, List<String> wordDict){
        Set<String> words = new HashSet<>(wordDict);
        LinkedList<String>[] DP = new LinkedList[s.length()+1];
        DP[0] = new LinkedList<>();
        DP[0].add("");
        for(int i = 1; i < DP.length; i++){
            LinkedList<String> cur = new LinkedList<>();
            for(int pre = 0; pre < i; pre++){
                if(DP[pre].size() > 0 && words.contains(s.substring(pre,i))){
                    for(String e: DP[pre]){
                        cur.add(e + (e.equals("") ? "": " ") + s.substring(pre,i));
                    }
                }
            }
            DP[i] = cur;
        }
        return DP[s.length()];
    }
}
