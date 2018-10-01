public class pathToHome {
    // 上下左右 四个方向
    public static final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    // 一个boolean 二维array来判断有没有走过
    public static boolean[][] visited;
    // 返回的结果变量
    public static int res = 0;
    public static void main(String[] args){
        int[][] board = new int[6][6];
        //自定义的三个坑
        board[1][2] = -1;
        board[3][4] = -1;
        board[5][1] = -1;
        visited = new boolean[board.length][board[0].length];
        paths(0,0,board);
        System.out.println(res);
    }
    // DFS
    public static void paths(int row, int col, int[][] board){
        // base case
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] == -1){
            return;
        }
        // 到家了，RES + 1
        if(row == board.length-1 && col == board[0].length-1){
            res ++;
            return;
        }
        // 四个方向做DFS
        for(int[] direction : directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            visited[row][col]  = true;
            paths(newRow, newCol, board);
            visited[row][col] = false;
        }
    }
}
