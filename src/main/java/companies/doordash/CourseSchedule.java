package companies.doordash;

import java.util.*;

public class CourseSchedule {


    public static void main(String[] args) {

        new CourseSchedule().findOrder(3,new int[][]{{0, 2}, {1, 2}, {2, 0}});
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] degree = new int[numCourses];

        Map<Integer,List<Integer>> graph = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0 ; i < numCourses; i++ ) {

            graph.put(i,new ArrayList<>());
        }

        for(int[] course : prerequisites ) {

            degree[course[1]]++;
            graph.get(course[0]).add(course[1]);
        }

        for(int i = 0 ; i < numCourses; i++ ) {

            if(degree[i] == 0 ){
                result.add(0, i);
                queue.add(i);
            }
        }

        if(result.size() == 0 ) return new int[0];

        while(!queue.isEmpty()) {

            int courseValue = queue.poll();

            List<Integer> courses = graph.get(courseValue);

            for(int course : courses ) {

                degree[course]--;

                if(degree[course] == 0 ) {
                    queue.add(course);
                    result.add(0,course);
                }
            }
        }

        if(result.size() == numCourses ) return result.stream().mapToInt(i -> i).toArray();

        return new int[0];
    }

}
