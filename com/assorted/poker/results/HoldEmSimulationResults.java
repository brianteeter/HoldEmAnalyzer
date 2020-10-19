package com.assorted.poker.results;

import java.text.DecimalFormat;

import com.assorted.poker.model.HoldEmHand;

/**
 * This class is used to contain data from simulations run.
 * 
 * @author Brian Teeter
 * 
 */
public class HoldEmSimulationResults
{
	HoldEmHand theHand = null;

	int handCount = 0;

	int winRoyalFlush = 0;

	int splitRoyalFlush = 0;

	int loseRoyalFlush = 0;

	int winStraightFlush = 0;

	int splitStraightFlush = 0;

	int loseStraightFlush = 0;

	int winQuads = 0;

	int splitQuads = 0;

	int loseQuads = 0;

	int winFullHouse = 0;

	int splitFullHouse = 0;

	int loseFullHouse = 0;

	int winFlush = 0;

	int splitFlush = 0;

	int loseFlush = 0;

	int winStraight = 0;

	int splitStraight = 0;

	int loseStraight = 0;

	int winTrips = 0;

	int splitTrips = 0;

	int loseTrips = 0;

	int winTwoPair = 0;

	int splitTwoPair = 0;

	int loseTwoPair = 0;

	int winPair = 0;

	int splitPair = 0;

	int losePair = 0;

	int winHighCard = 0;

	int splitHighCard = 0;

	int loseHighCard = 0;

	public int getHandCount()
	{
		return handCount;
	}

	public void setHandCount(int handCount)
	{
		this.handCount = handCount;
	}

	public int getLoseFlush()
	{
		return loseFlush;
	}

	public void setLoseFlush(int loseFlush)
	{
		this.loseFlush = loseFlush;
	}

	public int getLoseFullHouse()
	{
		return loseFullHouse;
	}

	public void setLoseFullHouse(int loseFullHouse)
	{
		this.loseFullHouse = loseFullHouse;
	}

	public int getLoseHighCard()
	{
		return loseHighCard;
	}

	public void setLoseHighCard(int loseHighCard)
	{
		this.loseHighCard = loseHighCard;
	}

	public int getLosePair()
	{
		return losePair;
	}

	public void setLosePair(int losePair)
	{
		this.losePair = losePair;
	}

	public int getLoseQuads()
	{
		return loseQuads;
	}

	public void setLoseQuads(int loseQuads)
	{
		this.loseQuads = loseQuads;
	}

	public int getLoseRoyalFlush()
	{
		return loseRoyalFlush;
	}

	public void setLoseRoyalFlush(int loseRoyalFlush)
	{
		this.loseRoyalFlush = loseRoyalFlush;
	}

	public int getLoseStraight()
	{
		return loseStraight;
	}

	public void setLoseStraight(int loseStraight)
	{
		this.loseStraight = loseStraight;
	}

	public int getLoseStraightFlush()
	{
		return loseStraightFlush;
	}

	public void setLoseStraightFlush(int loseStraightFlush)
	{
		this.loseStraightFlush = loseStraightFlush;
	}

	public int getLoseTrips()
	{
		return loseTrips;
	}

	public void setLoseTrips(int loseTrips)
	{
		this.loseTrips = loseTrips;
	}

	public int getLoseTwoPair()
	{
		return loseTwoPair;
	}

	public void setLoseTwoPair(int loseTwoPair)
	{
		this.loseTwoPair = loseTwoPair;
	}

	public int getSplitFlush()
	{
		return splitFlush;
	}

	public void setSplitFlush(int splitFlush)
	{
		this.splitFlush = splitFlush;
	}

	public int getSplitFullHouse()
	{
		return splitFullHouse;
	}

	public void setSplitFullHouse(int splitFullHouse)
	{
		this.splitFullHouse = splitFullHouse;
	}

	public int getSplitHighCard()
	{
		return splitHighCard;
	}

	public void setSplitHighCard(int splitHighCard)
	{
		this.splitHighCard = splitHighCard;
	}

	public int getSplitPair()
	{
		return splitPair;
	}

	public void setSplitPair(int splitPair)
	{
		this.splitPair = splitPair;
	}

	public int getSplitQuads()
	{
		return splitQuads;
	}

	public void setSplitQuads(int splitQuads)
	{
		this.splitQuads = splitQuads;
	}

	public int getSplitRoyalFlush()
	{
		return splitRoyalFlush;
	}

	public void setSplitRoyalFlush(int splitRoyalFlush)
	{
		this.splitRoyalFlush = splitRoyalFlush;
	}

	public int getSplitStraight()
	{
		return splitStraight;
	}

	public void setSplitStraight(int splitStraight)
	{
		this.splitStraight = splitStraight;
	}

	public int getSplitStraightFlush()
	{
		return splitStraightFlush;
	}

	public void setSplitStraightFlush(int splitStraightFlush)
	{
		this.splitStraightFlush = splitStraightFlush;
	}

	public int getSplitTrips()
	{
		return splitTrips;
	}

	public void setSplitTrips(int splitTrips)
	{
		this.splitTrips = splitTrips;
	}

	public int getSplitTwoPair()
	{
		return splitTwoPair;
	}

	public void setSplitTwoPair(int splitTwoPair)
	{
		this.splitTwoPair = splitTwoPair;
	}

	public int getWinFlush()
	{
		return winFlush;
	}

	public void setWinFlush(int winFlush)
	{
		this.winFlush = winFlush;
	}

	public int getWinFullHouse()
	{
		return winFullHouse;
	}

	public void setWinFullHouse(int winFullHouse)
	{
		this.winFullHouse = winFullHouse;
	}

	public int getWinHighCard()
	{
		return winHighCard;
	}

	public void setWinHighCard(int winHighCard)
	{
		this.winHighCard = winHighCard;
	}

	public int getWinPair()
	{
		return winPair;
	}

	public void setWinPair(int winPair)
	{
		this.winPair = winPair;
	}

	public int getWinQuads()
	{
		return winQuads;
	}

	public void setWinQuads(int winQuads)
	{
		this.winQuads = winQuads;
	}

	public int getWinRoyalFlush()
	{
		return winRoyalFlush;
	}

	public void setWinRoyalFlush(int winRoyalFlush)
	{
		this.winRoyalFlush = winRoyalFlush;
	}

	public int getWinStraight()
	{
		return winStraight;
	}

	public void setWinStraight(int winStraight)
	{
		this.winStraight = winStraight;
	}

	public int getWinStraightFlush()
	{
		return winStraightFlush;
	}

	public void setWinStraightFlush(int winStraightFlush)
	{
		this.winStraightFlush = winStraightFlush;
	}

	public int getWinTrips()
	{
		return winTrips;
	}

	public void setWinTrips(int winTrips)
	{
		this.winTrips = winTrips;
	}

	public int getWinTwoPair()
	{
		return winTwoPair;
	}

	public void setWinTwoPair(int winTwoPair)
	{
		this.winTwoPair = winTwoPair;
	}

	/**
	 * This function adds a split result to the appropriate rank member variable
	 * 
	 * @param handRank
	 */
	public void addSplitResult(int handRank)
	{
		if (handRank <= 0)
		{
			System.out.println("ERROR: Cannot add split result with no rank.");
			return;
		}
		else
		{
			if (handRank == HoldEmHand.RANK_ROYAL_FLUSH)
			{
				splitRoyalFlush++;
			}

			if (handRank == HoldEmHand.RANK_STRAIGHT_FLUSH)
			{
				splitStraightFlush++;
			}

			if (handRank == HoldEmHand.RANK_QUADS)
			{
				splitQuads++;
			}

			if (handRank == HoldEmHand.RANK_FULL_HOUSE)
			{
				splitFullHouse++;
			}

			if (handRank == HoldEmHand.RANK_FLUSH)
			{
				splitFlush++;
			}

			if (handRank == HoldEmHand.RANK_STRAIGHT)
			{
				splitStraight++;
			}

			if (handRank == HoldEmHand.RANK_TRIPS)
			{
				splitTrips++;
			}

			if (handRank == HoldEmHand.RANK_TWO_PAIR)
			{
				splitTwoPair++;
			}

			if (handRank == HoldEmHand.RANK_PAIR)
			{
				splitPair++;
			}

			if (handRank == HoldEmHand.RANK_HIGH_CARD)
			{
				splitHighCard++;
			}
		}

	}

	/**
	 * Returns a percentage as a string, based on the count of occurances/hand
	 * count.
	 */
	public String calculatePercentage(int count)
	{
		String result = "";
		double percent = ((double) count / (double) this.getHandCount());

		DecimalFormat formatter = new DecimalFormat("00.00");
		result += formatter.format(percent * 100) + "%";

		return result;
	}

	/**
	 * Prints the results object into a nicely formatted string.
	 */
	public String toString()
	{
		String result = "Hands: " + this.getHandCount() + "\n\n";
		result += "MADE HAND:    WIN %:    SPLIT %:     LOSS %:    \n";
		result += "=================================================\n";
		result += "High Card:    " + calculatePercentage(this.getWinHighCard())
				+ "    " + calculatePercentage(this.getSplitHighCard())
				+ "      " + calculatePercentage(this.getLoseHighCard()) + "\n";

		result += "Pair:         " + calculatePercentage(this.getWinPair())
				+ "    " + calculatePercentage(this.getSplitPair()) + "      "
				+ calculatePercentage(this.getLosePair()) + "\n";

		result += "Two Pair:     " + calculatePercentage(this.getWinTwoPair())
				+ "    " + calculatePercentage(this.getSplitTwoPair())
				+ "      " + calculatePercentage(this.getLoseTwoPair()) + "\n";

		result += "Trips:        " + calculatePercentage(this.getWinTrips())
				+ "    " + calculatePercentage(this.getSplitTrips()) + "      "
				+ calculatePercentage(this.getLoseTrips()) + "\n";

		result += "Straight:     " + calculatePercentage(this.getWinStraight())
				+ "    " + calculatePercentage(this.getSplitStraight())
				+ "      " + calculatePercentage(this.getLoseStraight()) + "\n";

		result += "Flush:        " + calculatePercentage(this.getWinFlush())
				+ "    " + calculatePercentage(this.getSplitFlush()) + "      "
				+ calculatePercentage(this.getLoseFlush()) + "\n";

		result += "Full House:   "
				+ calculatePercentage(this.getWinFullHouse()) + "    "
				+ calculatePercentage(this.getSplitFullHouse()) + "      "
				+ calculatePercentage(this.getLoseFullHouse()) + "\n";

		result += "Quads:        " + calculatePercentage(this.getWinQuads())
				+ "    " + calculatePercentage(this.getSplitQuads()) + "      "
				+ calculatePercentage(this.getLoseQuads()) + "\n";

		result += "Str. Flush    "
				+ calculatePercentage(this.getWinStraightFlush()) + "    "
				+ calculatePercentage(this.getSplitStraightFlush()) + "      "
				+ calculatePercentage(this.getLoseStraightFlush()) + "\n";

		result += "Royal Flush   "
				+ calculatePercentage(this.getWinRoyalFlush()) + "    "
				+ calculatePercentage(this.getSplitRoyalFlush()) + "      "
				+ calculatePercentage(this.getLoseRoyalFlush()) + "\n";

		result += "=================================================\n";

		result += "OVERALL:      "
				+ calculatePercentage(this.getWinRoyalFlush()
						+ this.getWinStraightFlush() + this.getWinQuads()
						+ this.getWinFullHouse() + this.getWinFlush()
						+ this.getWinStraight() + this.getWinTrips()
						+ this.getWinTwoPair() + this.getWinPair()
						+ this.getWinHighCard())
				+ "    "
				+ calculatePercentage(this.getSplitRoyalFlush()
						+ this.getSplitStraightFlush() + this.getSplitQuads()
						+ this.getSplitFullHouse() + this.getSplitFlush()
						+ this.getSplitStraight() + this.getSplitTrips()
						+ this.getSplitTwoPair() + this.getSplitPair()
						+ this.getSplitHighCard())
				+ "      "
				+ calculatePercentage(this.getLoseRoyalFlush()
						+ this.getLoseStraightFlush() + this.getLoseQuads()
						+ this.getLoseFullHouse() + this.getLoseFlush()
						+ this.getLoseStraight() + this.getLoseTrips()
						+ this.getLoseTwoPair() + this.getLosePair()
						+ this.getLoseHighCard()) + "\n";

		return result;
	}

	/**
	 * Return the # of wins.
	 * 
	 * @return
	 */
	public int getWinTotals()
	{
		int winResultCount = 0;

		winResultCount = this.getWinRoyalFlush() + this.getWinStraightFlush()
				+ this.getWinQuads() + this.getWinFullHouse()
				+ this.getWinFlush() + this.getWinStraight()
				+ this.getWinTrips() + this.getWinTwoPair() + this.getWinPair()
				+ this.getWinHighCard();

		return winResultCount;

	}

	/**
	 * Return the # of splits.
	 * 
	 * @return
	 */
	public int getSplitTotals()
	{
		int splitResultCount = 0;

		splitResultCount = this.getSplitRoyalFlush()
				+ this.getSplitStraightFlush() + this.getSplitQuads()
				+ this.getSplitFullHouse() + this.getSplitFlush()
				+ this.getSplitStraight() + this.getSplitTrips()
				+ this.getSplitTwoPair() + this.getSplitPair()
				+ this.getSplitHighCard();

		return splitResultCount;

	}

	/**
	 * Return the # of losses.
	 * 
	 * @return
	 */
	public int getLossTotals()
	{
		int lossResultCount = 0;

		lossResultCount = this.getLoseRoyalFlush()
				+ this.getLoseStraightFlush() + this.getLoseQuads()
				+ this.getLoseFullHouse() + this.getLoseFlush()
				+ this.getLoseStraight() + this.getLoseTrips()
				+ this.getLoseTwoPair() + this.getLosePair()
				+ this.getLoseHighCard();

		return lossResultCount;

	}

	/**
	 * This method adds a Split result to the results, and increments the hand
	 * counter.
	 * 
	 * @param hand
	 */
	public void insertSplitResult(HoldEmHand hand)
	{
		// Increment the hand counter:
		this.handCount++;

		// -------------------------------------------------------
		// Add the split to the proper area of the results:
		// -------------------------------------------------------
		if (hand.getHandRank() == HoldEmHand.RANK_ROYAL_FLUSH)
		{
			this.setSplitRoyalFlush(this.getSplitRoyalFlush() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_STRAIGHT_FLUSH)
		{
			this.setSplitStraightFlush(this.getSplitStraightFlush() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_QUADS)
		{
			this.setSplitQuads(this.getSplitQuads() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_FULL_HOUSE)
		{
			this.setSplitFullHouse(this.getSplitFullHouse() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_FLUSH)
		{
			this.setSplitFlush(this.getSplitFlush() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_STRAIGHT)
		{
			this.setSplitStraight(this.getSplitStraight() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_TRIPS)
		{
			this.setSplitTrips(this.getSplitTrips() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_TWO_PAIR)
		{
			this.setSplitTwoPair(this.getSplitTwoPair() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_PAIR)
		{
			this.setSplitPair(this.getSplitPair() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_HIGH_CARD)
		{
			this.setSplitHighCard(this.getSplitHighCard() + 1);
		}
	}

	/**
	 * This method adds a Lose result to the results, and increments the hand
	 * counter.
	 * 
	 * @param hand
	 */
	public void insertLoseResult(HoldEmHand hand)
	{
		// Increment the hand counter:
		this.handCount++;

		// -------------------------------------------------------
		// Add the Lose to the proper area of the this:
		// -------------------------------------------------------
		if (hand.getHandRank() == HoldEmHand.RANK_ROYAL_FLUSH)
		{
			this.setLoseRoyalFlush(this.getLoseRoyalFlush() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_STRAIGHT_FLUSH)
		{
			this.setLoseStraightFlush(this.getLoseStraightFlush() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_QUADS)
		{
			this.setLoseQuads(this.getLoseQuads() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_FULL_HOUSE)
		{
			this.setLoseFullHouse(this.getLoseFullHouse() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_FLUSH)
		{
			this.setLoseFlush(this.getLoseFlush() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_STRAIGHT)
		{
			this.setLoseStraight(this.getLoseStraight() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_TRIPS)
		{
			this.setLoseTrips(this.getLoseTrips() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_TWO_PAIR)
		{
			this.setLoseTwoPair(this.getLoseTwoPair() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_PAIR)
		{
			this.setLosePair(this.getLosePair() + 1);
		}

		if (hand.getHandRank() == HoldEmHand.RANK_HIGH_CARD)
		{
			this.setLoseHighCard(this.getLoseHighCard() + 1);
		}
	}

	/**
	 * This method adds a Win result to the results, and increments the hand
	 * counter.
	 * 
	 * @param hand
	 */
	public void insertWinResult(HoldEmHand hand)
	{
		// Increment the hand counter:
		this.handCount++;

		int handRank = hand.getHandRank();

		// -------------------------------------------------------
		// Add the Win to the proper area of the this:
		// -------------------------------------------------------
		if (handRank == HoldEmHand.RANK_ROYAL_FLUSH)
		{
			this.setWinRoyalFlush(this.getWinRoyalFlush() + 1);
		}

		if (handRank == HoldEmHand.RANK_STRAIGHT_FLUSH)
		{
			this.setWinStraightFlush(this.getWinStraightFlush() + 1);
		}

		if (handRank == HoldEmHand.RANK_QUADS)
		{
			this.setWinQuads(this.getWinQuads() + 1);
		}

		if (handRank == HoldEmHand.RANK_FULL_HOUSE)
		{
			this.setWinFullHouse(this.getWinFullHouse() + 1);
		}

		if (handRank == HoldEmHand.RANK_FLUSH)
		{
			this.setWinFlush(this.getWinFlush() + 1);
		}

		if (handRank == HoldEmHand.RANK_STRAIGHT)
		{
			this.setWinStraight(this.getWinStraight() + 1);
		}

		if (handRank == HoldEmHand.RANK_TRIPS)
		{
			this.setWinTrips(this.getWinTrips() + 1);
		}

		if (handRank == HoldEmHand.RANK_TWO_PAIR)
		{
			this.setWinTwoPair(this.getWinTwoPair() + 1);
		}

		if (handRank == HoldEmHand.RANK_PAIR)
		{
			this.setWinPair(this.getWinPair() + 1);
		}

		if (handRank == HoldEmHand.RANK_HIGH_CARD)
		{
			this.setWinHighCard(this.getWinHighCard() + 1);
		}
	}

	/**
	 * This function returns a tab delimited string that can be used for
	 * creating a spreadsheet
	 * 
	 * @return
	 */
	public String toTabDelimString()
	{
		String result = "";

		int overallWin = (this.getWinRoyalFlush() + this.getWinStraightFlush()
				+ this.getWinQuads() + this.getWinFullHouse()
				+ this.getWinFlush() + this.getWinStraight()
				+ this.getWinTrips() + this.getWinTwoPair() + this.getWinPair() + this
				.getWinHighCard());

		int overallSplit = (this.getSplitRoyalFlush()
				+ this.getSplitStraightFlush() + this.getSplitQuads()
				+ this.getSplitFullHouse() + this.getSplitFlush()
				+ this.getSplitStraight() + this.getSplitTrips()
				+ this.getSplitTwoPair() + this.getSplitPair() + this
				.getSplitHighCard());

		int overallLose = this.getLoseRoyalFlush()
				+ this.getLoseStraightFlush() + this.getLoseQuads()
				+ this.getLoseFullHouse() + this.getLoseFlush()
				+ this.getLoseStraight() + this.getLoseTrips()
				+ this.getLoseTwoPair() + this.getLosePair()
				+ this.getLoseHighCard();

		float overallLosePct = (overallLose / this.getHandCount());

		result += this.getHandCount() + "\t";
		result += calculatePercentage(overallWin) + "\t"
				+ calculatePercentage(overallSplit) + "\t"
				+ calculatePercentage(overallLose) + "\t";

		result += calculatePercentage(this.getWinHighCard()) + "\t"
				+ calculatePercentage(this.getSplitHighCard()) + "\t"
				+ calculatePercentage(this.getLoseHighCard()) + "\t" +

				calculatePercentage(this.getWinPair()) + "\t"
				+ calculatePercentage(this.getSplitPair()) + "\t"
				+ calculatePercentage(this.getLosePair()) + "\t" +

				calculatePercentage(this.getWinTwoPair()) + "\t"
				+ calculatePercentage(this.getSplitTwoPair()) + "\t"
				+ calculatePercentage(this.getLoseTwoPair()) + "\t" +

				calculatePercentage(this.getWinTrips()) + "\t"
				+ calculatePercentage(this.getSplitTrips()) + "\t"
				+ calculatePercentage(this.getLoseTrips()) + "\t" +

				calculatePercentage(this.getWinStraight()) + "\t"
				+ calculatePercentage(this.getSplitStraight()) + "\t"
				+ calculatePercentage(this.getLoseStraight()) + "\t" +

				calculatePercentage(this.getWinFlush()) + "\t"
				+ calculatePercentage(this.getSplitFlush()) + "\t"
				+ calculatePercentage(this.getLoseFlush()) + "\t" +

				calculatePercentage(this.getWinFullHouse()) + "\t"
				+ calculatePercentage(this.getSplitFullHouse()) + "\t"
				+ calculatePercentage(this.getLoseFullHouse()) + "\t" +

				calculatePercentage(this.getWinQuads()) + "\t"
				+ calculatePercentage(this.getSplitQuads()) + "\t"
				+ calculatePercentage(this.getLoseQuads()) + "\t" +

				calculatePercentage(this.getWinStraightFlush()) + "\t"
				+ calculatePercentage(this.getSplitStraightFlush()) + "\t"
				+ calculatePercentage(this.getLoseStraightFlush()) + "\t" +

				calculatePercentage(this.getWinRoyalFlush()) + "\t"
				+ calculatePercentage(this.getSplitRoyalFlush()) + "\t"
				+ calculatePercentage(this.getLoseRoyalFlush()) + "\t";

		return result;
	}

	/**
	 * This function returns a tab delimited string that can be used for
	 * creating a spreadsheet
	 * 
	 * @return
	 */
	public String tabDelimHeaderString()
	{
		String result = "";
		result += "Hands\t Win/%\t Split/%\t Lose/%\t"
				+ "Win/HC\t Split/HC\t Lose/HC\t "
				+ "Win/P\t Split/P\t Lose/P\t"
				+ "Win/2P\t Split/2P\t Lose/2P\t"
				+ "Win/3K\t Split/3K\t Lose/3K\t"
				+ "Win/ST\t Split/ST\t Lose/ST\t"
				+ "Win/FL\t Split/FL\t Lose/FL\t"
				+ "Win/FH\t Split/FH\t Lose/FH\t"
				+ "Win/4K\t Split/4K\t Lose/4K\t"
				+ "Win/SF\t Split/SF\t Lose/SF\t"
				+ "Win/RF\t Split/RF\t Lose/RF\t" + "\n";

		return result;
	}

	public HoldEmHand getTheHand()
	{
		return theHand;
	}

	public void setTheHand(HoldEmHand theHand)
	{
		this.theHand = theHand;
	}
}
