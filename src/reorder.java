public class reorder {
    public static void main(String[] args){
        generateLinkedList obj = new generateLinkedList();
        ListNode head = obj.generate(new int[] {1,2,3,4,5});
        reOrder(head);
    }
    /*
    Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
    You may not modify the values in the list's nodes, only nodes itself may be changed.
    Example:
    Given 1->2->3->4, reorder it to 1->4->2->3.
    * */

    public static void reOrder(ListNode head){
        // 注意这个corner case,
        if(head == null || head.next == null){
            return;
        }
        generateLinkedList obj = new generateLinkedList();
        // step1: split it into 2 parts
        ListNode slow = head, fast = head, prevSlow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }
        // step2: reverse the 2nd part
        ListNode new2part = reverse(slow);
        prevSlow.next = null;
        ListNode move = head;
        ListNode then;
        /* step3: merge 2 lists in place 需要注意一下
           quick slow pointers split的链表 第二部分长度 >= 第一部分长度
                                           5 -> 4 -> 3   1 -> 2
        * */
        while(new2part!=null){
            if(move.next == null){
                move.next = new2part;
                break;
            }
            then = move.next;
            move.next = new2part;
            new2part = new2part.next;
            move.next.next = then;
            move = then;
        }
    }

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
}
