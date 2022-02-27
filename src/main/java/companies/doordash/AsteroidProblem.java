package companies.doordash;

import java.util.LinkedList;

public class AsteroidProblem {


    public static void main(String[] args) {
        new AsteroidProblem().asteroidCollision(new int[]{-10,5});
    }

    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        // If the first element comes as negative
        // we will not do anything with it because its already going to negative direction
        // Thus, we will keep it is
        for(int i = 0; i < asteroids.length; i++ ) {

            if(asteroids[i] > 0 || result.isEmpty() || result.getLast() < 0 ) {
                result.add(asteroids[i]);
            } else if( result.getLast() <= -asteroids[i]) {
                // this will keep the index at this position
                // as when it comes out of here i++ happens again and cancels out movement
                // so no movement will happen.

                if(result.pollLast() < -asteroids[i]) i--;
            }



        }




        return result.stream().mapToInt(i -> i).toArray();
    }
}
