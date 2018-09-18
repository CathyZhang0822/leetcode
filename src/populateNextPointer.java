import java.util.*;
class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
public class populateNextPointer {
    /* Approach 1: 对空间复杂度没有要求
       就是很基本的用queue 做 level order traverse
    * */
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode cur = q.remove();
                if (i == size - 1) {
                    cur.next = null;
                } else {
                    cur.next = q.peek();
                }
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
    }
    /* Approach 2:
       Considering in previous levels, neighbors are connected by "next". So we don't need to use
       queue to do level order traverse. We can make use of queue.
       Two while loops:
       一个是一层一层往下走
       一个是在当前层从左往右走
       因为tree 不是perfect的，所以要记录上下一层的 startNode -> levelHead
    * */
    public void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode levelHead = root;
        TreeLinkNode prev;
        TreeLinkNode cur;
        // boolean findHead = false; don't need that, we can see wheter prev ? null
        // 不要动root
        while (levelHead != null) {
            cur = levelHead;
            levelHead = null;
            prev = null;
            // traverse the level
            while (cur != null) {
                if (cur.left != null) {
                    if (prev == null) {// find the head of the level
                        levelHead = cur.left;
                    } else {
                        prev.next = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (prev == null) {// find the head of next level
                        levelHead = cur.right;
                    } else {
                        prev.next = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
            //go down to next level
            //root = levelHead;
        }

    }
}
