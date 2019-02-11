import java.util.LinkedList;
import java.util.*;

public class equalityEquations {
    public static void main(String[] args){
        String[] e = {"f==a","a==b","f!=e","a==c","b==e","c==f"};
        System.out.println(equationsPossible(e));
    }

    public static boolean equationsPossible(String[] equations){
        int[][] graph = new int[26][26];
        for(String part:equations){
            int comp1 = part.charAt(0)-'a';
            int comp2 = part.charAt(3)-'a';

            if(part.charAt(1) == '='){
                //graph[comp1][comp2] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(comp2);
                if(graph[comp1][comp2] == 2 || graph[comp2][comp1] == 2){
                    return false;
                }
                graph[comp1][comp2] = 1;
                graph[comp2][comp1] = 1;
                Set<Integer> visited = new HashSet<>();
                visited.add(comp2);
                while(!queue.isEmpty()){
                    int cur = queue.remove();
                    if(graph[comp1][cur] == 2 || graph[cur][comp1] == 2){
                        return false;
                    }
                    graph[comp1][cur] = 1;
                    graph[cur][comp1] = 1;
                    for(int i = 0; i < 26; i++){
                        if(graph[cur][i] == 1 && !visited.contains(i)){
                            queue.add(i);
                            visited.add(i);
                        }
                    }
                }

            }else{
                // 不相等的时候
                if(comp1 == comp2) return false;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(comp2);
                if(graph[comp1][comp2] == 1 || graph[comp2][comp1] == 1){
                    return false;
                }
                graph[comp1][comp2] = 2;
                graph[comp2][comp1] = 2;
                Set<Integer> visited = new HashSet<>();
                while (!queue.isEmpty()){
                    int cur = queue.remove();
                    if(graph[comp1][cur] == 1 || graph[cur][comp1] == 1){
                        return false;
                    }
                    graph[comp1][cur] = 2;
                    graph[cur][comp1] = 2;
                    for(int i = 0; i < 26; i++){
                        if(graph[cur][i] == 1 && !visited.contains(i)){
                            queue.add(i);
                            visited.add(i);
                        }
                    }
                }

                queue = new LinkedList<>();
                queue.add(comp1);
                visited = new HashSet<>();
                while (!queue.isEmpty()){
                    int cur = queue.remove();
                    if(graph[comp2][cur] == 1 || graph[cur][comp2] == 1){
                        return false;
                    }
                    graph[comp2][cur] = 2;
                    graph[cur][comp2] = 2;
                    for(int i = 0; i < 26; i++){
                        if(graph[cur][i] == 1 && !visited.contains(i)){
                            queue.add(i);
                            visited.add(i);
                        }
                    }
                }

            }
        }

        return true;
    }
}
