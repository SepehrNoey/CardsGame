package hw4_q3;

public class Card_B extends ActionCard{
    public Card_B(String color){
        super(12,color);
    }

    @Override
    public Actions_enum action(){
        return Actions_enum.CARD_B;
    }
}
