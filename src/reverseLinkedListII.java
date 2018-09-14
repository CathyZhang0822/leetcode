public class reverseLinkedListII {
    public static void main(String[] args){
        generateLinkedList obj = new generateLinkedList();
        ListNode head = obj.generate(new int[]{1,2,3});
        //ListNode head1 = reverseBetween(head, 1,2);
        //ListNode head2 = reverseBetween(head1,3,4);
        //obj.show(head1);
        //System.out.println(head1.val);
        //obj.show(head2);
        //obj.show(swapPaires(head));
        obj.show(reverseKGroup(head, 2));
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
        //System.out.println(firstPartTail.val);
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
    /* 做完上面那道题之后，感觉可以把 reverse m to n 当作 helper function
       就是每两个两个的reverse 0-1 2-3 4-5 这样
       24 swap nodes in pairs
    * */
    public static ListNode swapPaires(ListNode head){
        generateLinkedList obj = new generateLinkedList();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode move = head;
        int index = 0;
        while(move != null){
            index ++;
            move = move.next;
        }
        move = head;
        for(int i = 1; i < index; i=i+2){
            move = reverseBetween(move ,i,i+1);
            obj.show(move);
        }
        // 好好想想dummy的情况
        System.out.println("dummy:");
        obj.show(dummy);
        return move;
    }
    /* 同样的思路可以解决25
    * */
    public static ListNode reverseKGroup(ListNode head, int k){
        generateLinkedList obj = new generateLinkedList();

        ListNode move = head;
        int index = 0;
        while(move != null){
            index ++;
            move = move.next;
        }
        move = head;
        for(int i = 1; i+k-1 <= index; i=i+k){
            move = reverseBetween(move ,i,i+k-1);
            obj.show(move);
        }
        // 好好想想dummy的情况
        return move;
    }
}
