import java.util.*;
/*
一道很直观的关于trie的题目
* */
public class replaceWords {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWordEnd;
    }
    private TrieNode root;
    public String replace(List<String> dict, String sentence){
        root = new TrieNode();
        // build the trie tree
        for(String word : dict){
            insert(word);
        }
        String[] sentences = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(String part : sentences){
            sb.append(find(part));
            sb.append(" ");
        }
        return sb.toString().trim();
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

    public String find(String sentence){
        StringBuilder res = new StringBuilder();
        TrieNode cur = root;
        for(char c : sentence.toCharArray()){
            TrieNode next = cur.children[c-'a'];
            if(next == null) return sentence;
            res.append(c);
            if(next.isWordEnd) {
                return res.toString();
            }
            cur = next;
        }
        return sentence;
    }

    public static void main(String[] args){
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        replaceWords obj = new replaceWords();
        System.out.println(obj.replace(dict, sentence));
    }
}
