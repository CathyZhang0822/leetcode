import java.util.*;
public class wordPattern {
    public static void main (String[] args){
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        System.out.println(findAndReplacePattern(words,pattern));
    }
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        //这道题其实没太懂 。。好像是映射关系双方都要保持唯一性
        //比如，aba -> cde 错的因为a -> c，a还->e. 而且 aba -> ccc也是错的，因为 a->c,并且b->c
        //所以要用两个map
        List<String> res = new ArrayList<>();
        // map1: projection word to pattern
        Map<Character, Character> map1 = new HashMap<>();
        // map2: projection pattern to word
        Map<Character, Character> map2 = new HashMap<>();
        for(String word : words){
            boolean match = true;
            map1 = new HashMap<>();
            map2 = new HashMap<>();
            for(int i = 0; i < pattern.length(); i++){
                char s = word.charAt(i);
                char p = pattern.charAt(i);
                map1.putIfAbsent(s, p);
                map2.putIfAbsent(p, s);
                if(map1.get(s) != p || map2.get(p) != s){
                    System.out.println(map1);
                    System.out.println(map2);
                    match = false;
                    break;
                }
            }
            if(match) res.add(word);
        }
        return res;
    }
}
