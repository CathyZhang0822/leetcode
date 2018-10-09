import java.util.*;
public class taskByLevel {
    // 在这里构建有向图的时候，是 parent : list of children(对于数字，可以直接构造list of lists.对于String, 用map)
    // 但是昨天那道题就明显是 child : list of parents更好用
    /*  算task和pretask輸出task by level的那題.
       Just calculate indegree, bfs 
       input = { {"cook", "eat"},   // do "cook" before "eat"  {"study", "eat"}, {"sleep", "study"}}  
       output = (steps of a workflow): {{"sleep", "cook"},. {"study"}, {"eat"}}
       step1: hashmap use integers to present tasks
       step2: build the directed graph and record indegree
       step3: topological sort(BFS)
    * */
    public static void main(String[] args){
        String[][] tasks = {{"cook","eat"},{"study", "eat"}, {"sleep","study"}};
        System.out.println(level(tasks));
    }

    public static List<List<String>> level(String[][] tasks){
        // res
        List<List<String>> res = new ArrayList<>();
        // build the directed graph, and an indegree map
        // map: parent: its children
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        for(String[] task : tasks){
            // task[0]: parent, task[1]: child
            map.putIfAbsent(task[0], new ArrayList<>());
            map.putIfAbsent(task[1], new ArrayList<>());
            map.get(task[0]).add(task[1]);
            // indegree map
            indegree.putIfAbsent(task[0], 0);
            indegree.putIfAbsent(task[1], 0);
            indegree.put(task[1], indegree.get(task[1])+1);
        }
        //BFS, Starting from nodes whose indegree is 0
        Queue<String> queue = new LinkedList<>();
        for(Map.Entry<String, Integer> entry: indegree.entrySet()){
            if(entry.getValue()==0) queue.add(entry.getKey());
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            // traverse current level
            List<String> cur = new ArrayList<>();
            for(int i = 0; i < size; i++){
                String parent = queue.remove();
                cur.add(parent);
                //indegree.remove(parent);
                for(String child : map.get(parent)){
                    indegree.put(child, indegree.get(child)-1);
                    if(indegree.get(child) == 0) queue.add(child);
                }
            }
            res.add(new ArrayList<>(cur));
        }
        return res;
    }
}
