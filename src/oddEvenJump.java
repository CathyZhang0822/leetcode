import java.util.*;

public class oddEvenJump {
    public static void main(String[] args){
        /** 学会用 treemap.ceilingKey() 和 treemap.floorKey() **/
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(0,0);
        treeMap.put(1,1);
        treeMap.put(2,2);
        treeMap.put(3,3);
        treeMap.put(4, 14);
        System.out.println("The smallest value greater than 5: " + treeMap.ceilingKey(5));
        System.out.println("The greatest value smaller than 5: " + treeMap.floorKey(5));
        int[] A = new int[] {5,1,3,4,2};
        System.out.println(oddEvenJumps(A));
    }

    public static int oddEvenJumps(int[] A){
        int res = 1;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        // OddJumpTo[i] 表示从当前index i做odd jump,能跳到哪个index
        int[] OddJumpTo = new int[A.length];
        // 同理，EvenJumpTo[i] 表示从当前index i做even jump,能跳到哪个index
        int[] EvenJumpTo = new int[A.length];
        OddJumpTo[A.length-1] = A.length-1;
        EvenJumpTo[A.length-1] = A.length-1;
        treeMap.put(A[A.length-1], A.length-1);

        for(int i = A.length - 2; i >= 0; i --){
            System.out.println("i: " + i);
            int odd = treeMap.ceilingKey(A[i]) == null ? -1 : treeMap.get(treeMap.ceilingKey(A[i])) ;
            int even = treeMap.floorKey(A[i]) == null ? -1 : treeMap.get(treeMap.floorKey(A[i]));
            if(odd != -1 && EvenJumpTo[odd] != -1){
                OddJumpTo[i] = odd;
                res ++;
            }else{
                OddJumpTo[i] = -1;
            }
            if(even != -1 && OddJumpTo[even] != -1){
                EvenJumpTo[i] = even;
                // 注意这里不能res++，因为每一个start index都是从odd jump开始的
                //res ++;
            }else{
                EvenJumpTo[i] = -1;
            }
            treeMap.put(A[i],i);
        }
        System.out.println(Arrays.toString(OddJumpTo));
        System.out.println(Arrays.toString(EvenJumpTo));
        return res;
    }
}
