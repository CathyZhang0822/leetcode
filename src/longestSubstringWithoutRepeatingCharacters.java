import java.util.*;
public class longestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        longestSubstringWithoutRepeatingCharacters obj = new longestSubstringWithoutRepeatingCharacters();
        String s = "abbcd";
        System.out.println(obj.longest(s));
        System.out.println(obj.longestv2(s));
    }
    // method 1: two pointers, sliding window
    /* move the right pointer to find longest length, move the left pointer to find a valid substring
       Use a hashmap(char,frequency) and a count value to help identify whether the substring is valid
       count: how many repeating characters in the substring
    * */
    private int longest(String s){
        int res = 0;
        if(s == null || s.length() == 0){
            return res;
        }
        // char , frequency
        Map<Character, Integer> map = new HashMap<>();
        int count = 0; // how many repeating characters
        for(int left=0, right=0; right < s.length(); right++){
            map.putIfAbsent(s.charAt(right), 0);
            if(map.get(s.charAt(right)) == 1){
                count ++;
            }
            map.put(s.charAt(right), map.get(s.charAt(right))+1);
            while(left<=right && count >= 1){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                //呵呵又傻逼了，又把map.get(s.charAt(left)) 写成s.charAt(left)了，debug了好久
                //下次应该先把值取出来 char leftVal = s.charAt(left) / map.get(leftVal) 这样
                if(map.get(s.charAt(left)) == 1){
                    count --;
                }
                left ++;
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }

    // method2: we don't need to move left pointer little by little.
    // we can directly move it to the latest index of current repeating character.
    // use a hashmap (char,index) to help store index
    private int longestv2(String s){
        int res = 0;
        if(s==null || s.length() == 0){
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int left=0, right=0; right < s.length(); right++){
            char rightVal = s.charAt(right);
            if(map.containsKey(rightVal)){
                left = Math.max(left,map.get(rightVal)+1);
            }
            res = Math.max(res, right-left+1);
            map.put(rightVal, right);
        }
        return res;
    }

}
