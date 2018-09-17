public class deleteNodeInBST {
    public static void main(String[] args){
        Codec obj = new Codec();
        String tree = "5,3,6,2,4,N,7,N,N,N,N,N,N";
        TreeNode root = obj.deserilize2(tree);
        TreeNode newRoot = deleteNode(root, 3);
        System.out.println(obj.serialize2(newRoot));
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        System.out.println("a: " + obj.serialize2(a));
        b.left = new TreeNode(4);
        System.out.println("a: " + obj.serialize2(a));

    }
    public static TreeNode deleteNode(TreeNode root, int key){
        TreeNode pre = null;
        boolean left = false;
        boolean right = false;
        //step 1: find a node in BST
        TreeNode find = root;
        while(find != null){
            if(find.val > key){
                pre = find;
                find = find.left;
                left = true;
                right = false;
            }else if(find.val < key){
                pre = find;
                find = find.right;

                left = false;
                right = true;
            }else{
                // found this node
                // step2: helper function: merge 2 sub bst tree(delete the root of a bst tree)
                TreeNode sub = deleteRoot(find);
                if(left){
                    pre.left = sub;
                }else if(right){
                    pre.right = sub;
                }else{
                    return sub;
                }
                break;
            }
        }
        return root;
    }

    private static TreeNode deleteRoot(TreeNode root){
        if(root.left == null){
            return root.right;
        }
        if(root.right == null){
            return root.left;
        }
        TreeNode right = root.right;
        TreeNode left = root.left;
        while(right.left != null){
            right = right.left;
        }
        right.left = left;
        return root.right;
    }

}
