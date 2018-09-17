import java.util.*;
public class removeKDigits {
    public static void main(String[] args){

    }
    /* The first algorithm is straight-forward.
       Let's think about the simplest case: how to remove 1 digit from the number so that the new number is the smallest possible？
       Well, one can simply scan from left to right, and remove the first "peak" digit;
       the peak digit is larger than its right neighbor. One can repeat this procedure k times,
       The above algorithm is a bit inefficient because it frequently remove a particular element from a string and has complexity O(k*n).
       One can simulate the above procedure by using a stack, and obtain a O(n) algorithm.
       Note, when the result stack (i.e. res) pop a digit, it is equivalent as remove that "peak" digit.
    * */
    public String removeKDigits(String num, int k){
        // corner case: k > num.length
        if(k >= num.length()){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i < num.length()){
            Character cur = num.charAt(i);
            // whenever meet a digit which is less than the previous digit, discard the previous one
            // at current string, the previous one is a "peak"
            while(!stack.isEmpty() && k > 0 && cur > stack.peek()){
                stack.pop();
                k --;
            }
            stack.push(cur);
            i ++;
        }
        // corner case like: 019
        while(k > 0){
            stack.pop();
            k--;
        }
        // construct the string from stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        // remove all leading zeros
        while(sb.length()>1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
