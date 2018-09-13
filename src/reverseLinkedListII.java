public class reverseLinkedListII {
    public static void main(String[] args){
        generateLinkedList obj = new generateLinkedList();
        ListNode head = obj.generate(new int[]{0,1,2,3,4,5});
        obj.show(reverseBetween(head, 2,8));

    }
    // 这是92 那道题
    public static ListNode reverseBetween(ListNode head, int m, int n){
        /*
        再深入理解call by reference，是那个node的地址，不会跟着动，一直在那个地址呆着
        慢慢深入到写出来大致分了三步：
        1。完全理解从头到尾 reverse linked list
        2。从头到第N个 reverse
        3。从第M个到第N个 reverse
        * */
        ListNode dummy = new ListNode(0);
        ListNode move = dummy;
        dummy.next = head;
        for(int i=0; i < m-1; i ++){
            move = move.next;
        }
        ListNode firstPartTail = move;
        move = move.next;
        System.out.println(firstPartTail.val);
        ListNode pre = null;
        ListNode cur = move;
        ListNode next;
        for(int i = 0; i < n - m + 1; i++){
            // 这个条件语句非常重要，虽然leetcode 里面没有要求。但是我们要想到当 N 越界了怎么办
            // 很简单，联想到 reverse linked list(从头到尾)的条件语句是： while(head != null)
            if(cur == null){
                break;
            }
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        move.next = cur;
        firstPartTail.next = pre;
        return dummy.next;
    }
}
