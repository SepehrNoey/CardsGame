package hw4_q3;

public class Card_A extends ActionCard{
    public Card_A(String color , cards_type_enum type){
        super(11,color , type);
    }

    @Override
    public cards_type_enum action(){
        return cards_type_enum.CARD_A;
    }
}
