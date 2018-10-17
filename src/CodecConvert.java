import java.util.*;
public class CodecConvert {
    /*
    *
    又是靠自己做出来的，有点小开心~
    思路：
    每一层最左边的child作为新root
    encode: 对于跟自己同一层的nodes，构成其right substree. 自己本身的children，构成其left substree.
    decode: recursion返回 list<Node>,左边返回的list<node>是自己的children，右边返回的是自己的partners
    */

/*
    3-ary tree:
                  1
             /    |    \
            3     2    4
           / \
          5   6

    to binary tree:
                 1
               /
              3
             / \
            5   2
             \    \
              6    4
* */
    public static void main(String[] args){
        Node root = new Node(1, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        n3.children.add(new Node(5, new ArrayList<>()));
        n3.children.add(new Node(6, new ArrayList<>()));
        root.children.add(n3);
        root.children.add(new Node(2, new ArrayList<>()));
        root.children.add(new Node(4, new ArrayList<>()));
        TreeNode bRoot = encode(root);
        Codec obj = new Codec();
        String data = obj.serialize2(bRoot);
        System.out.println(data);
        Node newRoot = decode(bRoot);
        CodecNary obj2 = new CodecNary();
        String data2 = obj2.serialize(newRoot);
        System.out.println(data2);
    }

    public static TreeNode encode(Node root){
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        return helperEn(nodes);
    }

    private static TreeNode helperEn(List<Node> nodes){
        if(nodes == null || nodes.size() == 0){
            return null;
        }
        TreeNode root = new TreeNode(nodes.get(0).val);
        TreeNode left = helperEn(nodes.get(0).children);
        nodes.remove(0);
        TreeNode right = helperEn(nodes);
        root.left = left;
        root.right = right;
        return root;
    }

    public static Node decode(TreeNode root){
        List<Node> res = helperDe(root);
        if(res == null || res.size() == 0) return null;
        return res.get(0);
    }

    private static List<Node> helperDe(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        List<Node> partners = helperDe(root.right);
        List<Node> children = helperDe(root.left);
        Node nroot = new Node(root.val, children);
        // 注意这里是insert在index = 0处！
        partners.add(0,nroot);
        return partners;
    }
}
