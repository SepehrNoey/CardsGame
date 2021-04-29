package hw4_q3;

public class Card_2 extends ActionCard {
    public Card_2(String color , cards_type_enum type){
        super(2 , color , type);
    }

    @Override
    public cards_type_enum action(){
        return cards_type_enum.CARD_2;
    }

}
