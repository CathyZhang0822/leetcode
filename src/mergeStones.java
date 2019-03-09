import java.util.*;

public class mergeStones {
    public static void main(String[] args){
        int[] stones = {69,39,79,78,16,6,36,97,79,27,14,31,4};
        int K = 2;
        System.out.println(merge(stones, K));
    }
    public static int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if((K>1) && (n-K)%(K-1) != 0) return -1;
        if(n == 1) return 0;
        List<Integer> list = new ArrayList<>();
        int min = 0;
        int index = -1;

        for(int stone:stones){
            list.add(stone);
            min += stone;
        }
        int res = min;
        int all = min;
        //System.out.println("res: " + res);
        while(list.size() > K){
            min = all;
            int size = list.size();
            for(int i = 0; i < size - K +1; i++){
                int cur = mergeK(list, i, K);
                if(cur < min){
                    min = cur;
                    index = i;
                }
            }
            System.out.println("min: " + min);
            res += min;
            for(int j = 0; j < K; j++){
                list.remove(index);
            }
            list.add(index, min);
            //System.out.println("res: " + res);
            //System.out.println(list);
        }
        return res;
    }

    private static int mergeK(List<Integer>list, int index, int K){
        int res = 0;
        for(int i = 0; i < K; i++){
            res += list.get(index + i);
        }
        return res;
    }

    static int min;
    public static int merge(int[] stones, int K){
        int n = stones.length;
        if((K>1) && (n-K)%(K-1) != 0) return -1;
        if(n == 1) return 0;
        List<Integer> list = new ArrayList<>();
        int all = 0;
        for(int stone:stones){
            list.add(stone);
            all += stone;
        }
        min = Integer.MAX_VALUE;
        dfs(list, K, 0, all);
        return min;
    }

    public static void dfs(List<Integer> list, int K, int cur, int all){
        if(list.size() == K) {
            cur += all;
            min = Math.min(min, cur);
            System.out.println("cur: " + cur);
            return;
        }
        int size = list.size();
        int[] temp = new int[K];
        for(int i = 0; i < size-K+1; i ++){
            int sub = mergeK(list, i, K);
            list.add(i, sub);
            for(int j = 0; j < K; j++){
                temp[j] = list.get(i+1);
                list.remove(i+1);

            }
            dfs(list, K, cur+sub, all);
            list.remove(i);
            for(int j = 0; j < K; j++){
                list.add(i,temp[K-1-j]);
            }
        }
    }
}
