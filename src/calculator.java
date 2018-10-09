import java.util.*;
public class calculator {
    public static void main(String[] args){
        String s = "46";
        System.out.println(calculate(s));
    }
    public static int calculate(String s){
        int res=0;
        Stack<Integer> st1 = new Stack<>();
        // don't need a sign stack. keep track of the last sign
        // 注意如果最后一个字符是字母，不要忘了
        char sign = '+';
        int cur = 0;
        for(int i = 0;i < s.length(); i++){
            char c = s.toCharArray()[i];
            if(Character.isDigit(c)){
                System.out.println("cur:" + cur);
                System.out.println("c:" + c);
                cur = cur*10 + Integer.parseInt(c+"");
                System.out.println(cur);
            }
            if((!Character.isDigit(c) && c != ' ') || (i == s.length()-1)){
                // c could be +,-,/,*,' '
                if(sign == '+') st1.push(cur);
                if(sign == '-') st1.push(-cur);
                if(sign == '*') st1.push(st1.pop() * cur);
                if(sign == '/') st1.push(st1.pop() / cur);
                sign = c;
                cur = 0;

            }
            System.out.println(st1);

        }
        while(!st1.isEmpty()){
            int n = st1.pop();
            res += n;
        }
        return res;
    }
}
