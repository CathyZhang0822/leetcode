import java.util.*;
public class calculatorIII {
    static int index;
    public static void main(String[] args){
        index = 0;
        String s = "2*(5+5*2)/3+(6/2+8)";
        System.out.println(calculate(s));
    }

    private static int calculate(String s){
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        for(; index < s.length(); index++){
            // 直接找出那个数，push进stack里去
            //最关键还是这里! 找一串长的数。
            if(Character.isDigit(s.charAt(index))){
                int sum = 0;
                while(index < s.length() && Character.isDigit(s.charAt(index))){
                    sum = sum * 10 + s.charAt(index)-'0';
                    index ++;
                }
                if(op =='+') stack.push(sum);
                if(op == '-') stack.push(0-sum);
                if(op == '*') stack.push(stack.pop() * sum);
                if(op == '/') stack.push(stack.pop() / sum);
                index --;
            }else if(s.charAt(index) == ' '){
                continue;
            }else if(s.charAt(index) == '+' || s.charAt(index) == '-' ||s.charAt(index) == '*' ||s.charAt(index) == '/'){
                op = s.charAt(index);
            }else if(s.charAt(index) == '('){
                index ++;
                //不能直接Push进去！要看现在的op是什么！
                int num = calculate(s);
                if(op =='+') stack.push(num);
                if(op == '-') stack.push(0-num);
                if(op == '*') stack.push(stack.pop() * num);
                if(op == '/') stack.push(stack.pop() / num);
            }else if(s.charAt(index) == ')'){
                System.out.println(stack);
                while(!stack.isEmpty()){
                    res += stack.pop();
                }
                System.out.println(res);
                return res;
            }
        }
        System.out.println(stack);
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
