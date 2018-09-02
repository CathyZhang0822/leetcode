import java.util.*;

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
Example:
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]
* */
public class anagramsInString {
    public static void main(String[] args){
        anagramsInString obj = new anagramsInString();
        String s = "fcbaebabacd";
        String p = "abc";
        System.out.println(obj.findAnagrams(s,p));
        System.out.println(obj.findAnagramsv2(s,p));
    }

    /* Approach1: sliding window: 固定窗口大小，移动窗口的同时比较两个hashmap
       optimize: Because 2 strings only consist of lowercase english letters. So instead of comparing two hashmaps,
       we can compare two 26 sized arrays.  --> Instead of using two arrays, we can use one array only.
       总之就是这么一个心理历程 Time: O(26*n) Space: O(26)
    * */
    private List<Integer> findAnagrams(String s, String p){
        List<Integer> res = new ArrayList<>();
        if(s == null || p == null || s.length() < p.length()){
            return res;
        }
        int[] arr = new int[26];
        for(char elep : p.toCharArray()){
            arr[elep -'a'] ++;
        }
        for(int i=0; i<p.length();i++){
            arr[s.charAt(i)-'a'] --;
        }
        if(allZero(arr)){
            res.add(0);
        }
        for(int i=1; i <= (s.length() - p.length()); i++){
            arr[s.charAt(i-1)-'a'] ++;
            arr[s.charAt(i+p.length()-1)-'a'] --;
            if(allZero(arr)){
                res.add(i);
            }
        }
        return res;
    }

    private boolean allZero(int[] nums){
        for(int num : nums){
            if(num != 0){
                return false;
            }
        }
        return true;
    }

    /* Approach2: sliding window + two pointers, 活动窗口。思路其实没有那么straight forward,我不是很喜欢
    * */
    private List<Integer> findAnagramsv2(String s, String p) {
        //试着自己总结，sliding window algorithm.需要再做一遍。
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c: p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count = map.size();
        int start = 0, end;
        for (end = 0; end < s.length(); end++){
            char e = s.charAt(end);
            if (map.containsKey(e)){
                map.put(e,map.get(e)-1);
                if (map.get(e) == 0)
                    count --;
            }
            while(count == 0){
                char sta = s.charAt(start);
                if (map.containsKey(sta)){
                    if(map.get(sta) == 0)
                        count ++;
                    map.put(sta, map.get(sta)+1);
                }
                if (end - start == p.length()-1)
                    res.add(start);
                start ++;
            }
        }
        return res;
    }
}
