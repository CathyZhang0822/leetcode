import java.util.Stack;

public class clumsyFactorial {
    public static void main(String[] args){
        int N = 4;
        System.out.println(clumsy(N));
    }

    public static int clumsy(int N){
        char[] operators = {'-','*','/','+'};
        StringBuilder sb = new StringBuilder();
        sb.append(N);
        for(int i = 1; i <= N-1; i ++){
            sb.append(operators[i%4]);
            sb.append((N-i));
        }
        System.out.println(sb.toString());
        return calculate(sb.toString());
    }

    private static int calculate(String str){
        char oprt = '+';
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == ' '){
                continue;
            }
            if(Character.isDigit(c)){
                StringBuilder sb = new StringBuilder();
                while(i < str.length() && Character.isDigit(str.charAt(i))){
                    sb.append(str.charAt(i));
                    i ++;
                }
                i --;
                int cur = Integer.parseInt(sb.toString());
                if(oprt == '*'){
                    int prev = stack.pop();
                    stack.push(prev * cur);
                }else if(oprt == '/'){
                    int prev = stack.pop();
                    stack.push(prev/cur);
                }else if(oprt == '-'){
                    stack.push(0-cur);
                }else{
                    stack.push(cur);
                }
            }else{
                oprt = c;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
