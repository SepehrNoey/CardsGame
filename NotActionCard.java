package hw4_q3;

/**
 * NotActionCards are cards which using them in game
 * doesn't make any change except the score change of player
 *
 * these cards don't do any special action
 */
public class NotActionCard extends Card {
    public NotActionCard(int score , String color , cards_type_enum type){
        super(score , false  , color ,type);
    }

    /**
     * these cards don't do any special action
     * @return the type of card
     */
    @Override
    public cards_type_enum action() {    // i should change it for all classes
        // nothing
        return getType();
    }
}
