import java.util.*;
public class LFU {
    Map<Integer, Integer> vals;
    Map<Integer, Integer> counts;
    Map<Integer, LinkedHashSet<Integer>> lists;
    int cap;
    int min = -1;
    // 需要思考清楚什么时候Min会变化：
    // min 增加：当当前唯一一个fre是min的key被set了一下之后，min -> min++
    // min 减少：无论怎么set/get min肯定都不会减少的。只有当insert一个新的值时，min -> 1
    public LFU(int capacity){
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }

    public int get(int key){
        if(!vals.containsKey(key)) return -1;
        // node's frequency + 1
        int count = counts.get(key);
        counts.put(key, count+1);

        lists.get(count).remove(key);

        if(count == min && lists.get(count).size() == 0){
            min ++;
        }

        if(!lists.containsKey(count + 1)) lists.put(count + 1, new LinkedHashSet<>());

        lists.get(count+1).add(key);
        return vals.get(key);
    }

    public void set(int key, int val){
        if(vals.containsKey(key)){
            vals.put(key, val);
            get(key); // update frequency
            return;
        }
        // 本身不含有要insert了，这时要注意capacity
        if(vals.size() >= cap){
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
        }
        vals.put(key, val);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }
}
