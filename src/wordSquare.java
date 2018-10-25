import java.util.*;
public class wordSquare {
    class TrieNode{
        TrieNode[] children;
        List<String> startWith;

        TrieNode(){
            children = new TrieNode[26];
            startWith = new ArrayList<>();
        }
    }

    class Trie{
        TrieNode root;

        Trie(){
            root = new TrieNode();
        }

        void add (String word){
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                TrieNode next = cur.children[c-'a'];
                if(next == null){
                    next = new TrieNode();
                    cur.children[c-'a'] = next;
                }
                next.startWith.add(word);
                cur = next;
            }
        }

        List<String> findByPrefix(String prefix){
            List<String> res = new ArrayList<>();
            TrieNode cur = root;
            for(char c : prefix.toCharArray()){
                TrieNode next = cur.children[c-'a'];
                if(next == null) return res;
                cur = next;
            }
            // add all. 别直接return了 node.startwith
            res.addAll(cur.startWith);
            return res;
        }
    }

    public List<List<String>> wordSquares(String[] words){
        List<List<String>> res = new ArrayList<>();
        Trie trie = new Trie();
        for(String word : words){
            trie.add(word);
        }
        // dfs
        int len = words[0].length();
        for(String word : words){
            List<String> path = new ArrayList<>();
            path.add(word);
            dfs(trie, len, path, res);
        }
        return res;
    }

    private void dfs(Trie trie, int len, List<String> path, List<List<String>> res ){
        if(path.size() == len){
            res.add(new ArrayList<>(path));
            return;
        }
        StringBuilder prefix = new StringBuilder();
        int size = path.size();
        for(String word : path){
            prefix.append(word.charAt(size));
        }
        List<String> words = trie.findByPrefix(prefix.toString());

        // branches
        for(String word : words){
            path.add(word);
            dfs(trie, len, path, res);
            path.remove(path.size()-1);
        }
    }
}
