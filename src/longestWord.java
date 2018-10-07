public class longestWord {
    //Build a trie in the normal way, then do a dfs to find the longest continuous downward path from the root.
    int maxLen;
    String maxWord;
    public String longest(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            insert(word, root);
        }
        maxLen = 0;
        maxWord = "";
        dfs(root, 0, "");
        return maxWord;
    }

    public void insert(String word, TrieNode root){
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

    public void dfs(TrieNode root, int level, String path){
        if(level > maxLen){
            maxLen = Math.max(maxLen, level);
            maxWord = path;
        }
        for(int i = 0; i < 26; i++){
            // 每层26个分支，valid branch是
            TrieNode child = root.children[i];
            if(child != null && child.isWordEnd){
                dfs(child, level+1, path+(char)('a'+i));
            }
        }
    }

    public static void main(String[] args){
        longestWord obj = new longestWord();
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(obj.longest(words));
    }
}
