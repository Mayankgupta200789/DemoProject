package companies.microsoft;

import java.util.*;

public class TopologicalSort {

    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            Map<Integer,Integer> inDegree = new HashMap<>();
            Map<Integer,List<Integer>> graph = new HashMap<>();
            List<Integer> result = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();

            for(int i = 0 ; i < numCourses; i++ ) {

                inDegree.put(i,0);
                graph.put(i,new ArrayList<>());
            }

            for(int[] course : prerequisites ) {
                int parent = course[1], child = course[0];
                inDegree.put(child,inDegree.getOrDefault(child,0) + 1);
                graph.get(parent).add(child);
            }

            for(Map.Entry<Integer,Integer> entry : inDegree.entrySet()) {

                if(entry.getValue() == 0 ){
                    queue.add(entry.getKey());
                }
            }

            while(!queue.isEmpty()) {

                int course = queue.poll();
                result.add(course);

                List<Integer> children = graph.get(course);

                for(int child : children ){
                    inDegree.put(child,inDegree.get(child) - 1);

                    if(inDegree.get(child) == 0 ){
                        queue.add(child);
                    }
                }
            }

            if(result.size() == numCourses ) return result.stream().mapToInt(i -> i).toArray();

            return new int[0];
        }
    }
}
