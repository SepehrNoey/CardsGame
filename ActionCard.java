package hw4_q3;

/**
 * this type of cards , affect score , other
 * players' turn and some more according to their type.
 *
 * this class is made just for classifying types of cards
 * abstract class with shared members
 */
public abstract class ActionCard extends Card {
    public ActionCard(int score , String color , cards_type_enum type){
        super(score , true , color , type);
    }

    /**
     * the action of card
     * @return Type of card
     */
    public abstract cards_type_enum action();

}
