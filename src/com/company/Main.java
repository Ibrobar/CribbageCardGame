package com.company;


import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int z = 0;
        int y = 0;

        CardValue h = new CardValue(z,y);


        Hand general = new Hand();
        Hand P1 = new Hand();
        Hand P2 = new Hand();
        Hand P3 = new Hand();


        boolean check = true;
        P1.createHand();
        P2.createHand();
        P3.createHand();





        while (P1.score < 121 && P2.score < 121 && P3.score < 121 )
        {
            System.out.println("Player 1 Hand: ");
            P1.printHand();
            System.out.println("Player 2 Hand: ");
            P2.printHand();
            System.out.println("Player 3 Hand: ");
            P3.printHand();

            System.out.println("This is the starter card: " + general.Start.getRank() + " " + general.Start.getSuit());

            int x = h.randomNumberGenerator(1,4);


            if (x == 1)
            {
                System.out.println("Player 1 is the Dealer");
                general.checkStarterCard(P1);
            }else if (x == 2)
            {
                System.out.println("Player 2 is the Dealer");
                general.checkStarterCard(P2);
            }else if (x == 3)
            {
                System.out.println("Player 3 is the Dealer");
                general.checkStarterCard(P3);
            }

            Scanner obj = new Scanner(System.in);
            general.addRandomToCrib();

            System.out.println("Player 1 please pick one card to add to the crib: ");
            int playCard = obj.nextInt();
            P1.crib.add(P1.hand.get(playCard));
            P1.hand.remove(playCard);

            System.out.println("Player 2 please pick one card to add to the crib: ");
            playCard = obj.nextInt();
            P2.crib.add(P2.hand.get(playCard));
            P2.hand.remove(playCard);

            System.out.println("Player 3 please pick one card to add to the crib: ");
            playCard = obj.nextInt();
            P3.crib.add(P3.hand.get(playCard));
            P3.hand.remove(playCard);

            //general.printCrib();
            System.out.println();
            System.out.println("Player 1 Hand: ");
            P1.printHand();
            System.out.println();

            System.out.println("Player 2 Hand: ");
            P2.printHand();
            System.out.println();

            System.out.println("Player 3 Hand: ");
            P3.printHand();

            while (general.checkScore() < 31 )
            {
                check = true;
                boolean check1 =true;
                boolean endTurn = false;

                while (check1 && !endTurn)
                {

                    if (!P1.checkPossible(P1, general.checkScore()))
                    {
                        check1 = false;
                        break;
                    }
                    System.out.println();
                    System.out.println("Player 1 Hand: ");
                    P1.printHand();
                    System.out.println();
                    System.out.println("Play score: " + general.checkScore());
                    general.printPlay();
                    System.out.println("Player 1 please pick one card to add to play: ");
                    playCard = obj.nextInt();
                    P1.play.add(P1.hand.get(playCard));
                    if (general.checkScore() == 31)
                    {
                        break;
                    }
                    else if (general.checkScore() < 31)
                    {
                        check = false;
                    }

                    while (check)
                    {

                        P1.play.remove(P1.hand.get(playCard));
                        System.out.println("please play a different card: ");
                        playCard = obj.nextInt();
                        P1.play.add(P1.hand.get(playCard));

                        if (general.checkScore() == 31)
                        {
                            break;
                        }
                        else if (general.checkScore() < 31)
                        {
                            check = false;
                        }

                    }


                    endTurn = true;
                }

                P1.score += P1.checkPlay(P1);
                P1.hand.remove(playCard);
                System.out.println();
                System.out.println("Player 1's Total Score: " + P1.score);
                System.out.println();
                System.out.println("Score of play: " + general.checkScore());


                System.out.println();
                System.out.println("Player 2 Hand: ");
                P2.printHand();
                System.out.println();


                if (general.checkScore() == 31)
                {
                    break;
                }
                check1 =true;
                endTurn = false;

                while (check1 && !endTurn)
                {

                    if (!P2.checkPossible(P2, general.checkScore()))
                    {
                        check1 = false;
                        break;
                    }

                    check = true;
                    general.printPlay();
                    System.out.println("Player 2 please pick one card to add to play: ");
                    playCard = obj.nextInt();
                    P2.play.add(P2.hand.get(playCard));
                    if (general.checkScore() == 31)
                    {
                        break;
                    }
                    else if (general.checkScore() < 31)
                    {
                        check = false;
                    }

                    while (check)
                    {
                        P2.play.remove(P2.hand.get(playCard));
                        System.out.println("please play a different card: ");
                        playCard = obj.nextInt();
                        P2.play.add(P2.hand.get(playCard));

                        if (general.checkScore() == 31)
                        {
                            break;
                        }
                        else if (general.checkScore() < 31)
                        {
                            check = false;
                        }
                    }


                    endTurn = true;
                }
                P2.score += P2.checkPlay(P2);
                P2.hand.remove(playCard);

                System.out.println();
                System.out.println("Score of play: " + general.checkScore());
                System.out.println();
                System.out.println("Player 2's Total Score: " + P2.score);

                System.out.println();
                System.out.println("Player 3 Hand: ");
                P3.printHand();
                System.out.println();

                if (general.checkScore() == 31)
                {
                    break;
                }
                check1 =true;
                endTurn = false;

                while (check1 && !endTurn)
                {

                    if (!P3.checkPossible(P3, general.checkScore()))
                    {
                        check1 = false;
                        break;
                    }

                    check = true;
                    general.printPlay();
                    System.out.println("Player 3 please pick one card to add to play: ");
                    playCard = obj.nextInt();
                    P3.play.add(P3.hand.get(playCard));
                    if (general.checkScore() == 31)
                    {
                        break;
                    }
                    else if (general.checkScore() < 31)
                    {
                        check = false;
                    }

                    while (check)
                    {
                        P3.play.remove(P3.hand.get(playCard));
                        System.out.println("please play a different card: ");
                        playCard = obj.nextInt();
                        P3.play.add(P3.hand.get(playCard));

                        if (general.checkScore() == 31)
                        {
                            break;
                        }
                        else if (general.checkScore() < 31)
                        {
                            check = false;
                        }
                    }


                    endTurn = true;



                }
                check = true;

                P3.score += P3.checkPlay(P3);
                P3.hand.remove(playCard);

                System.out.println();
                System.out.println("Score of play: " + general.checkScore());
                System.out.println();
                System.out.println("Player 3's Total Score: " + P3.score);

                System.out.println();
                System.out.println("Player 1 Hand: ");
                P1.printHand();
                System.out.println("Player 2 Hand: ");
                P2.printHand();
                System.out.println("Player 3 Hand: ");
                P3.printHand();
                System.out.println("Score: " + general.checkScore());

                if (!P1.checkPossible(P1, general.checkScore()) && !P2.checkPossible(P2, general.checkScore())&& !P3.checkPossible(P3, general.checkScore()))
                {
                    break;
                }

            }
            System.out.println("checking hand");
            general.printCrib();
            System.out.println();
            if (x == 1){P1.score += P1.checkDHand(P1);}
            else {P1.score += P1.checkHand(P1);}

            if (x == 2){P2.score += P2.checkDHand(P2);}
            else {P2.score += P2.checkHand(P2);}

            if (x == 3){P3.score += P3.checkHand(P3);}
            else {P3.score += P3.checkHand(P3);}

            System.out.println("done checking hand");

            general.discardHand(P1, P2, P3);
            System.out.println("check 1");
            general.crib.removeAll(general.crib);
            general.play.removeAll(general.play);
            System.out.println("check 2");
            h.Test.removeAll(h.Test);

            P1.createHand();
            P2.createHand();
            P3.createHand();
            System.out.println("check 3");




        }
        if (P1.score >= 121 )
        {
            System.out.println("Player 1 wins!");
        }
        if (P2.score >= 121 )
        {
            System.out.println("Player 2 wins!");
        }
        if (P3.score >= 121 )
        {
            System.out.println("Player 3 wins!");
        }
        System.out.println("game done");

    }

}

