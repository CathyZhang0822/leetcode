public class partitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode move = dummy;
        ListNode iter = head;
        while(iter != null){
            if(iter.val < x){
                move.next = new ListNode(iter.val);
                move = move.next;
            }
            iter = iter.next;
        }
        iter = head;
        while(iter != null){
            if(iter.val >= x){
                move.next = new ListNode(iter.val);
                move = move.next;
            }
            iter = iter.next;
        }
        return dummy.next;
    }
}
