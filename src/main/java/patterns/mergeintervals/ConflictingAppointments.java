package patterns.mergeintervals;

import java.util.Arrays;

class ConflictingAppointments {

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals,(a, b) -> Integer.compare(a.start,b.start));

        if(intervals.length < 2 )return true;

        int oldStart = intervals[0].start;
        int oldEnd = intervals[0].end;
        //[[1,4], [2,5], [7,9]]

        for( int i = 1; i < intervals.length; i++ ) {

            if(intervals[i].start < oldEnd ) {
                return false;
            }
            oldStart = intervals[i].start;
            oldEnd = intervals[i].end;
        }
        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }
}
