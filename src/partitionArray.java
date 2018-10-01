import java.util.Arrays;

public class partitionArray {
    public static void main(String[] args){
        int[] A = new int[] {1,1,1,0,6,12};
        System.out.println(partition(A));
    }
    public static int partition(int[] A){
        int[] localMax = new int[A.length];
        int[] localMin = new int[A.length];
        int imax= A[0];
        int imin = A[A.length-1];
        for(int i = 0; i < localMax.length; i++){
            if(A[i] > imax){
                imax = A[i];
            }
            localMax[i] = imax;
        }
        System.out.println(Arrays.toString(localMax));
        for(int i = localMin.length-1; i >= 0; i--){
            if(A[i] < imin){
                imin = A[i];
            }
            localMin[i] = imin;
        }
        System.out.println(Arrays.toString(localMin));
        for(int i = 0; i < localMax.length-1; i ++){
            if(localMax[i] <= localMin[i+1]){
                return i+1;
            }
        }
        return 0;

    }
}
