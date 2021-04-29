package hw4_q3;

public class Card_10 extends ActionCard{
    public Card_10(String color , cards_type_enum type){
        super(10,color ,type);
    }

    @Override
    public cards_type_enum action(){
        return cards_type_enum.CARD_10;
    }
}
