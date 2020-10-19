/**
 * 
 */
package com.assorted.poker.model;

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
		}
		else
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
		System.out.println("The Deck is: " + theDeck.toString());

		theDeck.shuffle();
		System.out.println("The Shuffled Deck is: " + theDeck.toString());

		theDeck.shuffle();
		System.out.println("The Shuffled Deck is: " + theDeck.toString());

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
		int cardLocation = this.getDeck().indexOf(card);
		this.getDeck().remove(cardLocation);
	}

}
