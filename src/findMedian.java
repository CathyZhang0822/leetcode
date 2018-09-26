import java.util.*;
class MedianFinder {
    /*
    My idea is to use two heaps: min heap and max heap
    min heap is to store the larger half part
    max heap is to store the smaller half part
    always maintain the difference between two heaps' size <= 1.
    So everytime the peek(s) of heap(s) is the median
    */
    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.remove());
        if(maxHeap.size() > minHeap.size()){
            minHeap.add(maxHeap.remove());
        }
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return ((double) minHeap.peek() + (double) maxHeap.peek())/2;
        }else{
            return (double) minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
public class findMedian {
    public static void main(String[] args){
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
