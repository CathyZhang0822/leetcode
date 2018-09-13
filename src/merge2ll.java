import java.util.*;
public class merge2ll {
    public static void main(String[] args){
        generateLinkedList obj = new generateLinkedList();
        ListNode l1 = obj.generate(new int[]{1,2,3});
        ListNode l2 = obj.generate(new int[]{1,3,4,5,6});
        System.out.println(obj.show(mergeTwoLists(l1,l2)));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        //可以理解了，是call by reference ! reference是地址啊
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null || l2 != null){
            if(l1 == null){
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }else if(l2 == null){
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                if(l1.val < l2.val){
                    head.next = new ListNode(l1.val);
                    l1 = l1.next;
                }else{
                    head.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            head = head.next;
        }
        return dummy.next;
    }
}
