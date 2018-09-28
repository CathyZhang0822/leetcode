import java.util.*;
class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
}

public class copyListWithRandom {
    // method1: use a hashmap 1. copy all nodes 2. assign next and random pointer
    public RandomListNode copyRandomList(RandomListNode head) {
        // use a hashmap to store node origin node : cloned node
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode move = head;
        while(move!=null){
            // origin node : cloned node
            map.put(move, new RandomListNode(move.label));
            move = move.next;
        }
        for(Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()){
            RandomListNode origin = entry.getKey();
            RandomListNode clone = entry.getValue();
            // don't forget to copy next pointer!
            clone.next = map.get(origin.next);
            clone.random = map.get(origin.random);
        }
        return map.get(head);
    }
    /* Method 2: space O(1) 把每个node duplicated 一下, 放在后面
    * */
    public RandomListNode copyRandomList2(RandomListNode head) {
        /*
        space O(1). The idea is to associate the original node with its
        copy node in a single linked list. In this way, we don't need extra
        space to keep track of new nodes.
        3 iteration rounds:
        1. Iterate the original list and duplicate each node. The duplicate
        node follows the original node immediately.
        2. Iteration the new list and assign the random pointer for each
        duplicated nodes
        3. Restore the origin list and extract the copied list
        */
        // 1st round: duplicate nodes
        RandomListNode iter = head;
        while(iter != null){
            RandomListNode copy= new RandomListNode(iter.label);
            copy.next = iter.next;
            iter.next = copy;
            iter = copy.next;
        }
        // 2nd round: assign random nodes
        iter = head;
        while(iter != null){
            RandomListNode copy = iter.next;
            // assign random to copied node
            if(iter.random!=null){
                // 注意这里对iter.random进行了dereference操作，要判断是不是null
                copy.random = iter.random.next;
            }
            iter = copy.next;
        }
        // 3rd round: restore the origin list
        iter = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copyIter = dummy;
        while(iter != null){
            RandomListNode copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            iter.next = copy.next;
            iter = iter.next;
        }
        return dummy.next;
    }
}
