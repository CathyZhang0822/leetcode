import java.util.*;
public class alienDictionary {
    /*
    Input:
    [
      "wrt",
      "wrf",
      "er",
      "ett",
      "rftt"
    ]

    Output: "wertf"
    * */
    /*  同一个单词中的字母先后顺序没有任何意义；
        相邻单词之间，按照lexicographical order排列的意义是，双方字符串中第一个不match的
        字符代表这一条directed edge, 即字符的先后顺序；
        如果所有字符一致，但是其中一个单词长一些，也无法学习到edge, 但是多出来的那个字符要记
        得加入字典，暂时作为一个独立的node；
        如果发现字典graph中有环，返回空字符串；
        如果发现字典中只有一个单词，返回此单词的任意顺序皆可；
        加入edge的时候，记得判重，不要加入重复child节点。
    * */
    public static void main(String[] args){
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(alienOrder(words));
    }

    public static String alienOrder(String[] words) {
        // step 1: build directed graph. 思考是 parent : set of children 还是 child : set of parents
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for(String word : words){
           for(char c : word.toCharArray()){
               graph.put(c, new HashSet<>());
               indegree.put(c, 0);
           }
        }

        for(int i = 0; i < words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int len = Math.min(word1.length(), word2.length());
            for(int j=0; j < len; j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1 != c2){
                    // find a parent - child pair
                    Set<Character> children = graph.get(c1);
                    if(!children.contains(c2)){
                        children.add(c2);
                        indegree.put(c2, indegree.get(c2)+1);
                    }
                    // must break, 这对pair之后的字符没有意义
                    break;
                }
            }
        }
        System.out.println("graph" + graph);
        System.out.println("indegree" + indegree);
        // step 2: use BFS to do topological sort. If there is a loop in it. return ""
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry : indegree.entrySet()){
            if(entry.getValue() == 0) queue.add(entry.getKey());
        }
        System.out.println(queue);
        int counts = 0; // 用来判断有没有环
        while(!queue.isEmpty()){
            char cur = queue.poll();
            counts ++;
            sb.append(cur);

            for(char child : graph.get(cur)){
                int ind = indegree.get(child);
                ind --;
                indegree.put(child, ind);
                if(ind == 0){
                    queue.add(child);
                }
            }
        }

        // 有环的情况
        System.out.println(counts);
        if(counts != graph.keySet().size()) return "";
        return sb.toString();
    }
}
