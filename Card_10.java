package hw4_q3;

public class Card_10 extends ActionCard{
    public Card_10(String color){
        super(10,color);
    }

    @Override
    public Actions_enum action(){
        return Actions_enum.CARD_10;
    }
}
