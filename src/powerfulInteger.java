import java.util.*;

public class powerfulInteger {
    public static void main(String[] args){
        System.out.println(power(0,1,100));
    }
    public static List<Integer> power(int x, int y, int bound){

        List<Integer> res = new ArrayList<>();
        if(y == 1) {
            int temp = x;
            x = y;
            y = temp;
        }
        double i = 0, j = 0;
        TreeSet<Integer> treeset = new TreeSet<>();
        for(; Math.pow(x,i) + Math.pow(y,j) <= (double) bound; i++){

            for(; Math.pow(x,i) + Math.pow(y,j) <= (double) bound; j++){
                //System.out.println("i: " + i + ", j: " + j);
                treeset.add((int) (Math.pow(x,i) + Math.pow(y,j)));
                if(y ==0 || y == 1) break;
            }
            if(x == 0 || x == 1) break;
            j = 0;
        }
        for(int ele : treeset){
            res.add(ele);
        }
        return res;
    }
}
