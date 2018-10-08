import java.util.*;

public class test {
    public static void main(String[] args){
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
        Arrays.sort(words, new java.util.Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // TODO: Argument validation (nullity, length)
                return s1.length() - s2.length();// comparision
            }
        });
        System.out.println(Arrays.toString(words));
    }

}
