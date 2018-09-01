import java.util.*;
public class longestSubstringKDisctince {
    public static void main(String[] args){
        longestSubstringKDisctince obj = new longestSubstringKDisctince();
        String s = "abcabcabc";
        int k = 3;
        System.out.println(obj.longest(s,k));
    }

    private int longest(String s, int k){
        // same as lc 159
        int res = 0;
        if(s == null || s.length() == 0 || k <= 0){
            return res;
        }
        //(Character, frequency)
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(int left = 0, right = 0; right < s.length(); right ++){
            map.putIfAbsent(s.charAt(right), 0);
            if(map.get(s.charAt(right)) == 0){
                count ++;
            }
            map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            while(count > k){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left)) == 0){
                    count --;
                }
                left ++;
            }
            System.out.println(s.substring(left,right+1));
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}
