import java.util.*;

public class rotOrange {
    public static void main(String[] args){
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        OrangeRotting(grid);
    }
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int OrangeRotting(int[][] grid){
        int res = -1;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                    visited.add(i+","+j);
                }
            }
        }

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                int[] curPos = queue.remove();
                // 4 directions
                for(int[] dir : directions){
                    int[] neighbor = new int[]{curPos[0] + dir[0], curPos[1] + dir[1]};
                    if(0<= neighbor[0] && neighbor[0] < grid.length && 0 <= neighbor[1] && neighbor[1] < grid[0].length
                            && grid[neighbor[0]][neighbor[1]] == 1 && !visited.contains(neighbor[0]+","+neighbor[1])){
                        queue.add(neighbor);
                        visited.add(neighbor[0]+","+neighbor[1]);
                        grid[neighbor[0]][neighbor[1]] = 2;
                    }
                }

            }
            res ++;
        }
        System.out.println("res : " + res);

        return res;
    }
}
