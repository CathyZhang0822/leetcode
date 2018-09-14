import java.util.*;
public class decodeString {
    public static void main(String[] args){
        String s = "3[a2[bc1[d]]]ef";
        //System.out.println(decode1(s));
        System.out.println(decode2(s, new int[] {0}));
    }
    /*
    Approach 1: use stacks
    use String res record current string.
    when meet '[', push res
    when meet ']', pop pre, res = pre + count*res
    * */
    public static String decode1(String s){
        int count = 0;
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int i = 0;
        while(i < s.length()){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                count = count*10+(cur-'0');
            }else if(cur == '['){
                // current count is finalized
                // push 进去的时候 res 和 count 都要归0
                countStack.push(count);
                stringStack.push(res);
                res = "";
                count = 0;
            }else if(cur == ']'){
                String prev = stringStack.pop();
                StringBuilder temp = new StringBuilder(prev);
                int curCount = countStack.pop();
                System.out.println(curCount);
                for(; curCount > 0; curCount--){
                    temp.append(res);
                }
                res = temp.toString();
            }else{
                res += cur;
            }
            i ++;
        }
        return res;
    }

    /* Approach 2: Recursion
    Every time we meet a '[', we treat it as a subproblem so call our recursive function to get the content in that '[' and ']'.
    After that, repeat that content for 'num' times.
    Every time we meet a ']', we know a subproblem finished and just return the 'word' we got in this subproblem.
    Please notice that the 'pos' is passed by reference, use it to record the position of the original string we are looking at.
    Time: O(n) 因为string里的每个元素都只走了一遍
    * */
    public static String decode2(String s, int[] index){
        System.out.println("sub: " + s.substring(index[0]));
        StringBuilder res = new StringBuilder();
        int count = 0;
        /* 注意不能 for(int i = 0; i < index[0]; i++)!
           要直接改变index[0](call by reference)
        * */
        for(; index[0]<s.length(); index[0]++){
            /* 每经历一次for循环便 ++ 一次，但是一次for循环内部index[0]/平时经常设置的i也有可能变化
            * */
            char cur = s.charAt(index[0]);
            if(Character.isDigit(cur)){
                count = count * 10 + (cur-'0');
            }else if(cur == '['){
                index[0] = index[0] + 1;
                String sub = decode2(s, index);
                for(int j = 0;j < count;j ++){
                    res.append(sub);
                }
            }else if(cur == ']'){
                // 注意两个base case：1（we meet a ']', we know a subproblem finished
                return res.toString();
            }else{
                res.append(cur);
            }
        }
        // 第二个base case：字符串走完了
        return res.toString();
    }
}
