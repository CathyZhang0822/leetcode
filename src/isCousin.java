import java.util.*;

class Pair {
    int depth;
    TreeNode parent;
    Pair(int depth, TreeNode parent){
        this.depth = depth;
        this.parent = parent;
    }
}
public class isCousin {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        root.left = a;
        root.right = b;
        a.left = c;
        b.right = d;
        isCousin obj = new isCousin();
        System.out.println(obj.isCousins(root, 4,5));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if(x == y) return false;
        Map<Integer, Pair> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        TreeNode parent = null;
        queue.add(parent);
        while(!queue.isEmpty()){
            int size = queue.size();
            // System.out.println("depth: " + depth);
            for(int i = 0; i < size; i=i+2){
                TreeNode cur = queue.remove();
                parent = queue.remove();
                System.out.println("cur val: " + cur.val);
                System.out.println("depth: " + depth);
                map.put(cur.val, new Pair(depth, parent));
                if(cur.left != null){
                    queue.add(cur.left);
                    queue.add(cur);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                    queue.add(cur);
                }
            }
            depth ++;
        }
        if(map.get(x).parent == null || map.get(y).parent == null){
            return false;
        }

        return (map.get(x).depth == map.get(y).depth && (map.get(x).parent.val != map.get(y).parent.val));
    }
}


