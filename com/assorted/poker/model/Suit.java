package com.assorted.poker.model;

/**
 * This class represents one of the 4 suits of cards, or a joker, considered a
 * 5th suit.
 * 
 * @author Brian Teeter
 * 
 */
public class Suit
{
	public static int SPADES = 1;

	public static int HEARTS = 2;

	public static int CLUBS = 3;

	public static int DIAMONDS = 4;

	public static int JOKER = 99;

	int suit = 0;

	/**
	 * Default Suit constructor.
	 * 
	 * @param newSuit
	 */
	public Suit()
	{

	}
	
	/**
	 * Parameterized Suit constructor.
	 * 
	 * @param newSuit
	 */
	public Suit(int newSuit)
	{
		setSuit(newSuit);
	}

	public int getSuit()
	{
		return suit;
	}

	public void setSuit(int suit)
	{
		this.suit = suit;
	}
}
