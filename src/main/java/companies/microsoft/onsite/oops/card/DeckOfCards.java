package companies.microsoft.onsite.oops.card;

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

            Card clubCard = new ClubCard(faceValue);
            Card diamondCard = new DiamondCard(faceValue);
            Card spadeCard = new SpadeCard(faceValue);
            Card heartCard = new HeartCard(faceValue);

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
