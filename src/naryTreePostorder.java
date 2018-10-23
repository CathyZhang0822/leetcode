import java.util.*;
public class naryTreePostorder {

    // method 1: 还是掌握这种方法吧！
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for(Node node: root.children)
                stack.add(node);
        }
        Collections.reverse(list);
        return list;
    }

    // method 2
    public List<Integer> postorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        // store the index of current node in its parent list.
        Stack<Integer> index = new Stack<>();
        Node move = root;
        while(!stack.isEmpty() || move != null){
            if(move != null){
                stack.push(move);
                res.add(move.val);
                // 一直往右走
                int size = move.children.size();
                move = size > 0 ? move.children.get(size-1) : null;
                index.push(size-1);
            }else{
                // push 进去的index是child相对于p(arent) node而言
                Node p = stack.pop();
                int idx = index.pop();
                // 注意这里因为是n-array tree。找到了左边一位的child之后还要再push回去。
                if(idx - 1 >= 0){
                    move = p.children.get(idx - 1);
                    index.push(idx-1);
                    stack.push(p);
                }else{
                    move = null;
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
}
