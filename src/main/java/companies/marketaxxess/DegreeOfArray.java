package companies.marketaxxess;


import java.util.*;

public class DegreeOfArray {

    public class Element {

        int num;
        int startIndex;
        int endIndex;

        public Element(int num,int startIndex, int endIndex) {

            this.num = num;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public boolean equals(Object obj) {
            Element elem = (Element) obj;

            return elem.num == this.num;
        }

        public int hashCode() {
            return this.num;
        }


    }

    public static void main(String[] args) {
        new DegreeOfArray().findShortestSubArray(new int[]{1,3,2,2,3,1});
    }

    public int findShortestSubArray(int[] nums) {

        PriorityQueue<Element> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (a.endIndex - a.startIndex + 1)));

        Map<Integer,Integer> endIndex = new HashMap<>();
        Map<Integer,Integer> freqMap = new HashMap<>();
        Set<Integer> hashSet = new HashSet<>();
        int max = 0;
        Set<Integer> maxNumbers = new HashSet<>();

        for(int i = 0; i < nums.length; i++ ) {

            freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0) + 1);
            endIndex.put(nums[i],i);

            if(freqMap.get(nums[i]) > max ){
                max = freqMap.get(nums[i]);
            }

        }

        for(int i = 0 ; i < nums.length; i++ ) {

            if(!hashSet.contains(nums[i])) {
                Element elem = new Element(nums[i], i, endIndex.get(nums[i]));
                queue.add(elem);
                hashSet.add(nums[i]);
            }

            if(freqMap.get(nums[i]) == max ) maxNumbers.add(nums[i]);

        }

        int minWindow = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {

            Element elem = queue.poll();

            for(int maxNumber : maxNumbers ) {
                if (elem.num == maxNumber) {
                    minWindow = Math.min(minWindow, (elem.endIndex - elem.startIndex + 1));
                    break;
                }
            }
        }

        return minWindow;

    }
}
