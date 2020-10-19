/**
 * 
 */
package com.assorted.poker.model;

import java.util.ArrayList;
import java.util.Collections;

import com.assorted.poker.model.comparators.DescendingCardComparator;

/**
 * This class will represent a Texas Hold Em Hand.
 * 
 * @author Brian Teeter
 */
public class HoldEmHand implements Comparable

{
	// Constants:
	public static int RANK_ROYAL_FLUSH = 10;

	public static int RANK_STRAIGHT_FLUSH = 9;

	public static int RANK_QUADS = 8;

	public static int RANK_FULL_HOUSE = 7;

	public static int RANK_FLUSH = 6;

	public static int RANK_STRAIGHT = 5;

	public static int RANK_TRIPS = 4;

	public static int RANK_TWO_PAIR = 3;

	public static int RANK_PAIR = 2;

	public static int RANK_HIGH_CARD = 1;

	// Member Variables
	Card hole1 = null;

	Card hole2 = null;

	Card flop1 = null;

	Card flop2 = null;

	Card flop3 = null;

	Card turn = null;

	Card river = null;

	// The sorted arraylist of cards in the hand:
	ArrayList madeHand = null;

	// Contains only the 5 cards used to make the hand when ranked:
	ArrayList rankedHand = null;

	int handRank = 0;

	/**
	 * Default Constructor creates a hand of 7 cards with no values.
	 */
	public HoldEmHand()
	{
	}

	/**
	 * Default Constructor creates a hand of 7 cards with no values.
	 */
	public HoldEmHand(Card h1, Card h2)
	{
		this.setHole1(h1);
		this.setHole2(h2);
	}

	/**
	 * This function clears out the data in the hand and resets it for reuse.
	 * 
	 */
	public void clearHand()
	{
		hole1 = null;
		hole2 = null;
		flop1 = null;
		flop2 = null;
		flop3 = null;
		turn = null;
		river = null;
		madeHand = null;
		rankedHand = null;
		handRank = 0;
	}

	public Card getFlop1()
	{
		return flop1;
	}

	public void setFlop1(Card flop1)
	{
		this.flop1 = flop1;
	}

	public Card getFlop2()
	{
		return flop2;
	}

	public void setFlop2(Card flop2)
	{
		this.flop2 = flop2;
	}

	public Card getFlop3()
	{
		return flop3;
	}

	public void setFlop3(Card flop3)
	{
		this.flop3 = flop3;
	}

	public Card getHole1()
	{
		return hole1;
	}

	public void setHole1(Card hole1)
	{
		this.hole1 = hole1;
	}

	public Card getHole2()
	{
		return hole2;
	}

	public void setHole2(Card hole2)
	{
		this.hole2 = hole2;
	}

	public Card getRiver()
	{
		return river;
	}

	public void setRiver(Card river)
	{
		this.river = river;
	}

	public Card getTurn()
	{
		return turn;
	}

	public void setTurn(Card turn)
	{
		this.turn = turn;
	}

	public int getHandRank()
	{
		return handRank;
	}

	public void setHandRank(int handRank)
	{
		this.handRank = handRank;
	}

	public ArrayList getMadeHand()
	{
		return madeHand;
	}

	public void setMadeHand(ArrayList madeHand)
	{
		this.madeHand = madeHand;
	}

	/**
	 * This function ranks the current hand, if possible and returns the rank.
	 * It also sets the rank and made hand into the member variables of the
	 * object.
	 * 
	 * @return
	 */
	public int rankHand()
	{
		int result = 0;

		// Clear the madeHand variable, and remake the hand properly:
		madeHand = null;
		makeMadeHand();

		// If we don't have the first 5 cards, then we cannot rank the hand:
		if ((hole1 == null) || (hole2 == null) || (flop1 == null)
				|| (flop2 == null) || (flop3 == null))
		{
			result = -1;
		}
		else
		{
			// First check for a Royal/Straight Flush:
			if (isStraightFlush() == true)
			{
				// Hand is ranked in the function isStraightFlush() as Royal or
				// Straight
				// Flush as appropriate.
			}
			else
			{
				// Check the next highest rank, Quads:
				if (isQuads() == true)
				{
					this.handRank = RANK_QUADS;
				}
				else
				{
					// Check the next highest rank a Full House:
					if (isFullHouse() == true)
					{
						this.handRank = RANK_FULL_HOUSE;
					}
					else
					{
						// Check the next highest rank a Flush:
						if (isFlush() == true)
						{
							this.handRank = RANK_FLUSH;
						}
						else
						{
							// Check the next highest rank a Straight:
							if (isStraight() == true)
							{
								this.handRank = RANK_STRAIGHT;
							}
							else
							{
								// Check the next highest rank a Trips:
								if (isTrips() == true)
								{
									this.handRank = RANK_TRIPS;
								}
								else
								{
									// Check the next highest rank a Trips:
									if (isTwoPair() == true)
									{
										this.handRank = RANK_TWO_PAIR;
									}
									else
									{
										// Check the next highest rank a Trips:
										if (isPair() == true)
										{
											this.handRank = RANK_PAIR;
										}
										else
										{
											// It must be a high card hand then:
											isHighCard();
											this.handRank = RANK_HIGH_CARD;
										}
									}
								}
							}
						}
					}
				}

			}
		}

		return result;
	}

	/**
	 * This function returns a string naming the hand's current rank.
	 * 
	 * @return Hand rank string
	 */
	public String getHandRankString()
	{
		if (this.getHandRank() == RANK_ROYAL_FLUSH)
		{
			return "Royal Flush";
		}
		if (this.getHandRank() == RANK_STRAIGHT_FLUSH)
		{
			return "Straight Flush";
		}
		if (this.getHandRank() == RANK_QUADS)
		{
			return "Quads";
		}
		if (this.getHandRank() == RANK_FULL_HOUSE)
		{
			return "Full House";
		}
		if (this.getHandRank() == RANK_FLUSH)
		{
			return "Flush";
		}
		if (this.getHandRank() == RANK_STRAIGHT)
		{
			return "Straight";
		}
		if (this.getHandRank() == RANK_TRIPS)
		{
			return "Trips";
		}
		if (this.getHandRank() == RANK_TWO_PAIR)
		{
			return "Two Pair";
		}
		if (this.getHandRank() == RANK_PAIR)
		{
			return "Pair";
		}
		if (this.getHandRank() == RANK_HIGH_CARD)
		{
			return "High Card";
		}
		return "No Rank";
	}

	/**
	 * This function determines if the hand is a straight flush:
	 * 
	 * @return
	 */
	public boolean isStraightFlush()
	{
		boolean result = false;

		// Verify that there are enough cards to rank:
		if ((hole1 == null) || (hole2 == null) || (flop1 == null)
				|| (flop2 == null) || (flop3 == null))
		{
			result = false;
		}
		else
		{
			// If the hand makes a flush, keep only the flush cards in the
			// made hand:
			ArrayList flushHand = null;

			if (isFlush() == true)
			{
				flushHand = getRankedHand();
				Collections.sort(flushHand, new DescendingCardComparator());

				if (flushHand == null || flushHand.size() == 0)
				{
					System.out.println("This should never happen.");
				}

				Card card1 = (Card) flushHand.get(0);
				Card card2 = (Card) flushHand.get(1);
				Card card3 = (Card) flushHand.get(2);
				Card card4 = (Card) flushHand.get(3);
				Card card5 = (Card) flushHand.get(4);

				// Only if the cards exist do we fetch these:
				Card card6 = null;
				Card card7 = null;

				if (flushHand.size() >= 6)
				{
					card6 = (Card) flushHand.get(5);
				}

				if (flushHand.size() >= 7)
				{
					card7 = (Card) flushHand.get(6);
				}

				// There are only three possible straight flushes to check,
				// check them each in turn:
				if ((card1.getRank() == (card2.getRank() + 1))
						&& (card1.getRank() == (card3.getRank() + 2))
						&& (card1.getRank() == (card4.getRank() + 3))
						&& (card1.getRank() == (card5.getRank() + 4))
						&& (card1.getSuit().getSuit() == card2.getSuit()
								.getSuit())
						&& (card1.getSuit().getSuit() == card3.getSuit()
								.getSuit())
						&& (card1.getSuit().getSuit() == card4.getSuit()
								.getSuit())
						&& (card1.getSuit().getSuit() == card5.getSuit()
								.getSuit()))
				{
					// We at least have a Straight Flush, lets see if it is
					// a Royal Flush:
					if (card1.getRank() == Card.RANK_ACE)
					{
						this.setHandRank(RANK_ROYAL_FLUSH);
					}
					else
					{
						this.setHandRank(RANK_STRAIGHT_FLUSH);
					}

					this.setRankedHand(null);

					// Set the cards in the made hand:
					this.setRankedHand(new ArrayList(5));
					this.getRankedHand().add(card1);
					this.getRankedHand().add(card2);
					this.getRankedHand().add(card3);
					this.getRankedHand().add(card4);
					this.getRankedHand().add(card5);

					result = true;
				}

				// This is the 2nd possible straight flush:
				if ((flushHand.size() >= 6)
						&& (card2.getRank() == (card3.getRank() + 1))
						&& (card2.getRank() == (card4.getRank() + 2))
						&& (card2.getRank() == (card5.getRank() + 3))
						&& (card2.getRank() == (card6.getRank() + 4))
						&& (card2.getSuit().getSuit() == card3.getSuit()
								.getSuit())
						&& (card2.getSuit().getSuit() == card4.getSuit()
								.getSuit())
						&& (card2.getSuit().getSuit() == card5.getSuit()
								.getSuit())
						&& (card2.getSuit().getSuit() == card6.getSuit()
								.getSuit()))
				{
					// We at least have a Straight Flush, lets see if it is
					// a Royal Flush:
					if (card2.getRank() == Card.RANK_ACE)
					{
						this.setHandRank(RANK_ROYAL_FLUSH);
					}
					else
					{
						this.setHandRank(RANK_STRAIGHT_FLUSH);
					}

					this.setRankedHand(null);

					// Set the cards in the made hand:
					this.setRankedHand(new ArrayList(5));
					this.getRankedHand().add(card2);
					this.getRankedHand().add(card3);
					this.getRankedHand().add(card4);
					this.getRankedHand().add(card5);
					this.getRankedHand().add(card6);
					result = true;
				}

				// This is the 3rd possible straight flush:
				if ((flushHand.size() == 7)
						&& (card3.getRank() == (card4.getRank() + 1))
						&& (card3.getRank() == (card5.getRank() + 2))
						&& (card3.getRank() == (card6.getRank() + 3))
						&& (card3.getRank() == (card7.getRank() + 4))
						&& (card3.getSuit().getSuit() == card4.getSuit()
								.getSuit())
						&& (card3.getSuit().getSuit() == card5.getSuit()
								.getSuit())
						&& (card3.getSuit().getSuit() == card6.getSuit()
								.getSuit())
						&& (card3.getSuit().getSuit() == card7.getSuit()
								.getSuit()))
				{
					// We at least have a Straight Flush, lets see if it is
					// a Royal Flush:
					if (card3.getRank() == Card.RANK_ACE)
					{
						this.setHandRank(RANK_ROYAL_FLUSH);
					}
					else
					{
						this.setHandRank(RANK_STRAIGHT_FLUSH);
					}

					this.setRankedHand(null);

					// Set the cards in the made hand:
					this.setRankedHand(new ArrayList(5));
					this.getRankedHand().add(card3);
					this.getRankedHand().add(card4);
					this.getRankedHand().add(card5);
					this.getRankedHand().add(card6);
					this.getRankedHand().add(card7);
					result = true;
				}
			}
		}

		return result;
	}

	/**
	 * This function determines if the hand is a flush:
	 * 
	 * @return
	 */
	public boolean isFlush()
	{
		boolean result = false;
		int diamondCount = 0;
		int heartCount = 0;
		int spadeCount = 0;
		int clubCount = 0;

		// Verify that there are enough cards to rank:
		if ((hole1 == null) || (hole2 == null) || (flop1 == null)
				|| (flop2 == null) || (flop3 == null))
		{
			result = false;
		}
		else
		{
			// Count the numbers of each suit in the hand, and if we
			// find 5 or more of a suit then we have ourselves a
			// flush:
			Card nextCard = null;
			for (int i = 0; i < madeHand.size(); i++)
			{
				nextCard = (Card) madeHand.get(i);
				if (nextCard.suit.getSuit() == Suit.CLUBS)
				{
					clubCount++;
				}
				if (nextCard.suit.getSuit() == Suit.DIAMONDS)
				{
					diamondCount++;
				}
				if (nextCard.suit.getSuit() == Suit.SPADES)
				{
					spadeCount++;
				}
				if (nextCard.suit.getSuit() == Suit.HEARTS)
				{
					heartCount++;
				}
			}

			int totalCards = 0;

			// Flush in Hearts:
			if (heartCount >= 5)
			{
				result = true;
				this.setHandRank(RANK_FLUSH);
				this.setRankedHand(null);
				this.setRankedHand(new ArrayList(7));

				// Create the ranked hand that contains the hearts first:
				for (int i = 0; i < madeHand.size(); i++)
				{
					nextCard = (Card) madeHand.get(i);
					if (nextCard.suit.getSuit() == Suit.HEARTS)
					{
						this.getRankedHand().add(nextCard);
						totalCards++;
					}
				}
			}

			// Flush in Diamonds:
			if (diamondCount >= 5)
			{
				result = true;
				this.setHandRank(RANK_FLUSH);
				this.setRankedHand(null);
				this.setRankedHand(new ArrayList(7));

				// Create the ranked hand that contains the hearts first:
				for (int i = 0; i < madeHand.size(); i++)
				{
					nextCard = (Card) madeHand.get(i);
					if (nextCard.suit.getSuit() == Suit.DIAMONDS)
					{
						this.getRankedHand().add(nextCard);
						totalCards++;
					}
				}
			}

			// Flush in Spades:
			if (spadeCount >= 5)
			{
				result = true;
				this.setHandRank(RANK_FLUSH);
				this.setRankedHand(null);
				this.setRankedHand(new ArrayList(7));

				// Create the ranked hand that contains the hearts first:
				for (int i = 0; i < madeHand.size(); i++)
				{
					nextCard = (Card) madeHand.get(i);
					if (nextCard.suit.getSuit() == Suit.SPADES)
					{
						this.getRankedHand().add(nextCard);
						totalCards++;
					}
				}
			}

			// Flush in Spades:
			if (clubCount >= 5)
			{
				result = true;
				this.setHandRank(RANK_FLUSH);
				this.setRankedHand(null);
				this.setRankedHand(new ArrayList(7));

				// Create the ranked hand that contains the hearts first:
				for (int i = 0; i < madeHand.size(); i++)
				{
					nextCard = (Card) madeHand.get(i);
					if (nextCard.suit.getSuit() == Suit.CLUBS)
					{
						this.getRankedHand().add(nextCard);
						totalCards++;
					}
				}
			}
		}
		return result;
	}

	/**
	 * This function determines if the hand is a straight:
	 * 
	 * @return
	 */
	public boolean isStraight()
	{
		boolean result = false;

		ArrayList madeHandClone = (ArrayList) madeHand.clone();

		// Verify that there are enough cards to rank:
		if ((hole1 == null) || (hole2 == null) || (flop1 == null)
				|| (flop2 == null) || (flop3 == null))
		{
			result = false;
		}
		else
		{
			// -------------------------------------------------------------------
			// We need to remove any cards of the same rank. This is to fix a
			// bug
			// where we have a hand like: 9 8 and a board like 8 7 6 - because
			// the function will see 9 8 8 7 6 and never realize that a T or 6
			// makes a straight:
			// -------------------------------------------------------------------
			Card cardOne = null;
			Card cardTwo = null;

			for (int i = 0; i < madeHandClone.size(); i++)
			{
				for (int j = (i + 1); j < madeHandClone.size(); j++)
				{
					if (i != j)
					{
						cardOne = (Card) madeHandClone.get(i);
						cardTwo = (Card) madeHandClone.get(j);

						if ((cardOne != null) && (cardTwo != null)
								&& (cardOne.rank == cardTwo.rank))
						{
							madeHandClone.remove(cardTwo);
						}
					}
				}
			}

			// -------------------------------------------------------------------
			// Now that the cards are in order, there are only 3 possible
			// combinations of cards to make a straight, so check them:
			// -------------------------------------------------------------------
			Card firstCard = null;
			Card secondCard = null;
			Card thirdCard = null;
			Card fourthCard = null;
			Card fifthCard = null;

			for (int i = 0; i < madeHandClone.size() - 5; i++)
			{
				firstCard = (Card) madeHandClone.get(i);
				secondCard = (Card) madeHandClone.get(i + 1);
				thirdCard = (Card) madeHandClone.get(i + 2);
				fourthCard = (Card) madeHandClone.get(i + 3);
				fifthCard = (Card) madeHandClone.get(i + 4);

				if ((firstCard.rank) == (secondCard.rank + 1)
						&& ((firstCard.rank) == (thirdCard.rank + 2))
						&& ((firstCard.rank) == (fourthCard.rank + 3))
						&& ((firstCard.rank) == (fifthCard.rank + 4)))

				{
					// -------------------------------------------------------------------
					// If the cards are ordered, then we have a straight, so
					// make the ranked hand and set the hand rank:
					// -------------------------------------------------------------------
					result = true;
					this.setHandRank(RANK_STRAIGHT);
					this.setRankedHand(null);
					this.setRankedHand(new ArrayList(7));
					this.getRankedHand().add(firstCard);
					this.getRankedHand().add(secondCard);
					this.getRankedHand().add(thirdCard);
					this.getRankedHand().add(fourthCard);
					this.getRankedHand().add(fifthCard);
				}
			}
		}

		return result;

	}

	/**
	 * This function determines if the hand is a quads hand:
	 * 
	 * @return
	 */
	public boolean isQuads()
	{
		boolean result = false;

		// Verify that there are enough cards to rank:
		if ((hole1 == null) || (hole2 == null) || (flop1 == null)
				|| (flop2 == null) || (flop3 == null))
		{
			result = false;
		}
		else
		{
			// -------------------------------------------------------------------
			// Now that the cards are in order, there are only 3 possible
			// combinations of cards to make quads, so check them:
			// -------------------------------------------------------------------
			Card firstCard = null;
			Card secondCard = null;
			Card thirdCard = null;
			Card fourthCard = null;

			for (int i = 0; i <= (madeHand.size() - 4); i++)
			{
				firstCard = (Card) madeHand.get(i);
				secondCard = (Card) madeHand.get(i + 1);
				thirdCard = (Card) madeHand.get(i + 2);
				fourthCard = (Card) madeHand.get(i + 3);

				if ((firstCard.rank) == (secondCard.rank )
						&& ((firstCard.rank) == (thirdCard.rank))
						&& ((firstCard.rank) == (fourthCard.rank)))

				{
					// -------------------------------------------------------------------
					// If the cards are the same rank, then we have quads,
					// so make the ranked hand and set the hand rank:
					// -------------------------------------------------------------------
					result = true;
					this.setHandRank(RANK_QUADS);
					this.setRankedHand(null);
					this.setRankedHand(new ArrayList(7));
					this.getRankedHand().add(firstCard);
					this.getRankedHand().add(secondCard);
					this.getRankedHand().add(thirdCard);
					this.getRankedHand().add(fourthCard);

					// -------------------------------------------------------------------
					// The fifth card should be the highest card in the
					// hand, not part of the quads:
					// -------------------------------------------------------------------
					if (i == 2)
					{
						this.getRankedHand().add(madeHand.get(0));
					}
					if (i == 1)
					{
						this.getRankedHand().add(madeHand.get(1));
					}
					if (i == 0)
					{
						this.getRankedHand().add(madeHand.get(2));
					}
				}
			}
		}

		return result;

	}

	/**
	 * This function determines if the hand is a Full House:
	 * 
	 * @return
	 */
	public boolean isFullHouse()
	{
		boolean result = false;

		// -------------------------------------------------------------------
		// Verify that there are enough cards to rank:
		// -------------------------------------------------------------------
		if ((hole1 == null) || (hole2 == null) || (flop1 == null)
				|| (flop2 == null) || (flop3 == null))
		{
			result = false;
		}
		else
		{
			Card tripsCard1 = null;
			Card tripsCard2 = null;
			Card tripsCard3 = null;
			Card pairCard1 = null;
			Card pairCard2 = null;

			int tripsRank = 0;

			// -------------------------------------------------------------------
			// Look for a set of trips in the hand, if one is found
			// then look for a different pair:
			// -------------------------------------------------------------------
			for (int i = 0; i < madeHand.size() - 2; i++)
			{
				tripsCard1 = (Card) madeHand.get(i);
				tripsCard2 = (Card) madeHand.get(i + 1);
				tripsCard3 = (Card) madeHand.get(i + 2);

				if ((tripsCard1.rank) == (tripsCard2.rank )
						&& ((tripsCard1.rank) == (tripsCard3.rank)))

				{
					// -------------------------------------------------------------------
					// If the cards make a set, then store the set rank
					// and look for a different pair:
					// -------------------------------------------------------------------
					tripsRank = tripsCard1.rank;

					for (int j = 0; j < madeHand.size() - 1; j++)
					{
						pairCard1 = (Card) madeHand.get(j);
						pairCard2 = (Card) madeHand.get(j + 1);

						// -------------------------------------------------------------------
						// If we found a pair, not of the rank of the
						// trips, then we have a full house
						// -------------------------------------------------------------------
						if ((pairCard1.rank == pairCard2.rank)
								&& (pairCard1.rank != tripsRank))
						{
							result = true;
							this.setHandRank(RANK_FULL_HOUSE);
							this.setRankedHand(null);
							this.setRankedHand(new ArrayList(7));
							this.getRankedHand().add(tripsCard1);
							this.getRankedHand().add(tripsCard2);
							this.getRankedHand().add(tripsCard3);
							this.getRankedHand().add(pairCard1);
							this.getRankedHand().add(pairCard2);

						}
					}
				}
			}

		}

		return result;

	}

	/**
	 * This function determines if the hand is a trips hand:
	 * 
	 * @return
	 */
	public boolean isTrips()
	{
		boolean result = false;

		// -------------------------------------------------------------------
		// Verify that there are enough cards to rank:
		// -------------------------------------------------------------------
		if ((hole1 == null) || (hole2 == null) || (flop1 == null)
				|| (flop2 == null) || (flop3 == null))
		{
			result = false;
		}
		else
		{
			Card tripsCard1 = null;
			Card tripsCard2 = null;
			Card tripsCard3 = null;

			// -------------------------------------------------------------------
			// Look for a set of trips in the hand, if one is found
			// then look for a different pair:
			// -------------------------------------------------------------------
			for (int i = 0; i <= madeHand.size() - 3; i++)
			{
				tripsCard1 = (Card) madeHand.get(i);
				tripsCard2 = (Card) madeHand.get(i + 1);
				tripsCard3 = (Card) madeHand.get(i + 2);

				if ((tripsCard1.rank) == (tripsCard2.rank )
						&& ((tripsCard1.rank) == (tripsCard3.rank)))

				{
					// -------------------------------------------------------------------
					// If the cards make a set, then store the set rank
					// and look for a different pair:
					// -------------------------------------------------------------------
					result = true;
					this.setHandRank(RANK_TRIPS);
					this.setRankedHand(null);
					this.setRankedHand(new ArrayList(7));
					this.getRankedHand().add(tripsCard1);
					this.getRankedHand().add(tripsCard2);
					this.getRankedHand().add(tripsCard3);

					// Add the next 2 highest:
					ArrayList madeHandClone = (ArrayList) madeHand.clone();
					madeHandClone.remove(i + 2);
					madeHandClone.remove(i + 1);
					madeHandClone.remove(i);

					this.getRankedHand().add(madeHandClone.get(0));
					this.getRankedHand().add(madeHandClone.get(1));
				}
			}
		}

		return result;

	}

	/**
	 * This function determines if the hand is Two Pair:
	 * 
	 * @return
	 */
	public boolean isTwoPair()
	{
		boolean result = false;

		// -------------------------------------------------------------------
		// Verify that there are enough cards to rank:
		// -------------------------------------------------------------------
		if ((hole1 == null) || (hole2 == null) || (flop1 == null)
				|| (flop2 == null) || (flop3 == null))
		{
			result = false;
		}
		else
		{
			Card pairOneCard1 = null;
			Card pairOneCard2 = null;
			Card pairTwoCard1 = null;
			Card pairTwoCard2 = null;

			int pairOneRank = 0;

			// -------------------------------------------------------------------
			// Copy the made hand array so we don't bunk it up
			// -------------------------------------------------------------------
			ArrayList madeHandClone = (ArrayList) madeHand.clone();

			// -------------------------------------------------------------------
			// Look for a set of trips in the hand, if one is found
			// then look for a different pair:
			// -------------------------------------------------------------------
			for (int i = 0; i < madeHandClone.size() - 1; i++)
			{
				pairOneCard1 = (Card) madeHandClone.get(i);
				pairOneCard2 = (Card) madeHandClone.get(i + 1);

				if ((pairOneCard1.rank) == (pairOneCard2.rank ))

				{
					// -------------------------------------------------------------------
					// If the cards make a pair, then store the pair rank
					// and look for a different pair:
					// -------------------------------------------------------------------
					madeHandClone.remove(i + 1);
					madeHandClone.remove(i);

					pairOneRank = pairOneCard1.rank;

					for (int j = 0; j < madeHandClone.size() - 1; j++)
					{
						pairTwoCard1 = (Card) madeHandClone.get(j);
						pairTwoCard2 = (Card) madeHandClone.get(j + 1);

						// -------------------------------------------------------------------
						// If we found a pair, not of the rank of the
						// first pair, then we have two pair:
						// -------------------------------------------------------------------
						if ((pairTwoCard1.rank == pairTwoCard2.rank)
								&& (pairTwoCard1.rank != pairOneRank))
						{
							result = true;
							this.setHandRank(RANK_TWO_PAIR);
							this.setRankedHand(null);
							this.setRankedHand(new ArrayList(7));
							this.getRankedHand().add(pairOneCard1);
							this.getRankedHand().add(pairOneCard2);
							this.getRankedHand().add(pairTwoCard1);
							this.getRankedHand().add(pairTwoCard2);

							// Remove the paired cards and add the highest
							// remaining:
							madeHandClone.remove(j + 1);
							madeHandClone.remove(j);

							this.getRankedHand().add(madeHandClone.get(0));

						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * This function determines if the hand is a Pair:
	 * 
	 * @return
	 */
	public boolean isPair()
	{
		boolean result = false;

		// -------------------------------------------------------------------
		// Verify that there are enough cards to rank:
		// -------------------------------------------------------------------
		if ((hole1 == null) || (hole2 == null) || (flop1 == null)
				|| (flop2 == null) || (flop3 == null))
		{
			result = false;
		}
		else
		{
			Card pairOneCard1 = null;
			Card pairOneCard2 = null;

			// -------------------------------------------------------------------
			// Copy the made hand array so we don't bunk it up
			// -------------------------------------------------------------------
			ArrayList madeHandClone = (ArrayList) madeHand.clone();

			// -------------------------------------------------------------------
			// Look for a pair in the hand:
			// -------------------------------------------------------------------
			for (int i = 0; i < madeHandClone.size() - 1; i++)
			{
				pairOneCard1 = (Card) madeHandClone.get(i);
				pairOneCard2 = (Card) madeHandClone.get(i + 1);

				if ((pairOneCard1.rank) == (pairOneCard2.rank ))

				{
					// -------------------------------------------------------------------
					// If the cards make a pair, then store the pair rank
					// and look for a different pair:
					// -------------------------------------------------------------------
					result = true;
					this.setHandRank(RANK_PAIR);
					this.setRankedHand(null);
					this.setRankedHand(new ArrayList(7));
					this.getRankedHand().add(pairOneCard1);
					this.getRankedHand().add(pairOneCard2);

					// Remove the paired cards and add the highest
					// remaining:
					madeHandClone.remove(i + 1);
					madeHandClone.remove(i);

					this.getRankedHand().add(madeHandClone.get(0));
					this.getRankedHand().add(madeHandClone.get(1));
					this.getRankedHand().add(madeHandClone.get(2));

				}
			}
		}

		return result;

	}

	/**
	 * This function is called only when we know the hand is nothing. It makes
	 * the rankedHand array be set to the high card hand:
	 * 
	 * @return
	 */
	public boolean isHighCard()
	{
		boolean result = false;

		// -------------------------------------------------------------------
		// Verify that there are enough cards to rank:
		// -------------------------------------------------------------------
		if ((hole1 == null) || (hole2 == null) || (flop1 == null)
				|| (flop2 == null) || (flop3 == null))
		{
			result = false;
		}
		else
		{
			result = true;
			this.setHandRank(RANK_HIGH_CARD);
			this.setRankedHand(null);
			this.setRankedHand(new ArrayList(7));
			this.getRankedHand().add(madeHand.get(0));
			this.getRankedHand().add(madeHand.get(1));
			this.getRankedHand().add(madeHand.get(2));

			if (madeHand.size() <= 4)
			{
				// Break here
				System.out.println("ERROR!");
			}
			this.getRankedHand().add(madeHand.get(3));
			this.getRankedHand().add(madeHand.get(4));
		}

		return result;

	}

	/**
	 * This function fills the made hand member variable.
	 * 
	 */
	public boolean makeMadeHand()
	{

		// Initialize the madeHand object:
		madeHand = new ArrayList(7);

		if (hole1 != null)
		{
			madeHand.add(hole1);
		}

		if (hole2 != null)
		{
			madeHand.add(hole2);
		}

		if (flop1 != null)
		{
			madeHand.add(flop1);
		}

		if (flop2 != null)
		{
			madeHand.add(flop2);
		}

		if (flop3 != null)
		{
			madeHand.add(flop3);
		}

		if (turn != null)
		{
			madeHand.add(turn);
		}

		if (river != null)
		{
			madeHand.add(river);
		}

		// Sort the cards in the hand, so we can rank it:
		Collections.sort(madeHand, new DescendingCardComparator());

		if (madeHand.size() < 5)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Prints the HoldEmHand in a nice way:
	 */
	public String toString()
	{
		String result = "";
		// If there is a ranked hand, print it:
		if (this.getRankedHand() != null)
		{
			result += this.getHandRankString() + ": " + this.getRankedHand();
		}
		else
		{
			// Print the hand cards:
			result += "[" + ((hole1 != null) ? hole1.toString() : "-") + " ";
			result += ((hole2 != null) ? hole2.toString() : "-") + " ";
			result += ((flop1 != null) ? flop1.toString() : "-") + " ";
			result += ((flop2 != null) ? flop2.toString() : "-") + " ";
			result += ((flop3 != null) ? flop3.toString() : "-") + " ";
			result += ((turn != null) ? turn.toString() : "-") + " ";
			result += ((river != null) ? river.toString() : "-") + "]";

		}

		return result;
	}

	public ArrayList getRankedHand()
	{
		return rankedHand;
	}

	public void setRankedHand(ArrayList rankedHand)
	{
		this.rankedHand = rankedHand;
	}

	/**
	 * This method is used to test the class.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Suit clubsSuit = new Suit(Suit.CLUBS);
		Suit heartsSuit = new Suit(Suit.HEARTS);
		Suit diamondsSuit = new Suit(Suit.DIAMONDS);
		Suit spadesSuit = new Suit(Suit.SPADES);

		// -----------------------------------------------------------------
		// Test the Straight Flush Ranking Function:
		// -----------------------------------------------------------------
		HoldEmHand straightFlushTest = new HoldEmHand();
		straightFlushTest.setHole1(new Card(Card.RANK_KING, clubsSuit));
		straightFlushTest.setHole2(new Card(Card.RANK_QUEEN, clubsSuit));
		straightFlushTest.setFlop1(new Card(Card.RANK_JACK, clubsSuit));
		straightFlushTest.setFlop2(new Card(10, clubsSuit));
		straightFlushTest.setFlop3(new Card(9, clubsSuit));
		straightFlushTest.setTurn(new Card(9, heartsSuit));
		straightFlushTest.setRiver(new Card(3, heartsSuit));

		straightFlushTest.rankHand();
		System.out.println("Straight Flush Test Hand: " + straightFlushTest);

		// -----------------------------------------------------------------
		// Test the Quads Ranking Function:
		// -----------------------------------------------------------------
		HoldEmHand quadsTest = new HoldEmHand();
		quadsTest.setHole1(new Card(10, diamondsSuit));
		quadsTest.setHole2(new Card(10, spadesSuit));
		quadsTest.setFlop1(new Card(10, clubsSuit));
		quadsTest.setFlop2(new Card(3, heartsSuit));
		quadsTest.setFlop3(new Card(9, clubsSuit));
		quadsTest.setTurn(new Card(9, heartsSuit));
		quadsTest.setRiver(new Card(10, heartsSuit));

		quadsTest.rankHand();
		System.out.println("Quads Test Hand: " + quadsTest);

		// -----------------------------------------------------------------
		// Test the Full House Ranking Function:
		// -----------------------------------------------------------------
		HoldEmHand fullHouseTest = new HoldEmHand();
		fullHouseTest.setHole1(new Card(10, diamondsSuit));
		fullHouseTest.setHole2(new Card(10, spadesSuit));
		fullHouseTest.setFlop1(new Card(10, clubsSuit));
		fullHouseTest.setFlop2(new Card(3, heartsSuit));
		fullHouseTest.setFlop3(new Card(3, clubsSuit));
		fullHouseTest.setTurn(new Card(4, heartsSuit));
		fullHouseTest.setRiver(new Card(7, heartsSuit));

		fullHouseTest.rankHand();
		System.out.println("Full House Test Hand: " + fullHouseTest);

		// -----------------------------------------------------------------
		// Test the Flush Ranking Function:
		// -----------------------------------------------------------------
		HoldEmHand flushTest = new HoldEmHand();
		flushTest.setHole1(new Card(10, heartsSuit));
		flushTest.setHole2(new Card(7, spadesSuit));
		flushTest.setFlop1(new Card(4, heartsSuit));
		flushTest.setFlop2(new Card(Card.RANK_ACE, heartsSuit));
		flushTest.setFlop3(new Card(3, heartsSuit));
		flushTest.setTurn(new Card(4, spadesSuit));
		flushTest.setRiver(new Card(7, heartsSuit));

		flushTest.rankHand();
		System.out.println("Flush Test Hand: " + flushTest);

		// -----------------------------------------------------------------
		// Test the Flush Ranking Function:
		// -----------------------------------------------------------------
		HoldEmHand straightTest = new HoldEmHand();
		straightTest.setHole1(new Card(10, heartsSuit));
		straightTest.setHole2(new Card(9, spadesSuit));
		straightTest.setFlop1(new Card(8, diamondsSuit));
		straightTest.setFlop2(new Card(7, clubsSuit));
		straightTest.setFlop3(new Card(6, heartsSuit));
		straightTest.setTurn(new Card(2, spadesSuit));
		straightTest.setRiver(new Card(3, heartsSuit));

		straightTest.rankHand();
		System.out.println("Straight Test Hand: " + straightTest);

		// -----------------------------------------------------------------
		// Test the Two Pair Ranking Function:
		// -----------------------------------------------------------------
		HoldEmHand twoPairTest = new HoldEmHand();
		twoPairTest.setHole1(new Card(10, heartsSuit));
		twoPairTest.setHole2(new Card(10, spadesSuit));
		twoPairTest.setFlop1(new Card(4, heartsSuit));
		twoPairTest.setFlop2(new Card(4, spadesSuit));
		twoPairTest.setFlop3(new Card(3, heartsSuit));
		twoPairTest.setTurn(new Card(6, spadesSuit));
		twoPairTest.setRiver(new Card(7, heartsSuit));

		twoPairTest.rankHand();
		System.out.println("Two Pair Test Hand: " + twoPairTest);

		// -----------------------------------------------------------------
		// Test the Pair Ranking Function:
		// -----------------------------------------------------------------
		HoldEmHand pairTest = new HoldEmHand();
		pairTest.setHole1(new Card(10, heartsSuit));
		pairTest.setHole2(new Card(10, spadesSuit));
		pairTest.setFlop1(new Card(5, heartsSuit));
		pairTest.setFlop2(new Card(9, spadesSuit));
		pairTest.setFlop3(new Card(2, heartsSuit));
		pairTest.setTurn(new Card(6, spadesSuit));
		pairTest.setRiver(new Card(7, heartsSuit));

		pairTest.rankHand();
		System.out.println("Pair Test Hand: " + pairTest);

		// -----------------------------------------------------------------
		// Test the High Card Ranking Function:
		// -----------------------------------------------------------------
		HoldEmHand highCardTest = new HoldEmHand();
		highCardTest.setHole1(new Card(2, heartsSuit));
		highCardTest.setHole2(new Card(4, spadesSuit));
		highCardTest.setFlop1(new Card(6, heartsSuit));
		highCardTest.setFlop2(new Card(9, spadesSuit));
		highCardTest.setFlop3(new Card(8, heartsSuit));
		highCardTest.setTurn(new Card(Card.RANK_KING, spadesSuit));
		highCardTest.setRiver(new Card(10, heartsSuit));

		highCardTest.rankHand();
		System.out.println("High Card Test Hand: " + highCardTest);

		// -----------------------------------------------------------------
		// Test Comparing hands Ranking Function:
		// -----------------------------------------------------------------
		System.out.println("Comparing Full House Hand to High Card: "
				+ fullHouseTest.compareTo(highCardTest));
		System.out.println("Comparing High Card Hand to Full House : "
				+ highCardTest.compareTo(fullHouseTest));
		System.out.println("Comparing High Card Hand to itself : "
				+ highCardTest.compareTo(highCardTest));
	}

	/**
	 * This method is used to compare HoldEmHands to see which is "better".
	 * 
	 * @param arg0
	 * @return
	 */
	public int compareTo(Object arg0)
	{
		// -------------------------------------------------------------------
		// If we don't have anything we can compare to return 0;
		// -------------------------------------------------------------------
		if ((arg0 == null) || ((arg0 instanceof HoldEmHand) != true))
		{
			return 0;
		}
		else
		{
			HoldEmHand otherHand = (HoldEmHand) arg0;

			// Rank both hands so we can actually compare them:
			this.rankHand();
			otherHand.rankHand();

			// Compare the ranks of the hands to see if one is clearly better:
			if (this.getHandRank() > otherHand.getHandRank())
			{
				return 1;
			}
			else
			{
				if (this.getHandRank() < otherHand.getHandRank())
				{
					return -1;
				}
				else
				{
					// -------------------------------------------------------------------
					// The hands have the same rank, so we need to compare them
					// card by card to see which is better:
					// -------------------------------------------------------------------
					ArrayList otherHandCards = otherHand.getRankedHand();
					Card thisHandCard = null;
					Card otherHandCard = null;
					int cardCompareResult = 0;

					// Compare Cards:
					for (int i = 0; (this.getRankedHand().size() >= 5)
							&& (otherHand.getRankedHand().size() >= 5)
							&& (i < 5); i++)
					{
						thisHandCard = (Card) this.getRankedHand().get(i);
						otherHandCard = (Card) otherHandCards.get(i);

						cardCompareResult = thisHandCard
								.compareTo(otherHandCard);

						// -------------------------------------------------------------------
						// If the cards are anything but equal, return the
						// result, as that
						// shows which hand is better. If the hands are
						// identical, then we will return 0 below:
						// -------------------------------------------------------------------
						if (cardCompareResult != 0)
						{
							return cardCompareResult;
						}
					}
				}
			}
		}

		return 0;
	}

	/**
	 * This method uses the compareTo method to do the dirty work.
	 */
	public boolean equals(Object e)
	{
		return (this.compareTo(e) == 0);
	}

	/**
	 * Returns a new HoldEmHand that contains the same cards as this hand:
	 */
	public Object clone()
	{
		HoldEmHand clonedHand = new HoldEmHand();
		
		// Set the cards of the cloned hand:
		clonedHand.setHole1(this.getHole1());
		clonedHand.setHole1(this.getHole2());
		clonedHand.setFlop1(this.getFlop1());
		clonedHand.setFlop2(this.getFlop2());
		clonedHand.setFlop3(this.getFlop3());
		clonedHand.setTurn(this.getTurn());
		clonedHand.setRiver(this.getRiver());
		
		// Rank the hand:
		clonedHand.rankHand();
		
		return clonedHand;
		
	}
	
}
