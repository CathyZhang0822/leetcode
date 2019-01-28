import java.util.*;

public class TimeMap2 {
    private Map<String,TreeMap<Integer,String>> map;

    /** Initialize your data structure here. */
    public TimeMap2() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key,new TreeMap<>());
        }
        map.get(key).put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer,String> treeMap = map.get(key);
        if(treeMap==null) {
            return "";
        }
        /** 关键是这个method!! treeMap.floorKey()
         * **/
        Integer floor = treeMap.floorKey(timestamp);
        if(floor==null) {
            return "";
        }
        return treeMap.get(floor);
    }
}
