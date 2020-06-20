package MergeInterval;

import java.util.Arrays;


public class ConflictingAppointments {
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        // TODO: Write your code here
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        //Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        int start = intervals[0].start;
        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                // please note the comparison above, it is "<" and not "<="
                // while merging we needed "<=" comparison, as we will be merging the two
                // intervals having condition "intervals[i].start == intervals[i - 1].end" but
                // such intervals don't represent conflicting appointments as one starts right
                // after the other
                return false;
            }
        }

        return true;
    }

}
