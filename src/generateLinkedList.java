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

    public String show(ListNode head){
        StringBuilder sb = new StringBuilder();
        while(head!=null){
            sb.append(" -> " + head.val);
            head = head.next;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
