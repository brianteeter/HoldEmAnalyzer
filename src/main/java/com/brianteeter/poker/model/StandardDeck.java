/**
 *
 */
package com.brianteeter.poker.model;

/*-
 * #%L
 * HoldEmAnalyzer
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2004 - 2024 Brian Teeter
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a standard 52 card deck. No jokers.
 *
 * @author Brian Teeter
 *
 */
public class StandardDeck
{

    ArrayList deck = null;

    /**
     * Default Constructor creates a deck filled with cards.
     *
     */
    public StandardDeck()
    {
        freshDeck();
    }

    /**
     * Create a new fresh, unshuffled deck.
     */
    public void freshDeck()
    {
        deck = null;
        deck = new ArrayList(52);

        for (int suits = 1; suits < 5; suits++)
        {
            for (int ranks = 2; ranks <= Card.RANK_ACE; ranks++)
            {

                deck.add(new Card(ranks, new Suit(suits)));
            }
        }
    }

    /**
     * Takes the current deck of cards and shuffles it by swapping the
     * places of cards a lot of times.
     *
     */
    public void shuffle()
    {
        // Create a random number generator:
        Random random = new Random();
        int iterationCount = deck.size();

        // Create a new arraylist for the random card distribution:
        ArrayList newCardPile = new ArrayList(52);
        int targetCard = 0;

        for (int i = 0; i < iterationCount; i++)
        {
            targetCard = random.nextInt(deck.size());
            newCardPile.add(deck.get(targetCard));
            deck.remove(targetCard);
        }

        deck = newCardPile;
    }

    /**
     * Takes the top card off of the deck:
     * a
     */
    public Card pullCard()
    {
        if (deck.size() > 0)
        {
            return (Card) deck.remove(0);
        } else
        {
            System.out.println("ERROR: No cards in the deck to remove!");
            return null;
        }
    }

    /**
     * Prints the deck to a readible string.
     */
    public String toString()
    {
        String result = "";

        if (deck != null)
        {
            result += deck.size() + " cards left -- ";
            result += deck.toString();
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        StandardDeck theDeck = new StandardDeck();
        System.out.println("The Deck is: " + theDeck);

        theDeck.shuffle();
        System.out.println("The Shuffled Deck is: " + theDeck);

        theDeck.shuffle();
        System.out.println("The Shuffled Deck is: " + theDeck);

        System.exit(0);

    }

    public ArrayList getDeck()
    {
        return deck;
    }

    public void setDeck(ArrayList deck)
    {
        this.deck = deck;
    }

    /**
     * Use this method to remove a specific card from the deck.
     *
     * @param card
     */
    public void removeCard(Card card)
    {
        this.getDeck().remove(card);
    }

}
