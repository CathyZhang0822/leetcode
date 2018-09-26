class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isWordEnd;
}
public class Trie {

    public TrieNode root;
    public Trie(){
        root = new TrieNode();
        //这里还是要注意一下
        root.isWordEnd = true;
    }

    // search word
    public boolean search(String word){
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            TrieNode next = cur.children[c-'a'];
            if(next == null) return false;
            cur = next;
        }
        // 注意不要直接返回true
        return cur.isWordEnd;
    }

    // insert a word
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
        // 别忘了把isWordEnd变成true
        cur.isWordEnd = true;
    }

    // search prefix
    public boolean startsWith(String prefix){
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            TrieNode next = cur.children[c-'a'];
            if(next == null){
                return false;
            }
            cur = next;
        }
        return true;
    }

}
