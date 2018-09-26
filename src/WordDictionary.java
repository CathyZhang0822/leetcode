/*
class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isWordEnd;
}
* */
// Word Dictionary 就是Trie!
public class WordDictionary {

    public TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            TrieNode next = cur.children[c-'a'];
            if(next == null){
                next = new TrieNode();
                cur.children[c-'a'] = next;
            }
            cur = next;
        }
        // 注意写在FOR循环外面！
        cur.isWordEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return isMatch(root, word, 0);
    }

    public boolean isMatch(TrieNode root, String word, int level){
        if(root == null){
            return false;
        }
        if(level == word.length()){
            return root.isWordEnd;
        }
        char c = word.charAt(level);
        if(c == '?'){
            for(TrieNode child : root.children){
                if(isMatch(child, word, level+1)) return true;
            }
            return false;
        }else{
            return isMatch(root.children[c-'a'], word, level+1);
        }
    }
}
