package companies.microsoft;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {

        new WordLadder().ladderLength("hit","cog",Arrays.asList("hot","dot","dog","lot","log","cog"));
    }

    class Word implements Cloneable {

        Map<Character,Integer> countMap = new HashMap<>();

        boolean isVisited = false;
        String word;
        public Word(String word){
            this.word = word;
        }

        public Map<Character,Integer> getCountMap() {
            return countMap;
        }

        @Override
        public Object clone() {
            try {
                return (Word) super.clone();
            } catch (CloneNotSupportedException e) {
                return new Word(this.word);
            }
        }
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        if(!wordList.contains(endWord)) return 0;
        Queue<Word> queue = new LinkedList<>();

        Word beginWordClass = new Word(beginWord);
        Map<Character,Integer> countMap = beginWordClass.getCountMap();
        for(int i = 0 ; i < beginWord.length(); i++ ) {

            countMap.put(beginWord.charAt(i),countMap.getOrDefault(beginWord.charAt(i),0) + 1);
        }

        for(String currentWord : wordList ) {
            Word currentWordClass = new Word(currentWord);
            Map<Character,Integer> currentWordCountMap = currentWordClass.getCountMap();
            for(int i = 0 ; i < currentWord.length(); i++ ) {

                currentWordCountMap.put(currentWord.charAt(i),currentWordCountMap.getOrDefault(currentWord.charAt(i),0) + 1);

            }
            queue.add(currentWordClass);
        }


        int traversal = 0 ;
        while(!queue.isEmpty()) {

            Word queueWord = queue.poll();

            Map<Character,Integer> queueCountMap = queueWord.getCountMap();
            Map<Character,Integer> beginWordCountMap = beginWordClass.getCountMap();
            int count = 0;
            for(Map.Entry<Character,Integer> entry : beginWordCountMap.entrySet()) {

                if(queueCountMap.containsKey(entry.getKey())) {
                    count += queueCountMap.get(entry.getKey());
                }
            }

            if( endWord.equalsIgnoreCase(beginWordClass.word)) {
                return traversal;
            } else if(count == beginWord.length() - 1 ) {
                beginWordClass = (Word) queueWord.clone();
                queueWord.isVisited = true;
                traversal++;
            } else {
                System.out.println("the value of count i s" + count);
                if(!queueWord.isVisited) {
                    queue.add(queueWord);
                }
            }

        }
        return traversal;
    }
}
