import java.util.*;

public class longestSubstringTwoDistinct {
    public static void main(String[] args){
        longestSubstringTwoDistinct obj = new longestSubstringTwoDistinct();
        String s = "ecebaaaaae";
        System.out.println(obj.longest(s));
    }
    /* Given a string s, find the length of the longest substring t that contains at most 2 distinct characters
       注意是 "AT MOST"，比"EXACTLY EQUAL"简单一些
    * */
    private int longest(String s){
        int res = 0;
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int count = 0; // how many distinct characters in substring
        for(int left = 0, right = 0; right < s.length(); right ++){
            map.putIfAbsent(s.charAt(right), 0);
            if(map.get(s.charAt(right)) == 0){
                count ++;
            }
            map.put(s.charAt(right),map.get(s.charAt(right))+1);
            while(left <= right && count > 2){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0){
                    count --;
                }
                left ++;
            }
            System.out.println(s.substring(left, right+1));
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}
