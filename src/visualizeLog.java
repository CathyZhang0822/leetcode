import java.util.*;
class Log{
    int user_id;
    int timestamp;
    String action;
    Log(int user_id, int timestamp, String action){
        this.user_id = user_id;
        this.timestamp = timestamp;
        this.action = action;
    }
}
public class visualizeLog {
    /*
    now we have data with 3 properties
    user_id, timestamp, action
    100, 1000, A.
    200, 1003, A
    300, 1009, B
    100, 1026, B
    100, 1030, C. 1point3acres 200, 1109, B
    200, 1503, A
    We want to output a graph to visualize it
    Graph from input:
    |---A (2)
    | |---B (2)
    | | |---C (1)
    | | |---A (1)
    |---B (1)
    aggregate by user_id: 100 : A->B->C
    200: A->B->A
    300: B . Waral 博客有更更多⽂文章,
    1. define data structure and classes
    2. construct the graph from logfile
    3. print out the graph similar to above
    * */


    class TrieNode{
        Map<String, TrieNode> children;
        int count;
        TrieNode(){
            children = new HashMap<>();
            count = 0;
        }
    }

    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        // a list of logs of one person in time increasing order
        void add (List<Log> logs){
            TrieNode cur = root;
            for(Log log : logs){
                String curAction = log.action;
                if(!cur.children.containsKey(curAction)) cur.children.put(curAction, new TrieNode());
                TrieNode next = cur.children.get(curAction);
                next.count ++;
                cur = next;
            }
        }

        void print(TrieNode root, int level){
            Map<String, TrieNode> children = root.children;
            if(children.keySet().isEmpty()) return;
            for(Map.Entry<String, TrieNode> entry : children.entrySet()){
                String action = entry.getKey();
                TrieNode child = entry.getValue();
                // print
                StringBuilder sb = new StringBuilder();
                sb.append("|");
                for(int i=0; i < level; i++) sb.append("  |");
                sb.append("---");
                sb.append(action);sb.append("(" + child.count + ")");
                System.out.println(sb.toString());
                // dfs go to next level
                print(child, level+1);
            }
        }
    }

    public static void main(String[] args){
        Log a1 = new Log(100, 1000, "A");
        Log a2 = new Log(100, 1003, "B");
        Log a3 = new Log(100, 1005, "C");
        Log b1 = new Log(200, 1006,"B");
        List<Log> logs = new ArrayList<>();
        logs.add(a1);
        logs.add(a2);
        logs.add(a3);
        logs.add(b1);
        visualizeLog obj = new visualizeLog();
        obj.printLog(logs);

    }

    public void printLog(List<Log> logs){
        TreeSet<Integer> users = new TreeSet<>();
        // cluster them by user id
        Map<Integer, List<Log>> map = new HashMap<>();
        for(Log log : logs){
            int id = log.user_id;
            users.add(id);
            map.putIfAbsent(id, new ArrayList<>());
            map.get(id).add(log);
        }
        // comparator to sort logs by timestamp
        Comparator<Log> comp = new Comparator<Log>() {
            @Override
            public int compare(Log o1, Log o2) {
                return o1.timestamp - o2.timestamp;
            }
        };
        // build the trie tree
        Trie trie = new Trie();
        for(int user : users){
            List<Log> curlogs = map.get(user);
            Collections.sort(curlogs, comp);
            trie.add(curlogs);
        }
        // helper function to print trie tree
        trie.print(trie.root, 0);
    }


}
