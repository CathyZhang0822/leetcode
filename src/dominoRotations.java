import java.util.Arrays;

public class dominoRotations {
    public static void main(String[] args){
        int[] A = {3,5,1,2,3};
        int[] B = {3,6,3,3,4};
        System.out.println(minDominoRotations(A,B));
    }

    public static int minDominoRotations(int[] A, int[] B) {
        int[] numOfEmpties = new int[6];
        int[] countA = new int[6];
        int[] countB = new int[6];
        Arrays.fill(numOfEmpties, A.length);
        for(int i = 0; i < A.length; i++){
            int numA = A[i]-1;
            int numB = B[i]-1;
            numOfEmpties[numA] --;
            if(numB != numA){
                numOfEmpties[numB] --;
            }
            countA[numA] ++;
            countB[numB] ++;
        }
        System.out.println(Arrays.toString(countA));
        System.out.println(Arrays.toString(countB));
        int loc1 = -1, loc2 = -1;
        for(int i = 0; i < 6; i++){
            if(numOfEmpties[i] == 0){
                if(loc1 == -1){
                    loc1 = i;
                }else{
                    loc2 = i;
                }
            }
        }
        if(loc1 == -1 && loc2 == -1) return -1;
        if(loc2 == -1) return Math.min(A.length-countA[loc1], B.length-countB[loc1]);
        return Math.min(Math.min(A.length-countA[loc1], B.length-countB[loc1]),Math.min(A.length-countA[loc2], B.length-countB[loc2]));

    }
}
