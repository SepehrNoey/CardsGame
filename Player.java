package hw4_q3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * a class to make player and store its data
 */
public class Player {
    private final String name;
    private ArrayList<Card> myCards;
    private int myScore;
    private final int humanOrBot;  // 0 is bot , 1 is human player

    public Player(String name, int humanOrBot) {
        this.name = name;
        myCards = new ArrayList<>();
        myScore = 0;
        this.humanOrBot = humanOrBot;
    }

    public int getMyScore() {
        return myScore;
    }

    /**
     * to identify if it is bot
     * @return 0 if it's bot , 1 if is human
     */
    public int getHumanOrBot() {
        return humanOrBot;
    }

    /**
     * to access cards of a player
     *
     * @return cards of this player
     */
    public ArrayList<Card> getMyCards() {
        return myCards;
    }

    /**
     * a method to pick a cards from the list of player's hand or from remaining cards
     * @param onTopCards the cards which have been used before
     * @param remainingCards are the cards which haven't been used
     *                       before and if player doesn't have valid card in
     *                       his hand , then can take one from this list
     * @return the picked card , or null if hasn't been taken
     */
    public Card pick(ArrayList<Card> onTopCards, ArrayList<Card> remainingCards , int must_take , String is_color_determined) {
        ArrayList<Card> validCards = new ArrayList<>();  // all valid cards

        // this part is for both human and bot


        // the following variables are made to make intelligently decisions by bot
        Card validActionCard = null;  // special(action) card which is valid and also has max score
        Card validMaxScoreCard = null; // valid card with the most score , but not special
        Card card_7 = null;  // it is used to check if this player has 7 or not

        // getting valid cards
        for (Card fromList : myCards) {
            if (isValid(fromList, onTopCards , is_color_determined))
                validCards.add(fromList);
        }

        int maxScore = 0;
        for (Card fromList : validCards)
        {
            if (fromList.isSpecial() && fromList.getScore() >= maxScore) {  //special most score
                validActionCard = fromList;
                maxScore = fromList.getScore();
                if (fromList.getType() == cards_type_enum.CARD_7 || fromList.getType() == cards_type_enum.CARD_7_YE)
                    card_7 = fromList;
            }
            else if (!fromList.isSpecial() && fromList.getScore() >= maxScore) {// not special most score
                validMaxScoreCard = fromList;
                maxScore = fromList.getScore();
            }
        }
        if (must_take > 0 && card_7 == null)
        {
            if (humanOrBot == 1)
                System.out.println("No 7_CARD to choose.I give you " + must_take + "random cards: ");
            Random random = new Random();
            for (int i = 0 ; i < must_take ; i++)
            {
                int rand = random.nextInt(remainingCards.size());
                myCards.add(remainingCards.get(rand));
                remainingCards.remove(rand);
            }
        }



        if (validCards.size() == 0)
        {
            if (humanOrBot == 1)
                System.out.println("No valid cards in hands! Take from repository: ");
            Card fromRepo = remainingCards.get(0);
            if (isValid(fromRepo, onTopCards, is_color_determined))
            {
                return fromRepo;
            }
            else{
                myCards.add(fromRepo); // player should take the card
                remainingCards.remove(fromRepo);
                return null; // next player turn
            }
        }

        // now this part just belongs to bot

        // now choosing card for bot
        if (humanOrBot == 0) // it's bot
        {
            if(onTopCards.get(0).getType() == cards_type_enum.CARD_7 || onTopCards.get(0).getType() == cards_type_enum.CARD_7_YE)
            {
                return card_7;  // card 7 is picked when on top card is 7 , if we dont have , then null returns
            }
            if (validActionCard != null) {
                myCards.remove(validActionCard);
                return validActionCard;
            }
            else {
                myCards.remove(validMaxScoreCard);
                return validMaxScoreCard;
            }
        }

        // this part is just for human

        else {  // human
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Choose one card by index:(index begins from 0!)");
                int choice = scanner.nextInt();
                // now checking validity
                if (choice >= myCards.size() || choice < 0 || !isValid(myCards.get(choice) , onTopCards, is_color_determined))
                    System.out.println("Invalid input.Try Again.");
                else if (isValid(myCards.get(choice) , onTopCards , is_color_determined))
                {
                    Card temp = myCards.get(choice);
                    myCards.remove(choice);
                    return temp;
                }
            }
        }
    }

    /**
     * checks validity of the input
     * @param forCheck the card to check
     * @param onTopCards the cards which have been used before
     * @return true if the card is valid , false if not
     */
    public boolean isValid(Card forCheck, ArrayList<Card> onTopCards , String is_color_determined) {
        if (onTopCards.get(0).getType() == cards_type_enum.CARD_7 || onTopCards.get(0).getType() == cards_type_enum.CARD_7_YE) {  //special comparing for 7 and 7_yellow
            return forCheck.getType() == cards_type_enum.CARD_7 || forCheck.getType() == cards_type_enum.CARD_7_YE;
        }
        if (forCheck.getType() == cards_type_enum.CARD_B) // Card_B (Soldier is always valid)
            return true;
        if (is_color_determined != null)
        {
            if (forCheck.getColor().equals(is_color_determined))
                return true;
        }
        if (forCheck.getColor().equals(onTopCards.get(0).getColor()))
            return true;
        return forCheck.getType() == onTopCards.get(0).getType();
    }

    /**
     * to access name
     * @return name of the player
     */
    public String getName() {
        return name;
    }
}
