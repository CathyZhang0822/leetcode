public class deleteNode {
    public static void main(String[] args){
        generateLinkedList obj = new generateLinkedList();
        ListNode l1 = new ListNode(0);
        ListNode l2 = obj.generate(new int[] {1,2,3});
        obj.show(l2);
        ListNode haha = new ListNode(999);
        obj.show(haha);
        l1.next = haha;
        haha.next = l2;
        obj.show(l1);
        delete(haha);
        obj.show(l1);

    }
    /*这道题很有意思
      只给access to this node，删除这个node
    * */
    public static void delete(ListNode node){
        //感觉都在给NODE.NEXT做dereference啊，好虚
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
