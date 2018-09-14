import java.util.*;
public class mergeKll {
    public static void main(String[] args){
        generateLinkedList obj = new generateLinkedList();
        ListNode l1 = obj.generate(new int[] {0,0,0,9,9,9});
        ListNode l2 = obj.generate(new int[] {1,1,4,5});
        ListNode l3 = obj.generate(new int[] {1,2});
        ListNode l4 = obj.generate(new int[] {3,4});
        ListNode l5 = obj.generate(new int[] {1,7});
        ListNode[] lists = new ListNode[] {l1,l2,l3,l4,l5};
    }
    /* Approach 1:
    Compare every k nodes (head of every linked list) and get the node with the smallest value.
    Use Priority Queue to do the comparision process.
    Time: O(n*logk) k linked lists, n nodes in total
    Space: O(k) k size of pq
    * */
    public static ListNode mergeKListsWithPQ(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }
        Comparator<ListNode> comp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val <= o2.val){
                    return -1;
                }else{
                    return 1;
                }
            }
        };
        PriorityQueue<ListNode> pq = new PriorityQueue<>(comp);
        ListNode dummy = new ListNode(0);
        ListNode move = dummy;
        // add all linked lists into pq
        for(ListNode node: lists){
            if(node != null){
                pq.add(node);
            }
        }
        while(!pq.isEmpty()){
            ListNode cur = pq.poll();
            move.next = new ListNode(cur.val);
            move = move.next;
            if(cur.next != null){
                pq.add(cur.next);
            }
        }
        return dummy.next;
    }
    /*
    Approach 2:
    Divide and conquer. Pair up k lists and merge each pair.
    Time: O(Nlogk) logk 次 to merge 2 lists, O(N) time of each merging 2 lists
    Space: O(1)
    * */
    public static ListNode mergekListswithDandC(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }
        return mergek(lists, 0, lists.length-1);
    }
    public static ListNode mergek(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }
        int mid = (start + end)/2;
        ListNode l1 = mergek(lists, start, mid);
        ListNode l2 = mergek(lists, mid+1, end);
        return merge2(l1, l2);
    }
    // merge 2 linked lists
    public static ListNode merge2(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while(l1 != null || l2 != null){
            if(l1 == null || (l2!=null && l2.val < l1.val)){
                pre.next = new ListNode(l2.val);
                l2 = l2.next;
            }else{
                pre.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            pre = pre.next;
        }
        return dummy.next;
    }
}
