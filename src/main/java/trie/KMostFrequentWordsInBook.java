package trie;


import java.util.*;

public class KMostFrequentWordsInBook {

    public static void main(String[] args) {


        KMostFrequentWordsInBook kMostFrequentWordsInBook = new KMostFrequentWordsInBook();

        List<String> words = Arrays.asList("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is");
        List<String> words1 = Arrays.asList("the", "the");




        kMostFrequentWordsInBook.kTopValue(words, 4);


    }

    private List<String> kTopValue(List<String> words, int k) {

        Map<String,Integer> hashMap = new HashMap<>();

        for(String word : words) {

            if(!hashMap.containsKey(word)) {
                hashMap.put(word,1);
            } else {
                int count = hashMap.get(word);
                hashMap.put(word, ++count);
            }

        }

        PriorityQueue<Map.Entry<String,Integer>> queue = new
                PriorityQueue<>((o1, o2)
                ->
                o1.getValue().equals(o2.getValue())
                        ? o1.getKey().compareTo(o2.getKey()) : o1.getValue() - o2.getValue());

        for(Map.Entry<String,Integer> entry : hashMap.entrySet()) {

            queue.add(entry);

            if(queue.size() > k ) {
                queue.remove();
            }

        }

        List<String> result = new LinkedList<>();


        while (!queue.isEmpty()) {

            result.add(0, queue.remove().getKey());
        }

        return result;

    }


}
