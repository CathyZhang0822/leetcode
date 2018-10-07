import java.util.*;
/*
实现了一个简单版的，相对于normal trienode，加了一个set<string> strings. 表示有多少string的prefix是当前prefix
最关键的一点是：每insert一个word,就在经过的node加上这个word
还有就是全局变量prefix的使用
* */
public class AutocompleteSystem {
    class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWordEnd = true;
        // strings with current prefix
        Set<String> strings = new HashSet<>();
    }
    private TrieNode root;
    public Map<String, Integer> map;
    String prefix;

    public AutocompleteSystem(String[] sentences, int[] times){
        root = new TrieNode();
        map = new HashMap<>();
        prefix = "";
        for(int i = 0; i < sentences.length; i++){
            map.put(sentences[i], times[i]);
            addSentence(sentences[i]);
        }

    }

    public void addSentence(String sentence){
        TrieNode cur = root;
        for(char c : sentence.toCharArray()){
            Map<Character, TrieNode> children = cur.children;
            if(!children.containsKey(c)){
                children.put(c, new TrieNode());
            }
            cur = children.get(c);
            System.out.println("current char:" + c);

            cur.strings.add(sentence);
            System.out.println(cur.strings);
        }
        cur.isWordEnd = true;
    }

    public List<String> input(char c){
        List<String> res = new ArrayList<>();
        if(c == '#'){
            addSentence(prefix);
            prefix = "";
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
            return res;
        }
        prefix += c;
        // search prefix
        TrieNode cur = root;
        for(char cc : prefix.toCharArray()){
            if(!cur.children.containsKey(cc)){
                return new ArrayList<>();
            }
            cur = cur.children.get(cc);
        }
        res.addAll(cur.strings);
        return res;
    }

    public static void main(String[] args){
        String[] sentences = {"i love you","ironman","island"};
        int[] times = {2,4,3};
        AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
        System.out.println(obj.input('i'));
        System.out.println(obj.input(' '));
    }
}
