import java.util.HashSet;
import java.util.*;

public class GridIllumination {
    public static void main(String[] args){
        int N = 5;
        int[][] lamps = {{0,0},{4,4}};
        int[][] queries = {{1,1},{1,0}};
        System.out.println(Arrays.toString(gridIllumination2(N,lamps,queries)));
    }
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,-1},{-1,1}};
    static int[][] grid;
    static Set<String> set;


    public static void turnOn2(long row, long col, long len){
        set.add("row:" + row);
        set.add("col:" + col);
        long leftUpRow = row - col >= 0 ? (row - col) : 0;
        long leftUpCol = col - row >= 0 ? (col - row) : 0;
        set.add("dialleft:" + leftUpRow+","+leftUpCol);
        long rightUpRow = (row + col) <= (len-1) ? 0 : (row+col-len+1);
        long rightUpCol = (row + col - rightUpRow);
        set.add("dialright:" + rightUpRow+","+rightUpCol);
    }
    public static int[] gridIllumination2(int N, int[][] lamps, int[][] queries) {
        Set<String> lampsPosition = new HashSet<>();
        set = new HashSet<>();
        for(int[] lamp : lamps){
            lampsPosition.add(lamp[0] + "," + lamp[1]);
        }

        int qlen = queries.length;
        int[] res = new int[qlen];
        Set<String> visitedLamps = new HashSet<>();
        Map<Integer, List<String>> qwithLamp = new HashMap<>();
        //System.out.println("initial map: " + qwithLamp);
        int qindex = 0;
        for(int[] query:queries){
            int row = query[0];
            int col = query[1];
            qwithLamp.putIfAbsent(qindex, new ArrayList<>());
            for(int[]direction : directions){
                if(row + direction[0] >= 0 && row + direction[0] < N && col + direction[1] >= 0 && col + direction[1] < N
                        && lampsPosition.contains((row+direction[0])+","+(col+direction[1]))  && !visitedLamps.contains((row+direction[0])+","+(col+direction[1]))){
                    String lamp = (row+direction[0])+","+(col+direction[1]);
                    qwithLamp.get(qindex).add(lamp);
                    visitedLamps.add(lamp);
                }
            }
            qindex ++;
        }
        //System.out.println("map: " + qwithLamp);
        //先打开没有occupy的灯
        for(int[] lamp : lamps){
            if(!visitedLamps.contains(lamp[0] + "," + lamp[1])){
                // turn on lamp
                turnOn2(lamp[0],lamp[1],N);
            }
        }
        System.out.println("set: " + set);
        for(int i = queries.length-1; i >= 0; i --){
            for(int j = 0; j < qwithLamp.get(i).size(); j++){
                String lamp = qwithLamp.get(i).get(j);
                String[] splitRes = lamp.split(",");
                int curRow = Integer.parseInt(splitRes[0]);
                int curCol = Integer.parseInt(splitRes[1]);
                turnOn2(curRow,curCol,N);
            }
            long row = queries[i][0];
            long col = queries[i][1];
            long leftUpRow = row - col >= 0 ? (row - col) : 0;
            long leftUpCol = col - row >= 0 ? (col - row) : 0;
            long rightUpRow = (row + col) <= (N-1) ? 0 : (row+col-N+1);
            long rightUpCol = (row + col - rightUpRow);
            if(set.contains("row:" + row) ||
                    set.contains("col:" + col) ||
                    set.contains("dialleft:" + leftUpRow+","+leftUpCol) ||
                    set.contains("dialright:" + rightUpRow+","+rightUpCol)){
                res[i] = 1;
            }
            //System.out.println("res: " + Arrays.toString(res));

        }
        return res;
    }
}
