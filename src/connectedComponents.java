import java.util.*;
public class connectedComponents {
    public static void main(String[] args){
        generateLinkedList obj = new generateLinkedList();
        int[] nums = new int[] {5,2,3,0};
        int[] eles = new int[] {0,1,2,3,4,5};
        ListNode head = obj.generate(eles);
        System.out.println(numComponets(head, nums));

    }
    public static int numComponets(ListNode head, int[] G){
        Set<Integer> nums = new HashSet<>();
        for(int num : G){
            nums.add(num);
        }
        int res = 0;
        boolean prev = false;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head != null){
            if(nums.contains(head.val)){
                if(!prev){
                    res ++;
                }
                prev = true;
            }else{
                prev = false;
            }
            head = head.next;
        }
        return res;
    }
}
