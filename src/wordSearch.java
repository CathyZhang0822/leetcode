public class wordSearch {
    public static void main(String[] args){
        char[][] board = {{'A','B','C'},{'A','B','C'},{'F','E','D'}};
        String word = "ABD";
        String word2 = "BCD";
        wordSearch obj = new wordSearch();
        //System.out.println(obj.exist(board, word));
        System.out.println(obj.exist(board, word2));
    }
    boolean[][] visited;
    private boolean exist(char[][] board, String word){
        visited = new boolean[board.length][board[0].length];
        if(board == null || board.length ==0 || board[0].length ==0){
            return false;
        }
        for(int m = 0; m < board.length; m++){
            for(int n=0; n < board[0].length; n++){
                if(dfs(board, word,m,n,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int m, int n, int level){
        if(level == word.length()){
            return true;
        }
        if(m < 0 || m >= board.length || n < 0 || n >= board[0].length || board[m][n] != word.charAt(level)){
            return false;
        }
        visited[m][n] = true;
        boolean cur = dfs(board, word, m+1,n,level+1) || dfs(board, word, m-1,n,level+1) ||
                dfs(board, word, m,n+1,level+1) || dfs(board, word, m,n-1,level+1);
        visited[m][n] = false;
        return cur;

    }
}
