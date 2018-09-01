import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
public class twoSumIV {
    public static void main(String[] args){
        twoSumIV obj = new twoSumIV();
        String tree = "4(2(1)(3))(6(5))";
        TreeNode root = obj.str2tree(tree);
        System.out.println(root.val);
        System.out.println(obj.findTargetv1(root,5));
        System.out.println(obj.findTargetv2(root,5));
    }

    /* Approach 1: DFS + HashSet Time: O(n), Space: O(n)
       this method also works for non-BSTs. The idea is to use a hashset
       to save all nodes'values in the tree. At the meantime, we check whether
       the hashset contains current node's complement.
    * */
    private boolean findTargetv1(TreeNode root, int k){
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private boolean dfs(TreeNode root, int target, HashSet<Integer> set){
        if(root == null){
            return false;
        }
        set.add(root.val);
        boolean left = dfs(root.left, target, set);
        boolean right = dfs(root.right, target, set);
        return set.contains(target - root.val) || left || right;
    }

    /* Approach 2: two pointers Time: O(n), Space: O(n)
       Take advantage of the property of BST.
       Use a sorted array to save the values of the nodes in the BST by using an inorder traversal.
    * */
    private boolean findTargetv2(TreeNode root, int k){
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int lo = 0, hi = nums.size()-1;
        while(lo < hi){
            if(nums.get(lo) + nums.get(hi) == k){
                return true;
            }else if (nums.get(lo) + nums.get(hi) < k){
                lo ++;
            }else{
                hi --;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> nums){
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
    /* Approach 3: bst iterator Time: O(n), Space: O(logn)
       相当于approach 2 的follow up，如果面试官问能否保持时间的同时优化空间，提示可以把BST想像成一个sorted array。
       回答可以用two pointers，实现两个BST iterator，一个从小到大，一个从大到小。用stack实现iterator。
    * */

    /* a helper function to construct a binary tree from string(lc 536)
       这个helper function我经常用，这样构造tree的时候方便点
       ie:
       input: "4(2(3)(1))(6(5))"
       output:        4
                     /  \
                    2    6
                   / \  /
                  3  1 5
       Use a treenode stack. When ')' appears, it means a substree is constructed.
       Pop it and connect it to its parent node.
    * */
    private TreeNode str2tree(String s){
        if(s == null || s.length() == 0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        boolean sign = true;
        while(i < s.length()){
            if(Character.isDigit(s.charAt(i))){
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i ++;
                }
                if (!sign){
                    num = 0 - num;
                    sign = true;
                }
                stack.push(new TreeNode(num));
            }else{
                if (s.charAt(i) == '-'){
                    sign = false;
                }
                if (s.charAt(i) == ')'){
                    TreeNode child = stack.pop();
                    TreeNode parent = stack.peek();
                    if (parent.left == null){
                        parent.left = child;
                    }else{
                        parent.right = child;
                    }
                }
                i ++;
            }
        }
        return stack.peek();
    }
}
