package hw4_q3;

public class Card_8 extends ActionCard{
    public Card_8(String color){
        super(8, color);
    }

    @Override
    public Actions_enum action(){
        return Actions_enum.CARD_8;
    }
}
