import java.util.*;
/*
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".

思路：
1. 把input 按照长度 sort一下，这样就按长度排好了。 只需要看之前短的string能不能构成当前string
2. 对当前string进行dfs, 找到一个存在的prefix之后，再对之后的substring进行dfs
* */
public class concatenatedWords {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWordEnd;
    }
    class Trie{
        private TrieNode root;
        public Trie(){
            root = new TrieNode();
            root.isWordEnd = true;
        }

        public void insert(String word){
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                TrieNode next = cur.children[c-'a'];
                if(next == null){
                    next = new TrieNode();
                    cur.children[c-'a'] = next;
                }
                cur = next;
            }
            cur.isWordEnd = true;
        }

        public boolean search(String word){
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                TrieNode next = cur.children[c-'a'];
                if(next == null) return false;
                cur = next;
            }
            return cur.isWordEnd;
        }


    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        List<String> res = new ArrayList<>();
        //Arrays.sort(words);
        Arrays.sort(words, new java.util.Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // TODO: Argument validation (nullity, length)
                return s1.length() - s2.length();// comparision
            }
        });
        for(String word : words){
            // word is concatenated?
            if(dfs(word, trie.root)) res.add(word);
            // insert word into trie tree
            trie.insert(word);
        }
        return res;
    }

    public boolean dfs(String word, TrieNode root){
        if(word.equals("")) return true;
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            TrieNode next = cur.children[c-'a'];
            if(next == null) return false;
            cur = next;
            if(cur.isWordEnd && dfs(word.substring(i+1), root)) return true;
        }
        return false;
    }

    public static void main(String[] args){
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        concatenatedWords obj = new concatenatedWords();
        System.out.println(obj.findAllConcatenatedWordsInADict(words));
    }
}
