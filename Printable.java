package hw4_q3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Printable {

    // no fields , has default constructor

    /**
     * it shows the upper card , it is a bit different from showOneCard ,
     * it exactly is called when printing the top card is needed
     * @param onTop is the onTop card
     */
    public void showTop(Card onTop){
        setColor(onTop);
        System.out.println("The upper card is: " + onTop.getType() + "\tColor: " + onTop.getColor());
        System.out.print("\u001B[0m"); // reset color
        showOneCard(onTop);

    }

    /**
     * it just prints the entered card
     * @param card is the card to print
     */
    public void showOneCard(Card card){
        setColor(card);
        for (int j = 0 ; j < 12 ; j++)
        {
            System.out.print("-");
        }
        System.out.println();
        for (int j = 0 ; j < 8 ; j++)
        {
            System.out.print("|");
            for (int i = 0; i < 10; i++) {
                if ((i == 1 && j == 1) || (i == 8 && j == 6))
                    System.out.print(card.getType());
                else if (card.getType() == cards_type_enum.CARD_10 && ((i == 5 &&  j == 1) || (i == 5 && j == 6)))
                {
                    System.out.print(""); // print nothing
                }
                else
                    System.out.print(" ");
            }
            System.out.println("|");
        }
        for (int j = 0 ; j < 12 ; j++)
        {
            System.out.print("-");
        }
        System.out.println("\u001B[0m"); // reset color
    }

    /**
     * it prints all cards in hand in an algorithm similar to showOneCard algorithm,
     * but with the difference that all cards are shown here.
     * @param handCards is all the cards to print
     */
    public void showCards(ArrayList<Card> handCards) {
        System.out.print("\u001B[31m");
        System.out.println("\nYour cards are listed: ");
        System.out.print("\u001B[0m"); // reset color

        for (int z = 0; z < handCards.size() ; z++) {
            setColor(handCards.get(z));

            for (int j = 0; j < 12 ; j++)
            {
                System.out.print("-");
            }
        }
        for (int j = 0 ; j < 8 ; j++)
        {
            System.out.println();
            for (int z = 0; z < handCards.size(); z++) {
                setColor(handCards.get(z));
                System.out.print("|");
                for (int i = 0; i < 10; i++) {
                    if ((i == 1 && j == 1) || (i == 8 && j == 6))
                        System.out.print(handCards.get(z).getType());
                    else if (handCards.get(z).getType() == cards_type_enum.CARD_10 && ((i == 5 &&  j == 1) || (i == 5 && j == 6)))
                    {
                        System.out.print("");
                    }
                    else
                        System.out.print(" ");
                }
                System.out.print("|");
            }
        }
        System.out.println();
        for (int z = 0; z < handCards.size(); z++) {
            setColor(handCards.get(z));
            for (int j = 0; j < 12; j++)
            {
                System.out.print("-");
            }
        }
        System.out.println("\u001B[0m");  // reset default color
    }

    /**
     * changes the color of printable things
     * @param card is the card which is used to access card's color
     */
    public void setColor(Card card){
        if (card.getColor().equals("red"))
            System.out.print("\u001B[31m");
        else if (card.getColor().equals("yellow"))
            System.out.print("\u001B[33m");
        else if (card.getColor().equals("blue"))
            System.out.print("\u001B[34m");
        else if (card.getColor().equals("green"))
            System.out.print("\u001B[32m");

    }

    /**
     * a simple method to print the data of turn
     * @param rotation it can be clockwise or anticlockwise
     * @param turn is the player whose turn is
     */
    public void show_Turn_And_Rotation(int rotation , Player turn){
        System.out.print("\u001B[36m");
        String rot = rotation == 0 ? "Clockwise" : "Anticlockwise";
        System.out.println("Rotation: " + rot + "\t\tTurn: " + turn.getName());
        System.out.print("\u001B[0m"); // reset color
    }

    /**
     * it is called when the game ends to print results
     * @param players are players
     */
    public static void printResult(ArrayList<Player> players){
        Collections.sort(players);
        int k = 0;
        System.out.print("\u001B[36m");
        System.out.println("\nPlayer " + players.get(0).getName() + " won!\nNow , Results: ");
        System.out.print("\u001B[0m");

        for(int i = players.size() - 1 ; i >= 0 ; i--)
        {
            System.out.println(k + ") Name: " + players.get(i).getName() + "\tScore: " + players.get(i).getMyScore());
        }
    }

}
