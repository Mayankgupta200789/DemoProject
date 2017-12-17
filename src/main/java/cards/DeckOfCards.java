package cards;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Mayank Gupta
 * @Date 9/8/17
 */
public class DeckOfCards {

    private List<Card> cards = new LinkedList<>();


    public DeckOfCards() {
        FaceValue[] values = FaceValue.values();

        for(FaceValue faceValue : values ) {

            ClubCard clubCard = new ClubCard(faceValue);
            DiamondCard diamondCard = new DiamondCard(faceValue);
            SpadeCard spadeCard = new SpadeCard(faceValue);
            HeartCard heartCard = new HeartCard(faceValue);

            cards.add(clubCard);
            cards.add(diamondCard);
            cards.add(spadeCard);
            cards.add(heartCard);
        }
    }

    public void shuffle() {

        //Collections.shuffle(cards);

        for(int i = 0; i < cards.size();i++ ) {
            int random = (int) (Math.random() % cards.size());
            Card randomCard = cards.get(random);
            Card card = cards.get(i);
            cards.add(i,randomCard);
            cards.add(random,card);
        }
    }
}
