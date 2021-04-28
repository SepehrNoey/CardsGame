package hw4_q3;

public class Card_7 extends ActionCard {
    public Card_7(String color){
        super(color.equals("black") ? 15 : 10 , color);
    }

    @Override
    public Actions_enum action() {
        return  getColor().equals("black") ? Actions_enum.CARD_7_BL: Actions_enum.CARD_7;
    }
}
