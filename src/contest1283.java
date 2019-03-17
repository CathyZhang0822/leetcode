import java.util.Collections;

import java.util.*;
public class contest1283 {
    public static void main(String[] args){
        int[] weights = {147,73,265,305,191,152,192,293,309,292,182,157,381,287,73,162,313,366,346,47};
        int D = 10;
        System.out.println(shipWithinDays(weights, D));
    }

    public static int shipWithinDays(int[] weights, int D) {
        int res = 0;
        int maxWeithg = 0;
        int sum = 0;
        List<Integer> ws = new ArrayList<>();
        for(int w : weights){
            maxWeithg = Math.max(w, maxWeithg);
            sum += w;
            ws.add(w);
        }
        int curSubSum = 0;
        int counts = 0;
        boolean exceed = false;
        Collections.sort(ws);

        for(int i = maxWeithg; i <= sum; i++){
            System.out.println("i: " + i);
            exceed = false;
            counts = 0;
            curSubSum = 0;
            for(int j = 0; j < weights.length; j++){
                int w = weights[j];
                if(curSubSum + w <= i){
                    curSubSum += w;
                }else{

                    curSubSum = w;
                    counts ++;

                }

                if(counts >= D){
                    exceed = true;
                    break;
                }
            }
            System.out.println(exceed);
            if(!exceed){
                return i;
            }
        }
        return res;
    }
}
