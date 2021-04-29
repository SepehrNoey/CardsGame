package hw4_q3;

import java.util.ArrayList;

public class Printable {
    private ArrayList<Card> handCards;
    private ArrayList<Card> remainingCards;

    public Printable(){
        handCards = null;
        remainingCards = null;
    }

    public void showHand_And_Top(ArrayList<Card> handCards , Card onTop){
        this.handCards = handCards;
        System.out.println("The upper card is: " + onTop.getType() + "\tColor: " + onTop.getColor());
        showCards();
        

    }
    private void showCards() {
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
                        System.out.print("2");
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
        System.out.print("\u001B[0m");  // reset default color
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
        System.out.println("Rotation: " + rot + "\tTurn: " + turn.getName());
        System.out.print("\u001B[0m"); // reset color
    }
}
