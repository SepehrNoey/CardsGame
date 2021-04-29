package hw4_q3;

public class Card_B extends ActionCard{
    public Card_B(String color , cards_type_enum type){
        super(12,color , type);
    }

    @Override
    public cards_type_enum action(){
        return cards_type_enum.CARD_B;
    }
}
