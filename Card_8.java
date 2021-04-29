package hw4_q3;

public class Card_8 extends ActionCard{
    public Card_8(String color , cards_type_enum type){
        super(8, color , type);
    }

    @Override
    public cards_type_enum action(){
        return cards_type_enum.CARD_8;
    }
}
