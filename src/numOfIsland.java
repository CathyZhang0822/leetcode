/** Quick Union, 采取了parent-link的形式 **/
class UnionFind{
    int[] id;
    int count = 0;
    int m, n;

    /** Initialize
     * 最一开始每一个position为一个component
     * **/
    UnionFind(char[][] grid){
        m = grid.length;
        n = grid[0].length;
        id = new int[m*n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int index = i * n + j;
                id[index] = index;
                count ++;
            }
        }
    }

    /** 连接两个component **/
    public void union(int node1, int node2){
        int find1 = find(node1);
        int find2 = find(node2);
        if(find1 != find2){
            id[find2] = find1;
            /** 相当于把两个不同的component连起来了，所以要count -- **/
            count--;
        }
    }

    /**
     * 找到这个component里面最初始的那个根部的点，就是这个component里面所有元素的号
     * **/
    public int find(int node){
        if(id[node] == node){
            return node;
        }
        id[node] = find(id[node]);
        return id[node];
    }
}
public class numOfIsland {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        UnionFind UF = new UnionFind(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    for(int[] d : directions){
                        int x = i + d[0];
                        int y = j + d[1];
                        if(x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1'){
                            int id1 = i * cols + j;
                            int id2 = x * cols + y;
                            UF.union(id1, id2);
                        }
                    }
                }
            }
        }
        return UF.count;
    }
}
