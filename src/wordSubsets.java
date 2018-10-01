import java.util.*;
public class wordSubsets {
    public static void main(String[] args){
        String[] A = {"amazon","apple","facebook","google","leetcode"};
        String[] B = {"lo","eo"};
        System.out.println(wordS(A,B));
    }
    public static List<String> wordS(String[] A, String[] B){
        List<String> res = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> bset = new HashSet<>();
        for(String b:B) bset.add(b);
        for(String a : A){
            Set<String > set = new HashSet<>();
            dfs(0,a.toCharArray(),"",set);
            map.put(a, set);
            System.out.println(set.size());
            boolean found = false;
            for(String b:bset){
                int[] count = new int[26];
                for(char c : b.toCharArray()){
                    count[c-'a'] ++;
                }
                if(!map.get(a).contains(Arrays.toString(count))){
                    found = true;
                    break;
                }
                bset.add(b);
            }
            if(!found) res.add(a);
        }
        return res;
    }

    private static void dfs(int level, char[] nums, String path, Set<String> set){
        if(level == nums.length){
            int[] count = new int[26];
            for(char c : path.toCharArray()){
                count[c-'a'] ++;
            }
            set.add(Arrays.toString(count.clone()));
            return;
        }
        dfs(level+1, nums, path+nums[level], set);
        dfs(level+1, nums, path, set);

    }
}
