public class removeDuplicates {
    public static void main(String[] args){
        generateLinkedList obj = new generateLinkedList();
        ListNode a = obj.generate(new int[] {1,1,2,3,4,5,5,5,6});
        obj.show(rmv3(a));
        obj.show(rmv1(a));
    }
    /* Approach1: return a new linked list

    * */
    private static ListNode rmv1(ListNode head){
        ListNode dummy = new ListNode(0);
        ListNode move = dummy;
        while(head != null){
            if(head.next == null || (head.val != head.next.val)){
                move.next = new ListNode(head.val);
                move = move.next;
            }

            head = head.next;
        }
        return dummy.next;
    }
    /* Approach2: remove duplicates in place

    * */
    private static ListNode rmv2(ListNode head){
        ListNode move = head;
        while(move != null){
            if(move.next != null && move.val == move.next.val){
                move.next = move.next.next;
            }else{
                move = move.next;
            }
        }
        return head;
    }
    /* Approach3: recursive method
    * */
    private static ListNode rmv3(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode nextHead = rmv3(head.next);
        if(head.val == nextHead.val){
            return nextHead;
        }else{
            head.next = nextHead;
            return head;
        }
    }
}
