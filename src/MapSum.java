import java.util.*;
public class MapSum {
    // need two: trie tree, every node stores all strings which contains current prefix
    // map, to store key and value
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWordEnd;
        Set<String> set = new HashSet<>();
    }
    private TrieNode root;
    private Map<String, Integer> map;
    public MapSum(){
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int value){
        // 1. update key's value in map
        // 2. insert the word into trie tree
        map.put(key,value);

        TrieNode cur = root;
        for(char c : key.toCharArray()){
            TrieNode next = cur.children[c-'a'];
            if(next == null){
                next = new TrieNode();
                cur.children[c-'a'] = next;
            }
            cur = next;
            cur.set.add(key);
        }
        cur.isWordEnd = true;
    }

    public int sum(String prefix){
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            TrieNode next = cur.children[c-'a'];
            if(next == null) return 0;
            cur = next;
        }
        int sum = 0;
        for(String key: cur.set){
            sum += map.get(key);
        }
        return sum;
    }

    public static void main(String[] args){
        MapSum obj = new MapSum();
        obj.insert("apple", 3);
        obj.insert("ap",2);
        System.out.println(obj.sum("app"));
    }
}
