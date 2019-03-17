import java.util.*;

public class contest1282 {
    public static void main(String[] args){
        int[] time = {60,60,60};
        System.out.println(numPairsDivisibleBy60(time));

    }
    public static int numPairsDivisibleBy60(int[] time) {
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.putIfAbsent(60, 0);
        for(int i = 0; i < time.length; i++){
            int curRemain = time[i] % 60;
            map.putIfAbsent(curRemain, 0);
            if(map.containsKey(60- curRemain)){
                res += map.get(60 - curRemain);
            }
            if(curRemain == 0) {
                map.put(60, map.get(60) + 1);
            }else{
                map.put(curRemain, map.get(curRemain) + 1);
            }

        }
        System.out.println("map: " + map);

        return res;
    }
}
