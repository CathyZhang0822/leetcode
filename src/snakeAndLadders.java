import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class snakeAndLadders {
    static boolean[][] visited;
    public static void main(String[] args){

        //int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1}, {-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        int[][] board = {{1,1,-1},{1,1,1},{-1,1,1}};
        int n = board.length;
        visited = new boolean[n][n];
        System.out.println(bfs(board,n));
        //System.out.println();
    }
    // 1 -> 36
    public static int bfs(int[][] board, int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[index(1,n)[0]][index(1,n)[1]] = true;
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                int curIndex = queue.remove();
                if(curIndex == n*n){
                    return level;
                }
                // add 6 branches into it
                for(int j = 1; j <= 6; j ++){
                    if(curIndex+j<= n*n && !visited[index(curIndex+j,n)[0]][index(curIndex+j,n)[1]]){
                        visited[index(curIndex+j,n)[0]][index(curIndex+j,n)[1]] = true;
                        if(board[index(curIndex+j,n)[0]][index(curIndex+j,n)[1]] != -1){
                            queue.add(board[index(curIndex+j,n)[0]][index(curIndex+j,n)[1]]);
                        }else{
                            queue.add(curIndex+j);
                        }
                    }
                }
            }
            level ++;
        }
        return -1;
    }
    public static int[] index(int x, int n){
        int[] res = new int[2];
        int row = n - 1 - ((x-1)/(2*n)*2 + (x-1)%(2*n)/n);
        res[0] = row;
        int col;
        if((x-1)%(2*n)/n == 1){
            col = n-1-(x-1)%n;
        }else{
            col = (x-1)%n;
        }
        res[1] = col;
        return res;
    }
}
