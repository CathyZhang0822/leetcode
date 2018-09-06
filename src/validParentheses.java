import java.util.*;
public class validParentheses {
    public static void main(String[] args){
        String s = "[]{{}()}";
        System.out.println(isValid(s));
    }
    private static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else{
                if(stack.isEmpty() || c != stack.pop()){
                    return false;
                }
            }
        }
        return (stack.isEmpty());
    }
}
