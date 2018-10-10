import java.util.*;

public class findRectanangles {
    public static void main(String[] args){
        int[][] matrix1 = {
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}};
        int[][] matrix2 = {
                {1,0,0,0,1},
                {1,0,0,0,1},
                {1,1,1,1,0},
                {1,1,1,1,0},
                {0,0,1,1,0}
        };
        int[][] matrix3 = {
                {1,0,0,0,1},
                {1,1,0,1,1},
                {1,1,1,1,0},
                {1,0,1,1,0},
                {0,0,1,1,0}
        };
        findRectanangles obj = new findRectanangles();
        System.out.println(Arrays.toString(obj.find1(matrix1)));
        System.out.println(obj.find2(matrix2));
        System.out.println(obj.find3(matrix3));
    }

    //第一问，matrix1,里面只有一个由'0'构成的矩形，输出这个矩形的左上角和右下角坐标
    //思路:找到左上角的0，然后找到长和宽
    public int[] find1(int[][] matrix1){
        int m = matrix1.length;
        int n = matrix1[0].length;
        int[] res = new int[4];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix1[i][j] == 0){
                    //find the left top corner
                    res[0] = i;
                    res[1] = j;
                    int length = 0;
                    int height = 0;
                    while(length+j < n && matrix1[i][j+length] == 0){
                        length++;
                    }
                    while(height+i < m && matrix1[i+height][j] == 0){
                        height++;
                    }
                    res[2] = i+height-1;
                    res[3] = j+length-1;
                    return res;
                }
            }
        }
        // no rectanangle
        return res;
    }

    // 第二问：matrix里面有多个矩形，没有联通。输出所有矩形
    public List<List<Integer>> find2(int[][] matrix){
        List<List<Integer>> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i =0; i < m; i++){
            for(int j=0; j<n; j++){
                //if matrix[i][j] is the left top corner of a rect
                if(isLeftTop(i,j,matrix)){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    int length = 0;
                    int height = 0;
                    while(length+j < n && matrix[i][j+length] == 0){
                        length++;
                    }
                    while(height+i < m && matrix[i+height][j] == 0){
                        height++;
                    }
                    list.add(i+height-1);
                    list.add(j+length-1);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private boolean isLeftTop(int i, int j, int[][] matrix){
        if(matrix[i][j] == 0 && (i==0 || matrix[i-1][j] == 1) && (j==0 || matrix[i][j-1]==1)){
            return true;
        }
        return false;
    }

    // 第三问，由0构成的区域不再是矩形，而是可能是任何形状。输出所有由0构成的areas
    // 有点像number of islands
    public List<List<String>> find3(int[][] matrix){
        List<List<String>> res = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0 && !visited[i][j]){
                    List<String> area = new ArrayList<>();
                    dfs(matrix,visited, i,j,area);
                    res.add(area);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int row, int col, List<String> area){
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || visited[row][col] || matrix[row][col] == 1){
            return;
        }
        area.add("(" + row + "," + col + ")");
        visited[row][col] = true;
        dfs(matrix, visited, row+1, col, area);
        dfs(matrix, visited, row-1, col, area);
        dfs(matrix, visited, row, col+1, area);
        dfs(matrix, visited, row, col-1, area);
    }
}
