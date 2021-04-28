package hw4_q3;

/**
 * this type of cards , affect score , other
 * players' turn and some more according to their type.
 *
 * this class is made just for classifying types of cards
 * abstract class with shared members
 */
public abstract class ActionCard extends Card {
    public ActionCard(int score , String color){
        super(score , true , color);
    }

    public abstract Actions_enum action();

}
