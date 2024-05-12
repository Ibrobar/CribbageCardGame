package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.*;

class Hand
{

    public int score = 0;

    public ArrayList<CardValue> hand = new ArrayList<CardValue>();



    public void createHand()
    {

        int x = 0;
        int y = 0;
        CardValue h = new CardValue(x,y);




        for (int i = 0; i < 5; i++)
        {

            CardValue temp = h.getRandomCard();

            while (!h.checkUnique(temp.getRank(), temp.getSuit()))
            {
                temp = h.getRandomCard();
            }

            h.Test.add(Arrays.asList(temp.getRank(),temp.getSuit()));


            hand.add(temp);

        }

    }

    public void printHand()
    {
        if (!hand.isEmpty())
        {
            for (int i = 0; i < hand.size(); i++)
            {
                System.out.println("Rank: " + hand.get(i).getRank() + " Suit: " + hand.get(i).getSuit() );
            }
        }

        else
        {
            System.out.println(("error"));
        }

    }



    public static ArrayList<CardValue> crib = new ArrayList<CardValue>();

    public void addRandomToCrib()
    {
        int x = 0;
        int y = 0;
        CardValue h = new CardValue(x,y);
        CardValue temp = h.getRandomCard();

        while (!h.checkUnique(temp.getRank(), temp.getSuit()))
        {
            temp = h.getRandomCard();
        }

        h.Test.add(Arrays.asList(temp.getRank(),temp.getSuit()));
        crib.add(temp);

    }
    public void printCrib()
    {
        System.out.println("Card in the Crib: ");
        if (!crib.isEmpty())
        {
            for (int i = 0; i < crib.size(); i++)
            {
                System.out.println("Rank: " + crib.get(i).getRank() + " Suit: " + crib.get(i).getSuit() );
            }
        }

        else
        {
            System.out.println(("No cards in crib"));
        }

    }

    public static ArrayList<CardValue> play = new ArrayList<CardValue>();
    public void printPlay()
    {
        System.out.println("Card in Play: ");
        if (!play.isEmpty())
        {
            for (int i = 0; i < play.size(); i++)
            {
                System.out.println("Rank: " + play.get(i).getRank() + " Suit: " + play.get(i).getSuit() );
            }
        }

        else
        {
            System.out.println(("No cards played"));
        }

    }
    public int checkScore()

    {
        int tempScore = 0;

        if (play.isEmpty())
        {
            return 0;
        }

        for (int i = 0; i<play.size(); i++)
        {
            tempScore += play.get(i).getValue();
        }

        return tempScore;
    }
    public boolean checkPossible(Hand X, int y)
    {
        if (X.hand.size()==4)
        {
            if ((X.hand.get(0).getValue()+ y) <= 31)
            {
                return true;
            }
            else if ((X.hand.get(1).getValue()+ y) <= 31)
            {
                return true;
            }
            else if ((X.hand.get(2).getValue()+ y) <= 31)
            {
                return true;
            }
            else if ((X.hand.get(3).getValue()+ y) <= 31)
            {
                return true;
            }else
            {
                return false;
            }

        }
        else if (X.hand.size()==3)
        {
            if ((X.hand.get(0).getValue()+ y) <= 31)
            {
                return true;
            }
            else if ((X.hand.get(1).getValue()+ y) <= 31)
            {
                return true;
            }
            else if ((X.hand.get(2).getValue()+ y) <= 31)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (X.hand.size()==2)
        {
            if ((X.hand.get(0).getValue()+ y) <= 31)
            {
                return true;
            }
            else if ((X.hand.get(1).getValue()+ y) <= 31)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (X.hand.size()==1)
        {
            if ((X.hand.get(0).getValue()+ y) <= 31)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }

    public int checkHand(Hand X)
    {
        int hscore = 0;
        ArrayList<CardValue> chand = new ArrayList<CardValue>();
        chand.add(X.Start);

        for (int i = 0; i < X.hand.size(); i++)
        {
            chand.add(X.hand.get(i));
        }


        //check for 15

        int fifteen = 0;

        for (int i = 0; i < chand.size(); i++)
        {

            fifteen += chand.get(i).getValue();
            if (fifteen == 15)

            {
                hscore += 2;
                fifteen = 0;
            }
        }



        //check for same ranks pairs, three, and four.
        ArrayList<Integer> sameRanks = new ArrayList<>();
        for (int i = 0; i<chand.size();i++)
        {
            sameRanks.add(chand.get(i).getRank());
        }
        Collections.sort(sameRanks);
        for (int i = 0; i < sameRanks.size(); i++)
        {
       /* if(i!=0)
        {
            if(sameRanks.get(i) == sameRanks.get(i--))
            {continue;}
        }*/
            if (Collections.frequency(sameRanks, sameRanks.get(i)) ==4)
            {
                hscore +=12;
            }
            else if (Collections.frequency(sameRanks, sameRanks.get(i)) ==3)
            {
                hscore +=6;
            }
            else if (Collections.frequency(sameRanks, sameRanks.get(i)) == 2)
            {
                hscore += 2;
            }
        }

        //check for same suit four and five
        ArrayList<Integer> sameSuits = new ArrayList<>();
        for (int i = 0; i<chand.size();i++)
        {
            sameSuits.add(chand.get(i).getSuit());
        }
        Collections.sort(sameSuits);
        for (int i = 0; i < sameSuits.size(); i++)
        {
        /*if(i!=0)
        {
            if(sameSuits.get(i) == sameSuits.get(i--))
            {continue;}
        }*/
            if (Collections.frequency(sameSuits, sameSuits.get(i)) ==5)
            {
                hscore +=5;
            }
            else if (Collections.frequency(sameSuits, sameSuits.get(i)) ==4)
            {
                hscore +=4;
            }

        }

        //check if jack is same suit as starter card

        for (int i = 0; i < X.hand.size(); i++)
        {
            if (X.hand.get(i).getRank() == 11)
            {
                if (Start.getSuit() == X.hand.get(i).getSuit())
                {
                    hscore += 1;
                }
            }

            else
            {
                continue;
            }
        }

        //check run






        Set<Integer> checkRun = new HashSet<>();
        for (int i = 0; i<chand.size(); i++)
        {
            checkRun.add(chand.get(i).getRank());

        }
        Integer[] checkRunList = checkRun.toArray(new Integer[checkRun.size()]);

        int counter = 1;

        for ( int i = 1; i < checkRunList.length; i++)
        {
            if (checkRunList[i]-1 == checkRunList[i-1])
            {
                counter ++;
            }  else if (counter >= 3)
            {
                hscore += counter;
                counter = 1;
            } else
            {
                counter = 1;
            }

        }




        return hscore;
    }
    public int checkDHand(Hand X)
    {
        int hscore = 0;
        ArrayList<CardValue> chand = new ArrayList<CardValue>();
        chand.add(X.Start);

        for (int i = 0; i < X.hand.size(); i++)
        {
            chand.add(X.hand.get(i));
        }
        for (int i = 0; i < X.crib.size(); i++)
        {
            chand.add(X.crib.get(i));
        }

        //check for 15

        int fifteen = 0;

        for (int i = 0; i < chand.size(); i++)
        {

            fifteen += chand.get(i).getValue();
            if (fifteen == 15)

            {
                hscore += 2;
                fifteen = 0;
            }
        }



        //check for same ranks pairs, three, and four.
        ArrayList<Integer> sameRanks = new ArrayList<>();
        for (int i = 0; i<chand.size();i++)
        {
            sameRanks.add(chand.get(i).getRank());
        }
        Collections.sort(sameRanks);
        for (int i = 0; i < sameRanks.size(); i++)
        {
        /*if(i!=0)
        {
            if(sameRanks.get(i) == sameRanks.get(i--))
            {continue;}
        }*/
            if (Collections.frequency(sameRanks, sameRanks.get(i)) ==4)
            {
                hscore +=12;
            }
            else if (Collections.frequency(sameRanks, sameRanks.get(i)) ==3)
            {
                hscore +=6;
            }
            else if (Collections.frequency(sameRanks, sameRanks.get(i)) == 2)
            {
                hscore += 2;
            }
        }

        //check for same suit four and five
        ArrayList<Integer> sameSuits = new ArrayList<>();
        for (int i = 0; i<chand.size();i++)
        {
            sameSuits.add(chand.get(i).getSuit());
        }
        Collections.sort(sameSuits);
        for (int i = 0; i < sameSuits.size(); i++)
        {
        /*if(i!=0)
        {
            if(sameSuits.get(i) == sameSuits.get(i--))
            {continue;}
        }*/
            if (Collections.frequency(sameSuits, sameSuits.get(i)) ==5)
            {
                hscore +=5;
            }
            else if (Collections.frequency(sameSuits, sameSuits.get(i)) ==4)
            {
                hscore +=4;
            }

        }

        //check if jack is same suit as starter card

        for (int i = 0; i < X.hand.size(); i++)
        {
            if (X.hand.get(i).getRank() == 11)
            {
                if (Start.getSuit() == X.hand.get(i).getSuit())
                {
                    hscore += 1;
                }
            }

            else
            {
                continue;
            }
        }

        //check run
        Set<Integer> checkRun = new HashSet<>();
        for (int i = 0; i<chand.size(); i++)
        {
            checkRun.add(chand.get(i).getRank());

        }
        Integer[] checkRunList = checkRun.toArray(new Integer[checkRun.size()]);

        int counter = 1;

        for ( int i = 1; i < checkRunList.length; i++)
        {
            if (checkRunList[i]-1 == checkRunList[i-1])
            {
                counter ++;
            }  else if (counter >= 3)
            {
                hscore += counter;
                counter = 1;
            } else
            {
                counter = 1;
            }

        }

        return hscore;
    }


    public static CardValue starterCard()
    {
        int x = 0;
        int y = 0;

        CardValue h = new CardValue(x, y);
        CardValue starterCard = h.getRandomCard();

        while (!h.checkUnique(starterCard.getRank(), starterCard.getSuit())) {
            starterCard = h.getRandomCard();
        }

        h.Test.add(Arrays.asList(starterCard.getRank(), starterCard.getSuit()));

        return starterCard;
    }
    public static CardValue Start = starterCard();

    public int checkPlay(Hand X)
    {
        int Pscore = 0;
        int runScore =0;

//Hand cp = new Hand;




        if(X.Fifteen(X))
        {
            Pscore+=2;
        }
        if(X.Pairs(X))
        {
            Pscore+=2;
        }
        if(X.Three(X))
        {
            Pscore+=6;
        }
        if(X.Four(X))
        {
            Pscore+=12;
        }
        if(X.Run(X, runScore))
        {

            Pscore += runScore;
        }
        if(X.ThirtyOne(X))
        {
            Pscore+=2;
        }
        return Pscore;

    }

    public boolean Fifteen(Hand X)
    {
        int count = 0;
        for(int i=0; i< X.play.size();i++)
        {
            count += X.play.get(i).getValue();
        }
        if(count == 15)
        {
            return true;
        }
        return false;
    }


    public boolean Pairs(Hand X)
    {
        if(X.play.size()< 2)
        {
            return false;
        }

        if(X.play.get(X.play.size()-1) == X.play.get(X.play.size()-2))
        {
            return true;
        }
        return false;
    }

    public boolean Three(Hand X)
    {
        if(X.play.size()< 3)
        {
            return false;
        }
        if(X.play.get(X.play.size()-1) == X.play.get(X.play.size()-2) && X.play.get(X.play.size()-1) == X.play.get(X.play.size()-3))
        {
            return true;
        }
        return false;
    }
    public boolean Four(Hand X)
    {
        if(X.play.size()< 4)
        {
            return false;
        }
        if(X.play.get(X.play.size()-1) == X.play.get(X.play.size()-2) && X.play.get(X.play.size()-1) == X.play.get(X.play.size()-3) && X.play.get(X.play.size()-1) == X.play.get(X.play.size()-4))
        {
            return true;
        }
        return false;
    }
    public boolean Run(Hand X, int runScore)
    {

        if (X.play.size() < 3)
        {
            return false;
        }
        ArrayList<Integer> checkRun = new ArrayList<>();
        for (int i = 0; i<X.play.size(); i++)
        {
            checkRun.add(X.play.get(i).getRank());

        }
        Collections.sort(checkRun);
        int j = checkRun.size();
        for(int i=0; i< checkRun.size();i++)
        {
            if (j < 3)
            {
                if(runScore >= 3)
                {
                    return true;
                }
                return false;
            }
            if(checkRun.get(i) == (checkRun.get(i+1)-1) && checkRun.get(i) == (checkRun.get(i+2)-2))
            {

                runScore += 3;
                int iter = 3;
                if (X.play.size() > 3)
                {
                    while(iter + 1 > X.play.size())
                    {
                        if (checkRun.get(i) == (checkRun.get(iter)-iter))
                        {
                            iter += 1;
                            runScore +=1;
                            if(iter == checkRun.size())
                            {
                                break;
                            }
                        }



                    }
                }




            }

            j--;

        }

        if(runScore >= 3)
        {
            return true;
        }
        return false;
    }
    public boolean ThirtyOne(Hand X)
    {
        int count =0;
        for(int i=0; i< X.play.size();i++)
        {
            count += X.play.get(i).getValue();
        }
        if(count == 31)
        {
            return true;
        }
        return false;
    }
    /*public boolean run(Hand x) {

        return true;

    }

    public int checkPlay(Hand X) {

        Hand cp = new Hand();
        if (cp.run(X)) {
            return 0;
        }
        return 0;
    }*/

    public void discardHand(Hand X, Hand Y, Hand Z)
    {
        X.hand.removeAll(X.hand);
        Y.hand.removeAll(Y.hand);
        Z.hand.removeAll(Z.hand);
    }
    public void checkStarterCard (Hand X)
    {

        if (X.Start.getRank() == 11)
        {

            System.out.println("The dealer gets 2 points, the starter card is a Jack: ");

            X.score =+ 2;
        }

    }
}

