package hw4_q3;

import java.util.*;

/**
 * controls the process of game with the given players
 * it should do things like : whose turn it is , managing actions of special cards,
 * when the game ends , and many like this
 *
 * in other words , this class manages the rules of the game
 */
public class Controller {
    private LinkedList<Player> players;
    private Player turn;
    private int rotation; // 0 is clockwise , 1 is anticlockwise

    /**
     * constructor
     * @param inputPlayers are the players of the game
     */
    public Controller(Player... inputPlayers){
        players = new LinkedList<>();
        players.addAll(Arrays.asList(inputPlayers));
        Random random = new Random();
        turn = players.get(random.nextInt(players.size()));
        rotation = 0;
    }

    /**
     * a method to generate 13 different card of each color and pass them all
     * @return list of all cards
     */
    public ArrayList<Card> createAllCards(){
        ArrayList<Card> allCards = new ArrayList<>();
        String[] colors = new String[]{"yellow", "red" , "blue" , "green"};
        for (String color:colors)
        {
            // not action cards adding
            allCards.add(new NotActionCard(3 , color ,cards_type_enum.CARD_3 ));
            allCards.add(new NotActionCard(4,color , cards_type_enum.CARD_4));
            allCards.add(new NotActionCard(5,color , cards_type_enum.CARD_5));
            allCards.add(new NotActionCard(6,color , cards_type_enum.CARD_6));
            allCards.add(new NotActionCard(9,color ,cards_type_enum.CARD_9));
            allCards.add(new NotActionCard(12,color , cards_type_enum.CARD_C));
            allCards.add(new NotActionCard( 13,color ,cards_type_enum.CARD_D));

            // action cards adding
            allCards.add(new Card_2(color,cards_type_enum.CARD_2));
            if (color.equals("yellow"))
                allCards.add(new Card_7(color,cards_type_enum.CARD_7_YE));
            else
                allCards.add(new Card_7(color,cards_type_enum.CARD_7));
            allCards.add(new Card_8(color,cards_type_enum.CARD_8));
            allCards.add(new Card_10(color , cards_type_enum.CARD_10));
            allCards.add(new Card_A(color , cards_type_enum.CARD_A));
            allCards.add(new Card_B(color , cards_type_enum.CARD_B));
        }
        return allCards;
    }

    /**
     * a method to give seven card to each player and
     * remove these cards from the list of all cards
     * @param allCards is the list of all cards
     */
    public void giveCards(ArrayList<Card> allCards){
        int remainingCards = 52;
        for (Player player:players)
        {
            ArrayList<Card> playerCards = player.getMyCards();
            for (int i = 0 ; i < 7; i++)
            {
                Random random_generator = new Random();
                int rand = random_generator.nextInt(remainingCards);
                playerCards.add(allCards.get(rand));
                remainingCards--;
                allCards.remove(rand);
            }
        }
    }

    public void play(ArrayList<Card> allCards){
        Random random = new Random();
        ArrayList<Card> onTopCards = new ArrayList<>();

        // creating onTop card for the first time
        while (true){
            onTopCards.add(allCards.get(random.nextInt(allCards.size())));
            if (!onTopCards.get(0).isSpecial())
            {
                allCards.remove(onTopCards.get(0));
                break;
            }
            else
                onTopCards.remove(0);
        }


        ArrayList<Card> remainingCards = new ArrayList<>(allCards);
        turn = players.get(random.nextInt(players.size()));
        Printable printable = new Printable();
        int must_take = 0;  // it means the cards which should be taken from remaining cards when last player has picked 7 or 7 yellow.
        String is_color_determined = null;  // when a player picks CARD_B , the color will be determined for next round
        int turn_maker = players.indexOf(turn);


        while (true)
        {
            for (Player player : players)
            {
                if (player.getMyCards().size() == 0)
                    return;
            }
            // the game isn't finished yet
            ListIterator<Player> itr = players.listIterator();

            //showing cards
            printable.show_Turn_And_Rotation(rotation , turn);
            printable.showHand_And_Top(turn.getMyCards() , onTopCards.get(0)); // all new cards will be added to the head of the list

            // player picks a card to play
            Card picked = turn.pick(onTopCards , remainingCards , must_take , is_color_determined);


            // managing actions
            if (picked == null) // no card is put
            {
                must_take = 0; // the additional card have been taken
            }
            if (picked != null)
                onTopCards.add(0,picked);
            if (picked instanceof Card_2)
            {
                while (true)
                {
                    System.out.println("You put CARD_2. Enter the index of a player to give card:(starts from zero) ");
                    Scanner scanner = new Scanner(System.in);
                    int idx = scanner.nextInt();
                    if (idx == turn_maker || idx < 0 || idx >= players.size())
                        System.out.println("Invalid input. Try again.");
                    else
                    {
                        int cardIdx = random.nextInt(turn.getMyCards().size());
                        System.out.println(turn.getMyCards().get(cardIdx).getType() + "\tColor: " + turn.getMyCards().get(cardIdx).getColor() + "\tchose for giving.");
                        players.get(idx).getMyCards().add(turn.getMyCards().get(cardIdx));
                        turn.getMyCards().remove(cardIdx);
                        break;
                    }
                }
            }
            else if (picked instanceof Card_7)
            {
                must_take += picked.getColor().equals("yellow") ? 4 : 2;
                System.out.println("Next player should take " + must_take + " cards.");
            }
            else if (picked instanceof Card_8)
            {
                turn_maker += rotation == 0 ? -1 : 1;
                System.out.println("Card_8 is picked. Put one more card.");
            }
            else if (picked instanceof Card_10)
            {
                rotation = rotation == 0 ? 1 : 0;
            }
            else if (picked instanceof Card_A)
            {
                turn_maker += rotation == 0 ? 1 : -1;
                System.out.println("Card_A is picked. Next player won't play this time.");
            }
            else if (picked instanceof Card_B)
            {
                String[] colors = new String[]{"yellow" , "red" , "blue" , "green"};
                if (turn.getHumanOrBot() == 0)
                {
                    is_color_determined = colors[random.nextInt(4)];
                }
                else
                {
                    while (true) {
                        System.out.println("""
                                Card_B is picked. What color do you want to be played in next round?
                                Enter the number:
                                1) yellow\t2) red\t3) blue\t4) green\s""");
                        Scanner scanner = new Scanner(System.in);
                        int choice = scanner.nextInt();
                        if (choice >= 1 && choice <= 4)
                        {
                            is_color_determined = colors[choice - 1];
                            return;
                        }
                        System.out.println("Invalid input. Try again.");
                    }
                }
                System.out.println( "Next round will be in "+ is_color_determined + " color." );
            }
            turn_maker += rotation == 0 ? 1 : -1; // 0 is clockwise , 1 is anticlockwise

            // if remainder is positive , it's ok , but if it's negative , size + (negative value) determines the turn
            turn = players.get(turn_maker % players.size() >= 0 ? turn_maker % players.size() : players.size() + turn_maker % players.size());

            // adding the card before last card to remaining cards
            remainingCards.add(onTopCards.get(onTopCards.size() - 1));
            onTopCards.remove(onTopCards.size() - 1);



        }

    }

}
