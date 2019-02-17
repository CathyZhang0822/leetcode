import java.util.*;

public class numSquarePermutaion {
    class Node{
        int val;
        List<Node> neighbors;
        Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }
    public static void main(String[] args){
        numSquarePermutaion obj = new numSquarePermutaion();
        int[] A = {0,0,0,1,1,1};
        obj.getNum(A);

    }
    Set<String> set;
    public int getNum(int[] A){
        Arrays.sort(A);
        set = new HashSet<>();
        Node[] nodes = new Node[A.length];
        for(int i=0; i< A.length;i++){
            nodes[i] = new Node(A[i]);
        }
        for(int i = 0; i < A.length; i++){
            for(int j = i+1; j < A.length; j++){
                //if(j > i + 1 && A[j] == A[j-1]) continue;
                if(isPair(A[i],A[j])){
                    System.out.println(A[i] + "," + A[j]);
                    nodes[i].neighbors.add(nodes[j]);
                    nodes[j].neighbors.add(nodes[i]);
                }
            }
        }
        for(int i = 0; i < nodes.length; i ++){
            if(i>0 && A[i] == A[i-1]) continue;
            Set<Node> visited = new HashSet<>();
            visited.add(nodes[i]);
            dfs(nodes[i], visited, A.length-1, nodes[i].val+",");
        }
        System.out.println("set: " + set);
        return set.size();
    }

    private void dfs(Node root, Set<Node> visited, int level, String path){
        System.out.println("path: " + path);
        if(level == 0){
            set.add(path);
            return;
        }
        //System.out.println("children: " + root.neighbors.size());
        Node prev = null;
        for(Node child:root.neighbors){

            if(visited.contains(child)) continue;
            if(prev != null && child.val == prev.val) continue;
            prev = child;
            visited.add(child);
            dfs(child, visited, level-1, path+child.val+",");
            visited.remove(child);
        }

    }

    private boolean isPair(int a, int b){
        //System.out.println(a*a+b*b);
        //System.out.println((int)(Math.sqrt((double) a*a+b*b)));
        return (a+b) == (int)(Math.sqrt((double) a+b)) *(int)(Math.sqrt((double) a+b));
    }
}
