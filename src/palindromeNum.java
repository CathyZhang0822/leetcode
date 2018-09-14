public class palindromeNum {
    public static void main(String[] args){
        int x = 123321;
        System.out.println(isPalindrom(x));
        System.out.println(isPalindrome2(x));
    }
    /* Determine whether an integer is a palindrome.
       An integer is a palindrome when it reads the same backward as forward.
    * */

    /* Approach 1: 不用转换成string的方法
    思路有点像reverse integer, 但是只用reverse一半就好了
    * */
    public static boolean isPalindrom(int x){
        if(x < 0){
            return false;
        }
        int revTail = 0;
        while(x > revTail){
            revTail = revTail * 10 + revTail % 10;
            x /= 10;
        }
        return (x == revTail || x/10 == revTail);
    }
    /* Approach 2: convert it to string, then use two pointers.
    * */
    public static boolean isPalindrome2(int x) {
        String s = String.valueOf(x);
        int left = 0, right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
