package hw4_q3;

public class Card_A extends ActionCard{
    public Card_A(String color){
        super(11,color);
    }

    @Override
    public Actions_enum action(){
        return Actions_enum.CARD_A;
    }
}
