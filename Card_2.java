package hw4_q3;

public class Card_2 extends ActionCard {
    public Card_2(String color){
        super(2 , color);
    }

    @Override
    public Actions_enum action(){
        return Actions_enum.CARD_2;
    }

}
