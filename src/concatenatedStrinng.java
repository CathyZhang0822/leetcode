import java.util.*;
public class concatenatedStrinng {
    /*给两个字母串 str1 "ababz", str2 "abz".判断str1能否用str2中的字符拼成。
    如果能最少的步数是多少？
    ex: 从str2中取 "A" "B" "A" "B" "Z"一共5步。但如果取"AB" "ABZ"只需要两步
    思路：把B中的所用substring存在一共set里面，BFS traverse A.当前层数是需要的步数。
    queue<List<String>>
    如果当前queue中的list element，除了最后一个string不是B的substring,其余前面的都是，则进入下一层
    取切开最后一个string。
    * */

    // method 1: BFS. 先看能不能一步走出来，再看两步，再看三步。。
    public static int concatenate (String A, String B){
        // put all substrings into set
        Set<String> set = new HashSet<>();
        for(int i = 0; i < B.length(); i++){
            for(int j = i; j < B.length(); j++){
                set.add(B.substring(i, j+1));
            }
        }
        //System.out.println(set); [A, AB, B, BZ, ABZ, Z]
        Queue<List<String>> queue = new LinkedList<>();
        List<String> start = new ArrayList<>();
        start.add(A);
        queue.add(new ArrayList<>(start));
        while(!queue.isEmpty()){
            List<String> cur = queue.remove();
            System.out.println(cur);
            String last = cur.get(cur.size()-1);
            // find a valid combination
            if(set.contains(last)){
                return cur.size();
            }
            if(last.length() == 1) continue;
            cur.remove(cur.size()-1);
            for(int j = 0; j < last.length(); j++){
                List<String> newList = new ArrayList<>(cur);
                if(!set.contains(last.substring(0,j))) continue;
                System.out.println(last.substring(0,j));
                newList.add(last.substring(0,j));
                newList.add(last.substring(j));
                queue.add(newList);
            }
        }
        return -1;
    }

    // method 2: DP
    // 把B的所有substring找出来，然后word break 搞起来。就不写代码了
    // O(m^2 + n^2) m^2用来找所有的substring, n^2用来DP

    public static void main(String[] args){
        String A = "ABABZ";
        String B = "ABBZ";
        System.out.println(concatenate(A,B));
    }
}
