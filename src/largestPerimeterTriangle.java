import java.util.Arrays;

public class largestPerimeterTriangle {
    public static void main(String[] args){

    }

    public static int largestPerimeter(int[] A){
        Arrays.sort(A);
        if(A.length < 3) return 0;
        int i = A.length - 3;
        while(i >= 0 && (A[i] + A[i+1])<=A[i+2]){
            i --;
        }
        if(i < 0) return 0;
        else return A[i] + A[i+1] + A[i+2];
    }
}
