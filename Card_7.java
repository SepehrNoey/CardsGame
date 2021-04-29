package hw4_q3;
/**
 * a subclass of ActionCards , which its actions are implemented in Controller class
 */
public class Card_7 extends ActionCard {
    public Card_7(String color , cards_type_enum type){
        super(color.equals("yellow") ? 15 : 10 , color , type);
    }
    /**
     * the action of card
     * @return Type of card
     */
    @Override
    public cards_type_enum action() {
        return  getColor().equals("yellow") ? cards_type_enum.CARD_7_YE : cards_type_enum.CARD_7;
    }
}
