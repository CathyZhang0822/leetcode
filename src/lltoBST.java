public class lltoBST {
    /*典型divide and conquer
    * */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode preSlow = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            preSlow = slow;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        preSlow.next = null;
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(slow.next);
        root.left = left;
        root.right = right;
        return root;
    }
}
