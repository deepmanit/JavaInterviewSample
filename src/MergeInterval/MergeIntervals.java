package MergeInterval;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        // TODO: Write your code here
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;
        while(intervalItr.hasNext())
        {
            interval = intervalItr.next();
            if(interval.start <= end)
            {
                end = Math.max(interval.end,end);
            }
            else
            {
                mergedIntervals.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }

        }
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;

    }
}
