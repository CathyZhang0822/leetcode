import java.util.HashSet;
import java.util.Set;

public class UniquePathIII {
    /** 就是一道很经典的DFS，为啥是hard **/
    public static void main(String[] args){
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        UniquePathIII obj = new UniquePathIII();
        System.out.println(obj.uniquePathsIII(grid));
    }

    int res;
    int numOf0;
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    Set<String> visited;
    public int uniquePathsIII(int[][] grid) {
        res = 0;
        visited = new HashSet<>();
        int x = -1,y = -1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) numOf0++;
                if(grid[i][j] == 1){
                    x = i;
                    y = j;
                }
            }
        }
        dfs(x,y, grid,0);
        return res;
    }

    private void dfs(int x, int y, int[][] grid, int count  ){
        if(grid[x][y] == -1){
            return;
        }
        if(grid[x][y] == 2){
            if(count == numOf0) res ++;
            return;
        }
        if(grid[x][y] == 0){
            count ++;
        }
        visited.add("row" + x + ",col" + y);
        for(int[] direction:directions){
            int i = x + direction[0];
            int j = y + direction[1];
            if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && !visited.contains("row"+i+",col"+j)){
                dfs(i,j,grid,count);
            }
        }
        visited.remove("row" + x + ",col" + y);
    }
}
