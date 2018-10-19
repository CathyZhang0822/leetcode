import java.util.*;
public class findDupSubTree {
    /*
   preorder traverse: serialize tree , store them into a hash set
   */
    Map<String, TreeNode> map;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        Set<String> set = new HashSet<>();
        ser(root, set);
        //System.out.println(set);
        List<TreeNode> list = new ArrayList<>();
        for(String data : set){
            list.add(map.get(data));
        }
        return list;
    }

    private String ser(TreeNode root, Set<String> res){
        if(root == null) return "N,";
        String leftTree = ser(root.left, res);
        String rightTree = ser(root.right, res);
        String data = root.val + "," + leftTree + rightTree;
        if(map.containsKey(data)){
            res.add(data);
        }
        else{
            map.put(data, root);
        }
        return data;
    }
}
