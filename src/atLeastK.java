import java.util.*;
public class atLeastK {
    public static void main(String[] args){
        String s = "baaabcb";
        int k = 3;
        System.out.println(longestSubstring(s, k));
        Queue<Integer> nums = new LinkedList<>();
        Stack<Character> str = new Stack<>();
        str.push('a');
        str.push('b');
        Stack<Character> str2 = new Stack<>();
        String p = String.valueOf(str);
        System.out.println(str.equals(str2));

    }
    public static int longestSubstring(String s, int k){
        // count the frequency of chars in s
        // if a char's frequency < k, then the substring won't contain it
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(char c:s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 0);
            }
            map.put(c,map.get(c)+1);
        }
        int left = 0;
        int right = 0;
        for(; right <= s.length(); right ++){
            if(right == s.length() || map.get(s.charAt(right)) < k){
                while(!isValid(s.substring(left, right), k) && (left < right)){
                    left ++;
                }
                res = Math.max(right-left, res);
                left = right;
            }
        }
        return res;
    }

    private static boolean isValid(String s, int k){
        Map<Character, Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 0);
            }
            map.put(c,map.get(c)+1);
        }
        for(char key : map.keySet()){
            if(map.get(key) < k){
                return false;
            }
        }
        return true;
    }
}
