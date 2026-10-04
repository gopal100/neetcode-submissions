/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.isEmpty())
            return 0;
        Queue<Interval> pq = new PriorityQueue<Interval>(
            (a, b) -> a.end-b.end == 0 ? a.start-b.start : a.end-b.end);

        intervals.sort((a, b) -> a.start-b.start == 0 ? a.end-b.end : a.start-b.start);
        //int roomCount =1;
        pq.add(intervals.get(0));

        for(int k =1; k<intervals.size(); k++){
            if(pq.peek().end <= intervals.get(k).start){
                pq.poll();
                pq.add(intervals.get(k));
                System.out.println(pq.peek().end );
            }
            else{
                pq.add(intervals.get(k));
                System.out.println(pq.peek().end  + "   " + intervals.get(k).start);
            }
        }
        return pq.size();
    }
}
