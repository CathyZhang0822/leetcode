import java.util.*;
public class Codec {
    public static void main(String[] args){
        Codec obj = new Codec();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        c.left = d;
        d.right = e;
        System.out.println(obj.serialize1(a));
        System.out.println(obj.serialize2(a));
        String data = "1,2,N,N,3,4,N,5,N,N,N,";
        TreeNode root = obj.deserilize1(data);
        System.out.println(obj.serialize2(root));

    }
    public String serialize1(TreeNode root){
        StringBuilder sb = new StringBuilder();
        sehelper1(root, sb);
        return sb.toString();
    }

    //思路就是 preorder traverse tree(recursive)
    private void sehelper1(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("N,");
            return;
        }
        // preorder: root->left->right
        sb.append(root.val+",");
        sehelper1(root.left,sb);
        sehelper1(root.right,sb);
    }

    //思路使用一个queue，serialize the tree level by level
    private String serialize2(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            // 这里既可以for loop queue.size()也可以不用
            TreeNode cur = queue.remove();
            if(cur != null){
                sb.append(cur.val+",");
                queue.add(cur.left);
                queue.add(cur.right);
            }else{
                sb.append("N,");
            }
        }
        return sb.toString();
    }

    public TreeNode deserilize1(String data){
        String[] values = data.split(",");
        System.out.println(Arrays.toString(values));
        int[] index = {0};
        return dehelper1(values,index);
    }
    private TreeNode dehelper1(String[] values, int[] index){
        //啊啊啊啊 STRING 要用equals 啊
        if(values[index[0]].equals("N")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0] ++;
        TreeNode left = dehelper1(values, index);
        index[0] ++;
        TreeNode right = dehelper1(values, index);
        root.left = left;
        root.right = right;
        return root;
    }
    //思路使用一个queue，construct the tree level by level
    public TreeNode deserilize2(String data){
        String[] values = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        int i = 1;
        while(i < values.length){
            // parent node
            TreeNode parent = queue.remove();
            // find left and right children
            if(!values[i].equals("N")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }else{
                parent.left = null;
            }
            i ++;

            if(!values[i].equals("N")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }else{
                parent.right = null;
            }
            i ++;
        }
        return root;
    }
}
