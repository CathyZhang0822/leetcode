//class TrieNode{
//
//}
/*
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
For the method search, you'll be given a word,
and judge whether if you modify exactly one character into another character in this word,
the modified word is in the dictionary you just built.

自己写的trie的方法明明在ide里面跑出来是对的。。放到lc里面就不对了。。
* */
public class magicDictionary {
    private TrieNode root;
    public magicDictionary(){
        root = new TrieNode();
        root.isWordEnd = true;
    }

    public void buildDictionary(String[] dict){
        for(String word : dict){
            addWord(word);
        }
    }

    private void addWord(String word){
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
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            TrieNode next = cur.children[c-'a'];
             if(next == null){
                 // find an char which is different
                 for(TrieNode child : cur.children){
                     // helper function
                     if(child != null && helper(child, word.substring(i+1))) return true;
                 }
             }else{
                 cur = next;
             }
        }
        return false;
    }

    private boolean helper(TrieNode node, String word){
        TrieNode cur = node;
        for(char c : word.toCharArray()){
            TrieNode next = cur.children[c-'a'];
            if(next == null) return false;
            cur = next;
        }
        return cur.isWordEnd;
    }

    public static void main(String[] args){
        magicDictionary obj = new magicDictionary();
        String[] dict = {"hello", "hallo", "leetcode"};
        obj.buildDictionary(dict);
        System.out.println(obj.search("hpllo"));
    }
}
