public class townJudge {
    public static void main(String[] args){
        // AC了
    }

    public static int findJudge(int N, int[][] trust){
        int[] trustHim = new int[N+1];
        int[] heTrust = new int[N+1];
        for(int[] pair : trust){
            int a = pair[0];
            int b = pair[1];
            heTrust[a] ++;
            trustHim[b] ++;
        }
        int res = -1;
        int count = 0;
        for(int i=1; i <= N; i++){
            if(trustHim[i] == N-1 && heTrust[i] == 0){
                if(count > 0){
                    return -1;
                }
                count ++;
                res = i;
            }
        }
        return res;
    }
}
