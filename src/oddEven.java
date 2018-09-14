public class oddEven {
    public static void main(String[] args){
        generateLinkedList obj = new generateLinkedList();
        ListNode head = obj.generate(new int[] {1,2,3,4,5,6,7});
        obj.show(oddEvenList(head));
    }
    // split it into two linked lists then connect them
    public static ListNode oddEvenList(ListNode head){
        if(head == null){
            return null;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        // while 里面的判断语句注意是EVEN !!
        while(even != null && even.next != null){
            // 注意先对ODD 操作
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
