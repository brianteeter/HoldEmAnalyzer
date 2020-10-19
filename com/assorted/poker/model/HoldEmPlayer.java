package com.assorted.poker.model;

/**
 * This class represents a HoldEmPlayer.
 * 
 * @author Brian Teeter
 * 
 */
public class HoldEmPlayer
{
	double bankroll = 0.0d;

	HoldEmHand hand = null;

	public double getBankroll()
	{
		return bankroll;
	}

	public void setBankroll(double bankroll)
	{
		this.bankroll = bankroll;
	}

	public HoldEmHand getHand()
	{
		return hand;
	}

	public void setHand(HoldEmHand hand)
	{
		this.hand = hand;
	}

	/**
	 * Default Constructor
	 */
	public HoldEmPlayer()
	{

	}

	/**
	 * Constructor that takes in the starting player bankroll.
	 * 
	 * @param bankroll
	 */
	public HoldEmPlayer(double newBankroll)
	{
		setBankroll(newBankroll);
	}

	/**
	 * Prints the HoldEmPlayer in a nice way:
	 */
	public String toString()
	{
		String result = "";
		result += "Bankroll: " + bankroll + "\n";
		
		// If a hand has been created/populated:
		if (hand != null)
		{
			hand.rankHand();
			result += "Hole : " + hand.getHole1() + " " + hand.getHole2()
					+ "   ";
			result += "Made Hand : " + hand;
		}

		return result;
	}
}
