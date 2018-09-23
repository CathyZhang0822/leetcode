import java.util.Arrays;

public class CodecBST {
    public static void main(String[] args){
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(6);
        a.left = b;
        b.right = new TreeNode(4);
        a.right = c;
        c.left = d;
        c.right = null;
        System.out.println(serialize(null));
        String tree = "3,2,1,4";
        TreeNode root = deserialize(tree);
        System.out.println(serialize(root));
    }

    public static String serialize(TreeNode root){
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + ",");
        String left = serialize(root.left);
        String right = serialize(root.right);
        sb.append(left);
        sb.append(right);
        return sb.toString();
    }

    public static TreeNode deserialize(String data){
        String[] nodes = data.split(",");
        return helper(nodes, 0, nodes.length-1);
    }

    private static TreeNode helper(String[] nodes, int start, int end){
        if(start > end){
            return null;
        }
        if(start == end){
            return new TreeNode(Integer.parseInt(nodes[start]));
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[start]));
        int rightStart = end + 1;
        for(int i = start; i <= end; i++ ){
            if(Integer.parseInt(nodes[i]) > root.val){
                rightStart = i;
                break;
            }
        }
        TreeNode left = helper(nodes, start + 1, rightStart-1);
        TreeNode right = helper(nodes, rightStart, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
