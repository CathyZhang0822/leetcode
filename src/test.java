import java.util.*;

public class test {
    public static void main(String[] args){
        String s = "sports.yahoo.com";
        String[] as = s.split("\\.");
        System.out.println(as[1].length());
        String s2 = "a        b   c d";
        System.out.println(Arrays.toString(s2.split("\\s+")));

        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        };
        int[][] meetings = {{1, 5},{2,3}, {3,4}};
        Arrays.sort(meetings, comp);
        System.out.println(Arrays.deepToString(meetings));
    }

}
