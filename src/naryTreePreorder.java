import java.util.*;
public class naryTreePreorder {
    static class Node{
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args){
        naryTreePreorder obj = new naryTreePreorder();
        Node n1= new Node(1, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        Node n2 = new Node(2, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());
        Node n5 = new Node(5, new ArrayList<>());
        Node n6 = new Node(6, new ArrayList<>());
        Node n7 = new Node(7, new ArrayList<>());
        n1.children.addAll(Arrays.asList(n3, null, n2, n4));
        n3.children.addAll(Arrays.asList(n5, n6, n7));
        System.out.println(obj.preorder(n1));
        System.out.println(obj.preorder2(n1));
    }
    /*
    method 1:
    记下来啊
    * */
    public List<Integer> preorder(Node root) {
        // 就是感觉很奇妙
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node cur = stack.pop();
            res.add(cur.val);
            for(int i = cur.children.size()-1; i >= 0; i--){
                if(cur.children.get(i) == null) continue;
                stack.push(cur.children.get(i));
            }
        }
        return res;
    }
    /*
    method 2:
    我的这种方法是 inspired by binary tree iterative preorder traverse
    考虑了List<Node> children 里面含有null node的情况
    如果children 里面不含有null，就相当于complete binary tree。会简单一些

    very similar to "binary tree preorder traverse". at mean time: store current child's index
    */

    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        // store the index of current node in its parent list.
        Stack<Integer> index = new Stack<>();
        Node move = root;
        while(!stack.isEmpty() || move != null){
            if(move != null){
                stack.push(move);
                res.add(move.val);
                // 一直往左走
                move = move.children.size() > 0 ? move.children.get(0) : null;
                index.push(0);
            }else{
                // push 进去的index是child相对于p(arent) node而言
                Node p = stack.pop();
                int idx = index.pop();
                // 注意这里因为是n-array tree。找到了右边一位的child之后还要再push回去。
                if(p.children.size() > (idx+1)){
                    move = p.children.get(idx + 1);
                    index.push(idx+1);
                    stack.push(p);
                }else{
                    move = null;
                }
            }
        }
        return res;
    }

    /* method 2: 默认children list里面没有 null
    * */

}
