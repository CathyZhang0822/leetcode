public class bagOfTokens {
    public static void main(String[] args){
        int[] tokens = {71, 55, 82};
        int P = 54;
        System.out.println(maxScore(tokens, P));
    }
    static int max;
    public static int maxScore(int[] tokens, int P){
        max = 0;
        dfs(tokens, 0, P, 0);
        return max;
    }

    public static void dfs(int[] tokens, int index, int Power, int points){

        if(index >= tokens.length){
            if(Power >= 0) {
                System.out.println("token: " + tokens[index-1] + ", power: " + Power + ", points: " + points);
                max = Math.max(max, points);
            }

            return;
        }

        int token = tokens[index];

        // first way
            dfs(tokens, index + 1, Power - token, points+1);
        // second way
            dfs(tokens, index + 1, Power + token, points - 1);
        // third way
        dfs(tokens, index+1, Power, points);
    }
}
