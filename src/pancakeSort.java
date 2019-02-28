import java.util.*;
public class pancakeSort {
    public static void main(String[] args){
        int[] A ={3,2,4,1};
        System.out.println(pancake(A));
    }

    static int[] position;
    static int[] numbers;
    public static List<Integer> pancake(int[] A){
        List<Integer> res = new ArrayList<>();
        position = new int[A.length+1];
        numbers = new int[A.length+1];
        for(int i = 0; i < A.length; i++){
            position[A[i]] = i+1;
            numbers[i+1] = A[i];
        }
        System.out.println("positon: " + Arrays.toString(position));
        for(int i = A.length; i > 0; i--){
            if(position[i] == i) continue;
            if(position[i] != 1) {
                res.add(position[i]);
                reverse(position[i]);

                System.out.println("positon: " + Arrays.toString(position));
            }
            res.add(i);
            reverse(i);

            System.out.println("positon: " + Arrays.toString(position));
        }
        return res;
    }

    private static void reverse(int k){
        System.out.println("k: " + k);
        for(int i = 1; i <= ((k+1)/2) ; i++){
            int temp = numbers[k-i+1];
            numbers[k-i+1] = numbers[i];
            position[numbers[k-i+1]] = k - i + 1;
            numbers[i] = temp;
            position[numbers[i]] = i;
        }
        System.out.println("positon private: " + Arrays.toString(position));
    }
}
