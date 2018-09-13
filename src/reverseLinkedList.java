public class reverseLinkedList {
    public static void main(String[] args){
        generateLinkedList obj = new generateLinkedList();
        ListNode head = obj.generate(new int[] {1,2,3,4,5});
        ListNode newHead = reverse(head);
        System.out.println(newHead.val);
    }
/* Iterative 方法
* */
    private static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
/* Recursive 方法
* */
    private static ListNode reverseRecursive(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode headNext = head.next;
        ListNode newHead = reverseRecursive(headNext);
        headNext.next = head;
        head.next = null;
        return newHead;
    }
}
