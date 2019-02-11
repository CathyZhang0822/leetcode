public class brokenCalculator {
    public static void main(String[] args){
        int X = 5;
        int Y = 8;
        System.out.println(broken1(X,Y));
    }


    public static int broken1(int X, int Y){
        int count = 0;
        while(X != Y){
            if(Y % 2 != 0){
                Y ++;
                count ++;
                continue;
            }

            if(X > Y){
                Y ++;
                count ++;
            }else if(2*X <= Y){
                Y = Y/2;
                count ++;
            }else if((2*X-Y+1) > (X - Y/2 + 1)){
                Y = Y/2;
                count ++;
            }else{
                Y ++;
                count ++;
            }
        }
        return count;
    }
}
