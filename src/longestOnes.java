public class longestOnes {
    public static void main(String[] args){
        int[] A =  {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(LongestOnes(A, 3));
    }

    public static int LongestOnes(int[] A, int k){
        int[] numOf0 = new int[A.length+1];
        int num = 0;
        int longest = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 0){
                num ++;
            }
            numOf0[i+1] = num;
        }
        for(int i = 0; i < numOf0.length; i++){
            for(int j = 0; j < numOf0.length; j++){
                if((numOf0[j] - numOf0[i]) == k){
                    longest = Math.max(longest,j-i);
                }
            }
        }
        return longest;
    }
}
