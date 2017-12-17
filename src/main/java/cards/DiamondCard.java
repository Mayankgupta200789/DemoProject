package cards;

/**
 * @Author Mayank Gupta
 * @Date 9/8/17
 */
public class DiamondCard implements Card{

    private FaceValue faceValue;

    private Suit suit = Suit.DIAMOND;


    public DiamondCard(FaceValue faceValue) {
        this.faceValue = faceValue;
    }

    @Override
    public Suit getSuit() {
        return suit;
    }

    @Override
    public FaceValue getFaceValue() {
        return faceValue;
    }
}
