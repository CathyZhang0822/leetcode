public class insertIntoCyclic {
    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = a;

    }
    public ListNode insert(ListNode head, int insertVal) {
        if(head == null){
            ListNode newHead = new ListNode(insertVal);
            newHead.next = newHead;
            return newHead;
        }
        ListNode move = head;
        do{
            // case 1: insert in the middle
            if((move.next.val) > move.val && (move.val <= insertVal && insertVal <= move.next.val)){
                ListNode nextTemp = move.next;
                move.next = new ListNode(insertVal);
                move.next.next = nextTemp;
                return head;
            }
            // case 2: insert it between head and tail
            if(move.next.val < move.val && (move.next.val >= insertVal || insertVal >= move.val)){
                ListNode nextTemp = move.next;
                move.next = new ListNode(insertVal);
                move.next.next = nextTemp;
                return head;
            }
            move = move.next;
        }while(move != head);
        // case 3: the list is flatted ie: (3,3,3)
        ListNode nextTemp = move.next;
        move.next = new ListNode(insertVal);
        move.next.next = nextTemp;
        return head;

    }
}
