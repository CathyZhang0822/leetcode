import java.util.*;
public class nQueens {
    /*
     don't need to actually place the queen,
     instead, for each row, try to place without violation on
     col/ diagonal1/ diagnol2.
     trick: to detect whether 2 positions sit on the same diagnol:
     if delta(col, row) equals, same diagnol1;
     if sum(col, row) equals, same diagnal2.
     */
    public static void main(String[] args){
        nQueens obj = new nQueens();
        System.out.println(obj.totalNQueens(4));
        System.out.println(obj.pathNQueens(4));
    }
    int count;
    public int totalNQueens(int n){
        count =0;
        Set<Integer> cols = new HashSet<>();
        Set<Integer> dia1s = new HashSet<>();
        Set<Integer> dia2s = new HashSet<>();
        countHelper(0, n, cols, dia1s, dia2s);
        return count;
    }
    private void countHelper(int row, int n, Set<Integer> cols, Set<Integer> dia1s, Set<Integer>dia2s){

        if(row == n){
            count ++;
            return;
        }
        for(int col=0; col < n; col++){
            if(cols.contains(col) || dia1s.contains(col-row) || dia2s.contains(col+row)){
                continue;
            }
            System.out.println(Arrays.toString(new int[] {row,col}));
            cols.add(col);
            dia1s.add(col-row);
            dia2s.add(col+row);
            countHelper(row+1,n,cols,dia1s,dia2s);
            cols.remove(col);
            dia1s.remove(col-row);
            dia2s.remove(col+row);
        }
    }
    public List<List<Integer>> pathNQueens(int n){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> dia1s = new HashSet<>();
        Set<Integer> dia2s = new HashSet<>();
        pathHelper(0,n,path, res, cols, dia1s, dia2s);
        return res;
    }

    private void pathHelper(int row, int n, List<Integer> path, List<List<Integer>> res, Set<Integer> cols, Set<Integer> dia1s, Set<Integer>dia2s){
        if(row == n){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int col=0; col < n; col++){
            if(cols.contains(col) || dia1s.contains(col-row) || dia2s.contains(col+row)){
                continue;
            }
            cols.add(col);
            dia1s.add(col-row);
            dia2s.add(col+row);
            path.add(col);
            pathHelper(row+1, n, path, res, cols, dia1s, dia2s);
            cols.remove(col);
            dia1s.remove(col-row);
            dia2s.remove(col+row);
            path.remove(path.size()-1);
        }
    }
}
