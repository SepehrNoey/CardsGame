package hw4_q3;

public abstract class Card {
    // what kind of card it is
    private String type;
    // score of the card
    private int score;
    // to identify special cards(it can be identified by other things but , I choose this to iterate faster between special cards)
    private boolean isSpecial;
    // the color of the card
    private String color;

    /**
     * constructor
     * @param type is the type of the card
     * @param score is the score of the card
     * @param isSpecial identifies if the card is special , or not
     * @param color is the color of card
     */
    public Card(String type, int score , boolean isSpecial , String color){
        this.type = type;
        this.score = score;
        this.isSpecial = isSpecial;
        this.color = color;

    }

    /**
     * a method to do special actions on process of game if the card has actions
     */
    public abstract void action();

}
