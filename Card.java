package hw4_q3;

/**
 * an abstract class which contains the shared members of all types of cards
 */
public abstract class Card {
    // what kind of card it is (for example : B , A , 2 , ...)
    private cards_type_enum type;
    // score of the card
    private int score;
    // to identify special cards(it can be identified by other things but , I choose this to iterate faster between special cards)
    private boolean isSpecial;
    // the color of the card
    private String color;

    /**
     * constructor
     * @param score is the score of the card
     * @param isSpecial identifies if the card is special , or not
     * @param color is the color of card
     */
    public Card( int score , boolean isSpecial , String color , cards_type_enum type){
        this.score = score;
        this.isSpecial = isSpecial;
        this.color = color;
        this.type = type;

    }

    /**
     * a method to do special actions on process of game if the card has actions
     * @return enum which would be one of the types listed in cards_type_enum
     */
    public abstract cards_type_enum action();

    /**
     * to access color
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * to access score of card
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * to access type of card
     * @return type of card
     */
    public cards_type_enum getType() {
        return type;
    }

    /**
     * to identify if the card is special or not
     * @return true , if is special , false if it's not special
     */
    public boolean isSpecial() {
        return isSpecial;
    }
}
