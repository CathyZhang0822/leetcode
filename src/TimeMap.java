import java.util.*;
public class TimeMap {
    class Pair{
        int time;
        String value;
        Pair(int time, String value){
            this.time = time;
            this.value = value;
        }
    }
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        List<Pair> treeMap = map.get(key);

        treeMap.add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair> treeMap = map.get(key);

        int res = binarySearch(treeMap, timestamp);
        if(res == -1) return "";
        else{
            return treeMap.get(res).value;
        }
    }

    public int binarySearch(List<Pair> list, int target){
        //System.out.println("list :" + list);
        int left = 0;
        int right = list.size()-1;
        int mid;
        while(left+1 < right){
            mid = left + (right-left)/2;
            if(list.get(mid).time < target){
                left ++;
            }else{
                right --;
            }
        }
        if(list.get(left).time > target) return -1;
        if(list.get(right).time <= target) return right;
        else{
            return left;
        }
    }

    public static void main(String[] args){
        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        System.out.println(timeMap.get("love", 10));
        System.out.println(timeMap.get("love", 15));
        System.out.println(timeMap.get("love", 20));
    }
}
