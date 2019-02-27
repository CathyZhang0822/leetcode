import java.util.*;
/** Weighted Union Find, 相比于num of islands I. 多了一个weighted 步骤，即争取保持树的平衡 **/
class UnionFind2{
    int m,n;
    int count = 0;
    int[] id;
    int[] size;

    public UnionFind2(int row, int col){
        m = row;
        n = col;
        id = new int[m*n];
        Arrays.fill(id, -1);
        size = new int[m*n];
    }

    // 这里就和num of islands I 不同
    public void add(int x, int y){
        int index = x * n + y;
        id[index] = index;
        size[index] = 1;
        count ++;
    }

    public void union(int node1, int node2){
        int find1 = find(node1);
        int find2 = find(node2);
        if(find1 == find2) return;
        count --;
        if(size[find1] > size[find2]){
            id[find2] = find1;
            size[find1] += size[find2];
        }else{
            id[find1] = find2;
            size[find2] += size[find1];
        }
    }

    public int getId(int i, int j){
        if(i >= 0 && i < m && j >= 0 && j < n){
            return id[i*n+j];
        }
        /** 越界或者此处不是'1'的时候返回0 **/
        return -1;
    }

    /** find root **/
    public int find(int node){
        if(id[node] == node){
            return node;
        }
        id[node] = find(id[node]);
        return id[node];
    }
}
public class numOfIslandII {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        UnionFind2 UF2 = new UnionFind2(m,n);
        for(int[] position:positions){
            int x = position[0];
            int y = position[1];
            UF2.add(x,y);
            for(int[] d : directions){
                int i = x + d[0];
                int j = y + d[1];
                if(UF2.getId(i,j) >= 0){
                    int id1 = x * n + y;
                    int id2 = i * n + j;
                    UF2.union(id1, id2);
                }
            }
            res.add(UF2.count);
        }
        return res;
    }

    public static void main(String[] args){
        numOfIslandII obj = new numOfIslandII();
        int[][] positions = {{0,0}, {0,1}, {1,2}, {2,1}};
        System.out.println(obj.numIslands2(3,3, positions));
    }

}
