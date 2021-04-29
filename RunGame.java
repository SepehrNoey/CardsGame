package hw4_q3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * this class has to make some instances and
 * use other classes , runs a single set of game
 */
public class RunGame {
    public static void main(String[] args){
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Card> allCards = null;
        int humanNum = 0;
        int botNum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to CARDS_GAME!");
        while (true)
        {
            System.out.println("Please enter the number of human players: ");
            humanNum = scanner.nextInt();
            System.out.println("Please enter the number of bot players: ");
            botNum = scanner.nextInt();
            if (botNum >= 0 && humanNum >= 0 && (botNum + humanNum) >= 3  && (botNum + humanNum) <= 5)
                break;
            System.out.println("Invalid input.Try Again.");
        }

        String[] humanNames = null;
        String[] botNames = null;

        // getting name of human players
        if (humanNum > 0)
        {
            humanNames = new String[humanNum];
            for (int i = 0; i < humanNum; i++)
            {
                System.out.println("Please enter the name of " + (i + 1) + "-th human player: ");
                humanNames[i] = scanner.nextLine().trim();
                players.add(new Player(humanNames[i] , 1));

            }
        }

        // setting name of bot players
        if (botNum > 0) {
            botNames = new String[botNum];
            for (int i = 0; i < botNum; i++)
            {
                botNames[i] = "Bot " + (i + 1) + "-th";
                players.add(new Player(botNames[i] , 0));
            }
        }

        // now starting the game:

        // making cards and giving them to players
        Controller controller = new Controller(players.toArray(new Player[players.size()]));
        allCards = controller.createAllCards();
        controller.giveCards(allCards);

    }


}
