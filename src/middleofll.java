import java.util.*;

public class middleofll {
    public static void main(String[] args){
        middleofll obj = new middleofll();
        ListNode head = obj.generateLL(new int[] {1,2,3,4,5,6});
        ListNode mid = obj.findmid(head);
        System.out.println(mid.val);

    }

    private ListNode findmid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode generateLL(int[] nums){
        ListNode Dummy = new ListNode(0);
        ListNode move = Dummy;
        for(int num : nums){
            move.next = new ListNode(num);
            move = move.next;
        }
        return Dummy.next;
    }
}
