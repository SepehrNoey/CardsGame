package hw4_q3;

import java.util.ArrayList;

public class Printable {

    public Printable(){

    }

    public void showTop(Card onTop){
        setColor(onTop);
        System.out.println("The upper card is: " + onTop.getType() + "\tColor: " + onTop.getColor());
        System.out.print("\u001B[0m"); // reset color
        showOneCard(onTop);

    }

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

    public void show_Turn_And_Rotation(int rotation , Player turn){
        System.out.print("\u001B[36m");
        String rot = rotation == 0 ? "Clockwise" : "Anticlockwise";
        System.out.println("Rotation: " + rot + "\t\tTurn: " + turn.getName());
        System.out.print("\u001B[0m"); // reset color
    }

    public static void printResult(ArrayList<Player> players){
        for (int i = 0 ; i < players.size() ; i++)
        {
            for (int j = i ; j < players.size() ; j++)
            {
                if (players.get(j).getMyScore() < players.get(i).getMyScore())
                {
                    Player temp = players.get(i);
                    players.remove(i);
                    players.add(i , players.get(j));
                    players.remove(j);
                    players.add(j , temp);
                }
            }
        }
        int k = 0;
        System.out.print("\u001B[36m");
        System.out.println("\nPlayer " + players.get(0).getName() + " won!\nNow , Results: ");
        System.out.print("\u001B[0m");
        for(Player player : players)
        {
            k++;
            System.out.println(k + ") Name: " + player.getName() + "\tScore: " + player.getMyScore());
        }

    }
}
