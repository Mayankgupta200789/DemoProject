package companies.doordash;

import patterns.mergeintervals.dto.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class EmployeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> freeIntervals = new LinkedList<Interval>();

        List<Interval> totalIntervals = new LinkedList<>();

        for(List<Interval> intervals : schedule ) {
            for(Interval interval : intervals ) {
                totalIntervals.add(interval);
            }
        }

        Collections.sort(totalIntervals, Comparator.comparingInt(a -> a.start));

        Interval previousInterval = totalIntervals.get(0);

        int previousStart = previousInterval.start;
        int previousEnd = previousInterval.end;

        for(int i = 1; i < totalIntervals.size(); i++ ) {


            Interval newInterval = totalIntervals.get(i);

            if(previousEnd >= newInterval.start) {
                previousEnd = Math.max(previousEnd, newInterval.end);
            } else {
                freeIntervals.add(new Interval(previousEnd,newInterval.start));
                previousStart = newInterval.start;
                previousEnd = newInterval.end;
            }
        }
        return freeIntervals;



    }
}
