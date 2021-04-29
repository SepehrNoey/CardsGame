package hw4_q3;

/**
 * a subclass of ActionCards , which its actions are implemented in Controller class
 */
public class Card_10 extends ActionCard{
    public Card_10(String color , cards_type_enum type){
        super(10,color ,type);
    }

    /**
     * the action of card
     * @return Type of card
     */
    @Override
    public cards_type_enum action(){
        return cards_type_enum.CARD_10;
    }
}
