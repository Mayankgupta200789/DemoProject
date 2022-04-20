package companies.sixsense;

import java.util.*;

public class SquareFinder {

    public static void main(String[] args) {
        new SquareFinder().main();
    }

    public void main() {
        Point point = new Point(2, 1);
        List<Point> points = Arrays.asList(point,
                new Point(2, 3),
                new Point(2, 5),
                new Point(4, 1),
                new Point(4, 3),
                new Point(4, 5),
                new Point(4, 10),
                new Point(2, 100),
                new Point(6,1),
                new Point(6,5));
        // 2,1
        // 6,1
        // 2,5
        // 6,5


        System.out.println(new SquareFinder().find(points));
    }

    class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public int find(List<Point> points) {

        Map<Integer, Queue<Integer>> xMap = new TreeMap<>();
        for (Point point : points) {
            Queue<Integer> list = xMap.getOrDefault(point.x, new PriorityQueue<>());
            list.add(point.y);
            xMap.put(point.x, list);
        }
        int result = 0;



        // 2 -> 1,3,5,100
        // 4 -> 1,3,5,10
        // 6 -> 1,5

        List<List<Point>> results = new ArrayList<>();
        for (Map.Entry<Integer, Queue<Integer>> entry : xMap.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> values = new ArrayList<>(entry.getValue());

            List<Point> outputs = new ArrayList<>();
            if (values.size() >= 2) {
                for(int j = 0 ; j < values.size(); j++ ) {
                    int first = values.get(j);
                    for (int i = j + 1; i < values.size(); i++) {
                        Integer second = values.get(i);
                        int output = second - first;
                        List<Integer> yValues = new ArrayList<>(xMap.get(key + output));
                        if (yValues.contains(first) && yValues.contains(second)) {
                            result++;
                            outputs.add(new Point(output,first));
                            outputs.add(new Point(output,second));
                            outputs.add(new Point(key + output,first));
                            outputs.add(new Point(key + output,second));
                            results.add(new ArrayList<>(outputs));
                            outputs.clear();
                        }
                    }
                }
            }
        }
        return result;
    }
}
