package cards;

/**
 * @Author Mayank Gupta
 * @Date 9/8/17
 */
public class ClubCard implements Card {


    private FaceValue faceValue;

    private Suit suit = Suit.CLUB;

    public ClubCard(FaceValue faceValue) {
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
