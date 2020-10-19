package com.assorted.poker.model.comparators;

import java.util.Comparator;

import com.assorted.poker.model.Card;

/**
 * This object is used to descending sort cards in lists.
 * 
 * @author Brian Teeter
 * 
 */
public class DescendingCardComparator implements Comparator
{

	public int compare(Object arg0, Object arg1)
	{
		// If we don't have 2 Card objects to compare then we cannot do
		// a comparison, so return 0:
		if ((arg0 == null) || (arg1 == null)
				|| ((arg0 instanceof Card) == false)
				|| ((arg1 instanceof Card) == false))
		{
			return 0;
		}

		Card card0 = (Card) arg0;
		Card card1 = (Card) arg1;

		if (card0.getRank() > card1.getRank())
		{
			return -1;
		} 
		else
		{
			if (card0.getRank() < card1.getRank())
			{
				return 1;
			} 
			else
			{
				return 0;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
