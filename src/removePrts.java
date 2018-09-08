import java.util.*;
public class removePrts {
    public static void main(String[] args){
        String s = "()())()";
        System.out.println(rmv(s));
    }
    private static List<String> rmv(String s){
        List<String> res= new ArrayList<>();
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        boolean found = false;
        while(!queue.isEmpty()){
            System.out.println(queue);
            int size = queue.size();
            if(found){
                break;
            }
            for(int i=0; i < size; i++){
                String cur = queue.remove();
                if(isValid(cur)){
                    res.add(cur);
                    found = true;
                }
                // not valid, put all of its sub statements into queue
                for(int j=0; j < cur.length(); j++){
                    String sub = cur.substring(0,j) + cur.substring(j+1);
                    if(!set.contains(sub)){
                        queue.add(sub);
                        set.add(sub);
                    }
                }
            }
        }
        return res;
    }
    private static boolean isValid(String s){
        int left = 0, right = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                left ++;
            }else{
                if(right >= left){
                    return false;
                }
                right ++;
            }
        }
        return (left == right);
    }
}
