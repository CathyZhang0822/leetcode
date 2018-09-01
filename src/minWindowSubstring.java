import java.util.*;

public class minWindowSubstring {
    public static void main(String[] args){
        minWindowSubstring obj = new minWindowSubstring();
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(obj.minWindow(s,t));
    }
    /* Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
       Input: S = "ADOBECODEBANC", T = "ABC"
       Output: "BANC"
    * */
    // two pointers, sliding window algorithm
    private String minWindow(String s, String t){
        String res = "";
        if(s == null || t == null || s.length() < t.length()){
            return res;
        }
        int min = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(char ele: t.toCharArray()){
            map.put(ele, map.getOrDefault(ele,0)+1);
        }
        int counter = map.size();
        //int lo = 0, hi = 0;
        for(int lo=0, hi=0; hi < s.length(); hi ++){
            // move right pointer to find a valid substring
            if(map.containsKey(s.charAt(hi))){
                map.put(s.charAt(hi),map.get(s.charAt(hi)) - 1);
                if(map.get(s.charAt(hi)) == 0){
                    counter --;
                }
            }
            // move left pointer to find a min substring
            while(counter == 0 && lo <= hi){
                // pay attention to "<="
                // don't forget to update min's valueß
                if(hi - lo + 1 <= min){
                    res = s.substring(lo, hi+1);
                    min = hi - lo + 1;
                }
                if(map.containsKey(s.charAt(lo))){
                    map.put(s.charAt(lo), map.get(s.charAt(lo)) + 1);
                    if(map.get(s.charAt(lo)) > 0){
                        counter ++;
                    }
                }
                lo ++;
            }
        }
        return res;
    }
}
