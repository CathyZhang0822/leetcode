public class calculatorII {
    public static void main(String[] args){
        String s = "1 + 2 - 4 ";
        System.out.println(calculate(s));
        int[] index = {0};
        String s1 = "1 + (2 - 4) ";
        System.out.println(calculateII(s1, index));
    }
/* 只有 +, -, , (, )
   我的思路是，把括号里面的当做sub problem
   对于最基本的subproblem: 只有 +，-，' '
* */
// 这是最基本的那个，不带上括号
    public static int calculate(String s){
        int res = 0;
        int sign = 1;
        int cur = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                cur = cur*10 + c-'0';
            }else if(c == '+'){
                res += sign * cur;
                sign = 1;
                cur = 0;
            }else if(c == '-'){
                res += sign * cur;
                sign = -1;
                cur = 0;
            }
        }
        // 别忘了最后一个数
        res += sign * cur;
        return res;
    }
    // 带上括号，复杂了一点，避免重复遍历，把index设置成一个全局变量
    public static int calculateII(String s, int[] index){
        int res = 0;
        int sign = 1;
        int cur = 0;
        for(; index[0] < s.length(); index[0]++){
            char c = s.charAt(index[0]);
            if(Character.isDigit(c)){
                cur = cur * 10 + (c-'0');
            }else if(c == '+'){
                res += sign * cur;
                sign = 1;
                cur = 0;
            }else if(c == '-'){
                res += sign * cur;
                sign = -1;
                cur = 0;
            }else if(c == '('){
                index[0] ++;
                int sub = calculateII(s, index);
                System.out.println(sub);
                res += sign * sub;
            }else if(c == ')'){
                // 注意最后一步
                res += sign * cur;
                return res;
            }
        }
        // 注意最后一步
        res += sign * cur;
        return res;
    }
}
