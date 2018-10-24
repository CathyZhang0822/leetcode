import java.util.*;
public class employeeTime {
    class Interval {
        int start;
        int end;
        Interval() {start = 0; end = 0;}
        Interval(int s, int e) {start = s; end = e;}
    }
    /*
    The idea is to just add all the intervals to the priority queue.
    (NOTE that it is not matter how many different people are there for the algorithm.
    becuase we just need to find a gap in the time line.
    priority queue - sorted by start time, and for same start time sort by either largest end time or smallest (it is not matter).
    Everytime you poll from priority queue, just make sure it doesn't intersect with previous interval.
    This mean that there is no coomon interval. Everyone is free time.
    * */
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> result = new ArrayList<>();

        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        schedule.forEach(e -> pq.addAll(e));

        Interval temp = pq.poll();
        while(!pq.isEmpty()) {
            if(temp.end < pq.peek().start) { // no intersect
                result.add(new Interval(temp.end, pq.peek().start));
                temp = pq.poll(); // becomes the next temp interval
            }else { // intersect or sub merged
                temp = temp.end < pq.peek().end ? pq.peek() : temp;
                pq.poll();
            }
        }
        return result;
    }
}
