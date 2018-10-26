import java.util.*;
public class LRU {
    /*
    For get(), put()  --> it inspires me with hashmap
    The key point here is to keeping track of the least/most recently used item. --> this inspires me with doubly linked list
    So I would like to create a doubly ll Node class, this will store the information of key and value.
    the hashmap is to store nodes   node.key : node
    the doubly linked list is to help keep track of most recently used node(head) and least recently used node(tail).
    so I will write some pseodo code then add code details
    int get(int key){
        if(contains) return;
    }
    put(key,value){
        if(contains) {update the value, then move the node to head}
        if(not contains){
            create a new node
            put it to map
            put it to head of linked list
            if(size > capacity) remove the tail
        }
    }
    */
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    int capacity;
    Map<Integer, Node> map;
    Node dummyHead;
    Node dummyTail;
    public LRU(int capacity){
        capacity = this.capacity;
        map = new HashMap<>();
        dummyHead = new Node(-1,-1);
        dummyTail = new Node(-1,-1);
        // don't forget to connect head and tail!
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public void moveToHead(Node node){
        // if node in current linked list, disconnect it
        if(map.containsKey(node.key)){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }
        // put it into head position
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
        node.prev = dummyHead;
    }

    public void removeTail(){
        Node tail = dummyTail.prev;
        // remove tail node
        tail.prev.next = dummyTail;
        dummyTail.prev = tail.prev;
        tail.next = null;
        tail.prev = null;
        // don't forget to remove it from map!
        map.remove(tail.key);

    }

    public int get(int key){
        if(!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        // move to head(helper function)
        moveToHead(cur);
        return cur.val;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            Node cur = map.get(key);
            cur.val = value;
            moveToHead(cur);
        }else{
            Node cur = new Node(key, value);
            moveToHead(cur);
            map.putIfAbsent(key, cur);
            if(map.size() > capacity){
                // remove tail
                removeTail();
            }
        }
    }
}
