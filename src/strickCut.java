import java.util.*;
public class strickCut {
    public static void main(String[] args){
        int[] sticks = new int[] {1,3,4,1,2};
        System.out.println(cut(sticks));

    }
    private static List<Integer> cut(int[] sticks){
        List<Integer> res = new ArrayList<>();
        int count = sticks.length;
        TreeMap<Integer, List<Integer>> tmap = new TreeMap<>();
        for(int i = 0; i < sticks.length; i++){
            if(!tmap.containsKey(sticks[i])){
                tmap.put(sticks[i], new ArrayList<>());
            }
            List<Integer> cur = tmap.get(sticks[i]);
            cur.add(i);
            tmap.put(sticks[i], cur);
        }
        System.out.println(tmap);

        while(count > 0){
            int curShortest = tmap.firstKey();
            // cut
            count = count - tmap.get(curShortest).size();
            res.add(count);
            tmap.remove(curShortest);
        }
        return res;
    }
}
