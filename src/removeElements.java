import java.util.*;
public class removeElements {
    public static void main (String[] args){
        generateLinkedList obj = new generateLinkedList();
        ListNode head = obj.generate(new int[] {1,0,6,6,6,2,3,6,7});
        obj.show(rmv1(head,6));
        obj.show(head);
        obj.show(rmv2(head, 6));
    }
    /* Approach 1: return a new linked list
    * */
    private static ListNode rmv1(ListNode head, int val){
        ListNode dummy = new ListNode(0);
        ListNode move = dummy;
        while(head != null){
            if(head.val != val){
                move.next = new ListNode(head.val);
                move = move.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
    /* Approach 2: operate in place
    * */
    public static ListNode rmv2(ListNode head, int val){
        ListNode newHead = head;
        while(head != null){
            if(head.next != null && head.next.val == val){
                head.next = head.next.next;
            }
            else{
                head = head.next;
            }
        }
        return newHead;
    }
}
