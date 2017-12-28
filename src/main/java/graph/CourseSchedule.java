package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Mayank Gupta
 * @Date 12/27/17
 */
public class CourseSchedule {

    public static void main(String[] args) {

        CourseSchedule courseSchedule = new CourseSchedule();

        int[][] pre = new int[1][2];

        pre[0][0] = 0;
        pre[0][1] = 1;

        courseSchedule.findOrder(2,pre);

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        int[] degree = new int[numCourses];

        Queue<Integer> queue = new LinkedList<>();

        List<Integer> result = new ArrayList<>();

        int j = numCourses - 1;


        for(int i = 0 ; i < numCourses; i++ ) {
            graph.add(i,new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++ ) {
            degree[prerequisites[i][1]]++;
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int i = 0 ; i < degree.length; i++ ) {

            if( degree[i] == 0 ) {
                result.add(i);
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {

            int course = queue.remove();

            List<Integer> courses = graph.get(course);

            for(int i = 0 ; i < courses.size(); i++ ) {

                int pointer = courses.get(i);

                degree[pointer]--;

                if( degree[pointer] == 0 ) {

                    result.add(pointer);
                    queue.add(pointer);
                }
            }
        }

        if( result.size() != numCourses)    return new int[0];

        int[] output = new int[result.size()];
        int k = 0;

        for(int l = (result.size() - 1); l >= 0; l-- ) {
            output[l] = result.get(k++);
        }

        return output;

    }
}
