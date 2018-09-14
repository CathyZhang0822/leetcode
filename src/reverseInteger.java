import java.util.*;
public class reverseInteger {
    /* Given a 32-bit signed integer, reverse digits of an integer.
      Example:
      Input: -120
      Output: -21
    * */
    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(-1000));
        System.out.println(reverseI(-1010));
    }
    /* Approach 1:
       We can build up the reverse integer one digit at a time.
       While doing so, we can check beforehand whether or not appending another digit would cause overflow.
    * */
    public static int reverseI(int x){
        int res = 0;
        while(x != 0){
            int tail = x % 10;
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE && tail > 7)){
                return 0;
            }
            if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE && tail < -8)){
                return 0;
            }
            /* 不能在这一步时直接跟 MIN/MAX比较，因为已经over flow了
            * */
            res = res * 10 + tail;
            x /= 10;
        }
        return res;
    }
    /* 作弊解法：catch exception
    * */
    public static int reverse(int x){
        int res = 0;
        String orn = String.valueOf(x);
        boolean isnegative = (orn.charAt(0) == '-' ? true : false);
        if(isnegative){
            orn = orn.substring(1);
        }
        String rev = new StringBuilder(orn).reverse().toString();
        if(isnegative){
            rev ="-"+rev;
        }
        try{
            res = Integer.parseInt(rev);
        }catch(NumberFormatException e){
            res = 0;
        }
        return res;
    }
}
