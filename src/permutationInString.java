import java.util.*;
/* Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
   In other words, one of the first string's permutations is the substring of the second string.
   The input strings only contain lower case letters.

   Example:
   Input:s1 = "ab" s2 = "eidbaooo"
   Output:True
   Explanation: s2 contains one permutation of s1 ("ba").
* */
public class permutationInString {
    public static void main(String[] args){
        permutationInString obj = new permutationInString();
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(obj.check(s1, s2));
    }

    private boolean check(String s1, String s2){
        if(s1 == null || s2 == null || s1.length() > s2.length()){
            return false;
        }
        int[] arr = new int[26];
        for(int i=0; i<s1.length(); i++){
            arr[s1.charAt(i)-'a'] ++;
            arr[s2.charAt(i)-'a'] --;
        }
        System.out.println(Arrays.toString(arr));
        if(allZero(arr)){
            return true;
        }
        for(int i=1; i <= (s2.length() - s1.length()); i++){
            arr[s2.charAt(i-1)-'a'] ++;
            arr[s2.charAt(i+s1.length()-1)-'a'] --;
            System.out.println(Arrays.toString(arr));
            if(allZero(arr)){
                return true;
            }
        }
        return false;
    }

    private boolean allZero(int[] nums){
        for(int num:nums){
            if(num!=0){
                return false;
            }
        }
        return true;
    }
}
