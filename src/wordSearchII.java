import java.util.*;
public class wordSearchII {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWordEnd;
    }

    class Trie{
        private TrieNode root;
        Trie(){
            root = new TrieNode();
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
                if(next == null){
                    return false;
                }
                cur = next;
            }
            return cur.isWordEnd;
        }

        public boolean hasPrefix(String prefix){
            TrieNode cur = root;
            for(char c : prefix.toCharArray()){
                TrieNode next = cur.children[c-'a'];
                if(next == null) return false;
                cur = next;
            }
            return true;
        }
    }
    static final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    Set<String> res = new HashSet<>();
    boolean[][] visited;
    Trie trie;
    public List<String> findWords(char[][] board, String[] words) {
        trie = new Trie();
        for(String word : words) trie.insert(word);
        System.out.println(trie.hasPrefix("a"));
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, "", i, j);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(char[][] board, String word, int row, int col){
        System.out.println("row: " + row + "col: " + col);
        System.out.println(word);
        //注意顺序！！这两个base case要放在前面！
        if(!trie.hasPrefix(word)) return;
        if(trie.search(word)){
            System.out.println("find!!");
            res.add(word);
            // 写了一遍才发现为什么会有这么多duplicates。。
            // 因为往回走的过程，有个很巧妙的地方就是找到一个word之后把word的isWordEnd变成false
            // 估计我要用个set了
        }

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]){
            return;
        }

        visited[row][col] = true;
        for(int[] dir : dirs){
            dfs(board, word+board[row][col], row+dir[0], col + dir[1]);
        }
        visited[row][col] = false;
    }

    public static void main(String[] args){
        //char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        //String[] words = {"oath","pea","eat","rain"};
        char[][] board = {{'a'}};
        String[] words = {"a"};
        wordSearchII obj = new wordSearchII();
        System.out.println(obj.findWords(board, words));
    }

}
