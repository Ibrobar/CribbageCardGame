package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.*;


class CardValue
{
    //test
    private int suit, rank;

    public CardValue(int suits, int ranks)
    {
        suit = suits;
        rank = ranks;
    }


    public static ArrayList<List<Integer>> Test = new ArrayList<List<Integer>>();

    public int getRank()
    {
        return rank;
    }

    public int getSuit()
    {
        return suit;
    }

    public static int randomNumberGenerator ( int min, int max)
    {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static CardValue getRandomCard()
    {
        int rngRank = randomNumberGenerator(1,14);
        int rngSuit = randomNumberGenerator(1,5);

        CardValue random = new CardValue(rngSuit, rngRank);
        return random;
    }


    public int getValue()
    {
        if(rank <= 10)
        {
            return rank;
        } else
        {
            return 10;
        }
    }

    public boolean checkUnique(int rank, int suit)
    {

        for (int i = 0; i < Test.size(); i++)
        {
            var tempRank = Test.get(i).get(0);
            var tempSuit = Test.get(i).get(1);
            if (rank == tempRank && suit == tempSuit)
            {
                return false;
            }

        }
        return true;
    }
}


    /*public int getValue()
    {
        if(rank <= 10)
        {
            return rank;
        } else
        {
            return 10;
        }
    }*/

