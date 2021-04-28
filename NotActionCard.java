package hw4_q3;

/**
 * NotActionCards are cards which using them in game
 * doesn't make any change except the score change of player
 *
 * these cards don't do any special action
 */
public class NotActionCard extends Card {
    public NotActionCard(int score , String color){
        super(score , false  , color);
    }

    /**
     * these cards don't do any special action
     * @return the type of card
     */
    @Override
    public Actions_enum action() {
        // nothing
        return Actions_enum.NO_ACTION;
    }
}
