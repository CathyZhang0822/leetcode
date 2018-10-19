import java.util.*;
public class closetKValues {
    public static void main(String[] args){
        Codec obj = new Codec();
        String data = "6,2,8,0,4,7,9,N,N,3,5,N,N,N,N,N,N,N,N,";
        TreeNode root = obj.deserilize2(data);
        System.out.println(closetK(root,7.9,2));
    }

    public static List<Integer> closetK(TreeNode root, double target, int k){
        List<Integer> res = new ArrayList<>();
        TreeNode suc = successor(root, target);
        TreeNode pred = predecessor(root, target);
        if(contain(root, target)) res.add((int) target);
        while(res.size() < k){
            System.out.println("suc: " + suc.val);
            System.out.println("pred: " + pred.val);
            if(pred == null || (Math.abs(suc.val - target) < Math.abs(pred.val - target))){
                res.add(suc.val);
                suc = successor(root, suc.val);
            }else{
                res.add(pred.val);
                pred = predecessor(root, pred.val);
            }
        }
        return res;
    }

    private static TreeNode successor(TreeNode root, double target){
        TreeNode prev = null;
        while(root != null){
            if(root.val <= target){
                root = root.right;
            }else{
                prev = root;
                root = root.left;
            }
        }
        return prev;
    }

    private static TreeNode predecessor(TreeNode root, double target){
        TreeNode prev = null;
        while(root != null){
            if(root.val >= target){
                root = root.left;
            }else{
                prev = root;
                root = root.right;
            }
        }
        return prev;
    }

    private static boolean contain(TreeNode root, double target){
        while(root != null){
            if(root.val == target) return true;
            if(root.val < target){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return false;
    }
}
