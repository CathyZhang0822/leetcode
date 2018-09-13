import java.util.*;
public class linkedlistcircle {
    public static void main(String[] args){

    }
    /* 判断linked list有没有环
    老生常谈的fast/slow pointer解法，但是我更喜欢 hashset 解法
    * */
    public static boolean hasCircle(ListNode head){
        if(head == null){
            return false;
        }
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    /* Follow up:
    Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
    这道题除了老生常谈的fast & slow pointers方法，其实我更想强调的是 hashset 的方法。非常straight forward啊。
    If we keep track of the nodes that we've seen already in a Set, (use a set to store references of visited nodes)
    we can traverse the linked list and return the first duplicate node.
    如果找到了一个node is visited, return true(上一道题)/this node
    * */
    public static ListNode detectCircle(ListNode head){
        Set<ListNode> visited = new HashSet<>();
        ListNode move = head;
        while(move != null){
            if(visited.contains(head)){
                return move;
            }
            visited.add(move);
            move = move.next;
        }
        return null;
    }

}


