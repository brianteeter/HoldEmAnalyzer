package com.assorted.poker.model;

/**
 * This class represents 1 playing card.
 * 
 * @author Brian Teeter
 * 
 */
public class Card implements Comparable
{
	// Constants:
	public static int RANK_JOKER = 99;

	public static int RANK_ACE = 14;

	public static int RANK_KING = 13;

	public static int RANK_QUEEN = 12;

	public static int RANK_JACK = 11;

	// Member variables:
	int rank;

	Suit suit = null;

	/**
	 * Default Constructor
	 */
	public Card()
	{
		suit = new Suit();
		rank = 0;
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param newRank
	 * @param newSuit
	 */
	public Card(int newRank, Suit newSuit)
	{
		suit = newSuit;
		rank = newRank;
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param newRank
	 * @param newSuit
	 */
	public Card(String cardString)
	{
		suit = new Suit();
		rank = 0;

		if (cardString != null && (cardString.length() <= 2))
		{
			String rankString = cardString.substring(0, 1);
			String suitString = cardString.substring(1, 2);

			// Set the rank of the card:
			if (rankString.equals("A"))
			{
				this.setRank(RANK_ACE);
			}
			else
			{
				if (rankString.equals("K"))
				{
					this.setRank(RANK_KING);
				}
				else
				{
					if (rankString.equals("Q"))
					{
						this.setRank(RANK_QUEEN);
					}
					else
					{
						if (rankString.equals("J"))
						{
							this.setRank(RANK_JACK);
						}
						else
						{
							if (rankString.equals("T"))
							{
								this.setRank(10);
							}
							else
							{
								this.setRank(Integer.parseInt(rankString));
							}
						}
					}
				}
			}

			// Set the suit of the card:
			if (suitString.equals("c") == true)
			{
				suit = new Suit(Suit.CLUBS);
			}
			if (suitString.equals("d") == true)
			{
				suit = new Suit(Suit.DIAMONDS);
			}
			if (suitString.equals("h") == true)
			{
				suit = new Suit(Suit.HEARTS);
			}
			if (suitString.equals("s") == true)
			{
				suit = new Suit(Suit.SPADES);
			}

		}

	}

	/**
	 * Prints the Card in a readible format.
	 */
	public String toString()
	{
		String result = "";

		// Add the card rank to the String:
		if (rank == RANK_ACE)
		{
			result += "A";
		}
		else
		{
			if (rank == RANK_KING)
			{
				result += "K";
			}
			else
			{
				if (rank == RANK_QUEEN)
				{
					result += "Q";
				}
				else
				{
					if (rank == RANK_JACK)
					{
						result += "J";
					}
					else
					{
						if (rank == 10)
						{
							result += "T";
						}
						else
						{
							result += rank;
						}
					}
				}
			}
		}

		// Add the Suit to the String:
		if ((suit != null) && (suit.getSuit() == Suit.CLUBS))
		{
			result += "c";
		}
		if ((suit != null) && (suit.getSuit() == Suit.DIAMONDS))
		{
			result += "d";
		}
		if ((suit != null) && (suit.getSuit() == Suit.HEARTS))
		{
			result += "h";
		}
		if ((suit != null) && (suit.getSuit() == Suit.SPADES))
		{
			result += "s";
		}

		return result;
	}

	/**
	 * This function checks equality of Card objects
	 * 
	 * @param o
	 * @return
	 */
	public boolean equals(Object o)
	{
		boolean result = false;

		// Make sure we are comparing Card objects:
		if ((o instanceof Card) && (o != null))
		{
			Card otherCard = (Card) o;
			
			// Compare the cards to see if they are equal:
			if ((otherCard.getRank() == this.getRank())
					&& (otherCard.getSuit().getSuit() == this.getSuit().getSuit()))
			{
				result = true;
			}
		}
		return result;
	}

	/**
	 * This function is called to compare Card objects.
	 * 
	 * @param o
	 * @return
	 */
	public int compareTo(Object o)
	{
		int result = 0;
		Card otherCard = (Card) o;

		if ((otherCard == null) || ((o instanceof Card) != true))
		{
			result = 0;
		}
		else
		{
			if (otherCard.rank > this.rank)
			{
				result = -1;
			}
			else
			{
				if (otherCard.rank < this.rank)
				{
					result = 1;
				}
				else
				{
					result = 0;
				}
			}
		}

		return result;
	}

	public int getRank()
	{
		return rank;
	}

	public void setRank(int rank)
	{
		this.rank = rank;
	}

	public Suit getSuit()
	{
		return suit;
	}

	public void setSuit(Suit suit) 
	{
		this.suit = suit;
	}
	public void setSuit(int suit)
	{
		this.suit = new Suit(suit);
	}
}
