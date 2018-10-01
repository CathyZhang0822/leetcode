import java.util.*;
public class xCards {
    public static void main(String[] args){
        int[] deck = {1,1,1,1,2,2,2,2,2,2};
        System.out.println(hasGroupSizeX(deck));
    }
    public static boolean hasGroupSizeX(int[] deck){
        List<Integer>[] bucket = new List[deck.length+1];

        // int : freq
        Map<Integer, Integer> map = new HashMap<>();
        for(int card : deck){
            map.putIfAbsent(card, 0);
            map.put(card,map.get(card)+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(bucket[entry.getValue()] == null){
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        int minF = 0;
        for(; minF < bucket.length; minF++){
            if(bucket[minF] != null) break;
        }
        if(minF < 2) return false;
        for(int x = 2; x <= minF; x++){
            boolean ans = true;
            for(int i = 2; i < bucket.length; i++){
                if(i % x != 0 && bucket[i]!=null){
                    ans = false;
                    break;
                }
            }
            if(ans) return true;
        }
        return false;
    }
}
