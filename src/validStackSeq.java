import java.util.Stack;

public class validStackSeq {
    public static void main(String[] args){
        int[] pushed = {1,2,3,4,5};
        int[] poped = {4,3,5,1,2};
        System.out.println(valid(pushed, poped));
    }

    public static boolean valid(int[] pushed, int[] poped){
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while(i < pushed.length || j < poped.length){
            if(i< pushed.length && j < pushed.length){
                if(pushed[i] == poped[j]){
                    // 这个好说，就是stack push进去一个再pop出来， i j分别向前面移动
                    stack.push(pushed[i]);
                    stack.pop();
                    i ++;
                    j ++;
                }else{
                    // 只Push
                    if(stack.isEmpty() || stack.peek() != poped[j]){
                        stack.push(pushed[i]);
                        i ++;
                    }else{
                        // 只 pop
                        stack.pop();
                        j ++;
                    }
                }

            }else{
                if(stack.isEmpty() || stack.peek() != poped[j]){
                    return false;
                }else{
                    stack.pop();
                    j ++;
                }
            }
        }
        return true;
    }
}
