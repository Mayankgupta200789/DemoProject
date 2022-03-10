package companies.microsoft.onsite.oops.card;

/**
 * @Author Mayank Gupta
 * @Date 9/8/17
 */
public class HeartCard implements Card {

    private FaceValue faceValue;

    private Suit suit = Suit.HEART;


    public HeartCard(FaceValue faceValue) {
        this.faceValue = faceValue;
    }

    @Override
    public FaceValue getFaceValue() {
        return faceValue;
    }

    @Override
    public Suit getSuit() {
        return suit;
    }
}
