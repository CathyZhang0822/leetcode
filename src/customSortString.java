import java.util.*;
public class customSortString {
    public static void main(String[] args){
        String S = "cda";
        String T = "abcd";
        System.out.println(customSortString(S,T));
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        set.addAll(list);


    }
    public static String customSortString(String S, String T) {
        /*
        my idea is 1. first, find all chars in T which appear in S
        2. sort them
        3. put sorted elements into String S
        */
        Set<Character> set = new HashSet<>();
        for(char c : S.toCharArray()){
            set.add(c);
        }
        // use an int array with 26 length to store chars in T
        int[] appearedChars = new int[26];
        char[] tChars = T.toCharArray();
        for(char e : tChars){
            if(set.contains(e)){
                appearedChars[e-'a'] ++;
            }
        }
        System.out.println(Arrays.toString(appearedChars));

        // sort the appeared characters and store them into a stack
        Stack<Character> stack = new Stack<>();
        char[] sChars = S.toCharArray();
        for(int i = sChars.length-1; i >= 0; i--){
            char cur = sChars[i];
            for(int j=0; j<appearedChars[cur-'a']; j ++){
                stack.push(cur);
            }
        }
        System.out.println(stack);
        // put sorted elements into T again
        for(int i=0; i < tChars.length; i ++){
            if(set.contains(tChars[i])){
                tChars[i] = stack.pop();
            }
        }
        return String.valueOf(tChars);
    }
}
