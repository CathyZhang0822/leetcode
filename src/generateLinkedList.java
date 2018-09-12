class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
public class generateLinkedList {
    public ListNode generate(int[] nums){
        ListNode Dummy = new ListNode(0);
        ListNode move = Dummy;
        for(int num : nums){
            move.next = new ListNode(num);
            move = move.next;
        }
        return Dummy.next;
    }
}
