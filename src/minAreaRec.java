import java.util.*;
public class minAreaRec {
    public static void main(String[] args){
        int[][] points = {{1,1},{1,3},{3,1},{3,3},{2,2}};
        System.out.println(minAreaRect(points));
    }
    /*
    不要用hashset来存int[]!!! (call by reference)
    要用hashmap
    * */
    public static int minAreaRect(int[][] points) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        int minArea = Integer.MAX_VALUE;
        for(int[] point : points){
            map.putIfAbsent(point[0], new HashSet<>());
            map.get(point[0]).add(point[1]);
        }
        System.out.println(map);
        for(int i = 0; i < points.length; i++){
            for(int j = i+1; j < points.length; j++){
                int[] p1 = points[i];
                int[] p2 = points[j];
                int temArea = area(p1,p2,map);
                if(temArea > 0) minArea = Math.min(temArea, minArea);
            }
        }
        if(minArea == Integer.MAX_VALUE) return 0;
        return minArea;
    }
    //对角线构成矩形
    public static int area(int[] p1, int[] p2, Map<Integer, Set<Integer>> map){
        int r1 = p1[0], c1 = p1[1], r2 = p2[0], c2 = p2[1];
        if(map.get(r1).contains(c2) && map.get(r2).contains(c1)){
            return Math.abs(r2-r1)*Math.abs(c2-c1);
        }
        return 0;
    }
}
