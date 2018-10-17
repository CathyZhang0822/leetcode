import java.util.*;
class Node{
    int val;
    List<Node> children;
    public Node(){}
    public Node(int _val, List<Node> _children){
        val = _val;
        children = _children;
    }
}
public class CodecNary {

    /*
    Serialize 3-ary tree:
                  1
             /    |    \
            3     2    4
           / \
          5   6
    ie: as 1 [3 [5 6 ]2 4 ]
    * */
    /*
    感觉自己越来越熟能生巧了，感觉自己inspired by se & de binary tree 和 calculator系列
    serialize : 变形的pre-order traverse  root [child child child ..]
    deserialize: 还是利用int[] index 和括号一起做recursion，返回list of node
    * */

    public static void main(String[] args){
        Node root = new Node(1, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        n3.children.add(new Node(5, new ArrayList<>()));
        n3.children.add(new Node(6, new ArrayList<>()));
        root.children.add(n3);
        root.children.add(new Node(2, new ArrayList<>()));
        root.children.add(new Node(4, new ArrayList<>()));
        CodecNary obj = new CodecNary();
        String data = obj.serialize(root);
        System.out.println(data);
        Node newRoot = obj.deserialize(data);
        System.out.println(obj.serialize(newRoot));
    }

    public String serialize(Node root){
        if(root == null){
            return " ";
        }
        if(root.children == null || root.children.size() == 0){
            return root.val + " ";
        }

        StringBuilder sb = new StringBuilder();

        sb.append(root.val + " ");
        sb.append("[");
        for(Node child : root.children){
            sb.append(serialize(child));
        }
        sb.append("]");
        return sb.toString();
    }

    public  Node deserialize(String data){
        int[] index = {0};
        List<Node> res = helper(data, index);
        return res.get(0);
    }

    private  List<Node> helper(String data, int[] index){
        Stack<Node> stack = new Stack<>();
        for(; index[0] < data.length()-1; index[0] ++){
            char c = data.charAt(index[0]);
            // find a number
            if(Character.isDigit(c)){
                int sum = 0;
                while(index[0] < data.length()-1 && Character.isDigit(data.charAt(index[0]))){
                    sum = sum * 10 + (data.charAt(index[0])-'0');
                    index[0] ++;
                }
                Node cur = new Node(sum, new ArrayList<>());
                stack.push(cur);
                index[0] --;
            }else if(c == '['){
                index[0] ++;
                List<Node> children = helper(data, index);
                Node parent = stack.peek();
                parent.children = children;
            }else if (c == ']'){
                List<Node> res = new ArrayList<>();
                while(!stack.isEmpty()){
                    res.add(0, stack.pop());
                }
                return res;
            }else{
                continue;
            }
        }
        List<Node> res = new ArrayList<>();
        while(!stack.isEmpty()){
            res.add(0, stack.pop());
        }
        return res;
    }


}

