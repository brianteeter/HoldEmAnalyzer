package com.assorted.poker.gui;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.assorted.poker.model.Card;
import com.assorted.poker.model.HoldEmHand;
import com.assorted.poker.model.Suit;

/**
 * This class will be used to allow the selection of cards for a hand.
 * 
 * @author Brian Teeter
 * 
 */
public class JHandSpecificationPanel extends JPanel
{
	// ==========================================================
	// These GUI components will show up on the panel for the
	// user to enter in the hand:
	// ==========================================================
	JLabel handLabel = null;

	JCardButton card1Button = null;

	JCardButton card2Button = null;

	/**
	 * Default Constructor
	 */public JHandSpecificationPanel()
	{
		initPanel();
	}
	
	/**
	 * Panel Naming Constructor
	 */
	public JHandSpecificationPanel(String panelName)
	{
		initPanel();
		this.setBorder(new TitledBorder(panelName));
	}
	
	/**
	 * Initialize the Panel:
	 */
	public void initPanel()
	{
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		handLabel = new JLabel("Hand: ");
		card1Button = new JCardButton();
		card2Button = new JCardButton();
		
		this.add(handLabel);
		this.add(card1Button);
		this.add(card2Button);
	}

	/**
	 * This method is used by external interfaces to get the cards specified in
	 * the field
	 */
	public HoldEmHand getHand()
	{
		if ((card1Button.getCard() == null) || (card2Button.getCard() == null))
		{
			return null;
		}
		
		// Translate what the user entered into 2 cards:
		Card card1 = card1Button.getCard();
		Card card2 = card2Button.getCard();;

		
		// Create the hand and return it:
		HoldEmHand currentHand = new HoldEmHand(card1, card2);

		return currentHand;
	}

	/**
	 * This method is used to translate the card string into a Card.
	 */
	public Card translateCard(String cardString)
	{
		Card returnCard = new Card();

		// Make sure we have a string to process:
		if ((cardString != null) && (cardString.length() == 2))
		{
			// Look at the first character, the rank character:
			String rank = cardString.substring(0, 1);
			String suit = cardString.substring(1, 2);

			// If its an ace:
			if (rank.equalsIgnoreCase("A") == true)
			{
				returnCard.setRank(Card.RANK_ACE);
			}
			else
			{
				if (rank.equalsIgnoreCase("K") == true)
				{
					returnCard.setRank(Card.RANK_KING);
				}
				else
				{
					if (rank.equalsIgnoreCase("Q") == true)
					{
						returnCard.setRank(Card.RANK_QUEEN);
					}
					else
					{
						if (rank.equalsIgnoreCase("J") == true)
						{
							returnCard.setRank(Card.RANK_JACK);
						}
						else
						{
							if (rank.equalsIgnoreCase("T") == true)
							{
								returnCard.setRank(10);
							}
							else
							{
								returnCard.setRank(Integer.parseInt(rank));
							}
						}
					}
				}
			}

			// Handle the suit:
			if (suit.equalsIgnoreCase("s") == true)
			{
				returnCard.setSuit(Suit.SPADES);
			}
			else
			{
				if (suit.equalsIgnoreCase("h") == true)
				{
					returnCard.setSuit(Suit.HEARTS);
				}
				else
				{
					if (suit.equalsIgnoreCase("d") == true)
					{
						returnCard.setSuit(Suit.DIAMONDS);
					}
					else
					{
						if (suit.equalsIgnoreCase("c") == true)
						{
							returnCard.setSuit(Suit.CLUBS);
						}
					}
				}
			}

		}

		// Return the Card:
		return returnCard;
	}

	/**
	 * Clear the field so user can enter new cards
	 *
	 */
	public void clear()
	{
		this.card1Button.setCard(null);
		this.card2Button.setCard(null);
	}
	
	public JCardButton getCard1Button()
	{
		return card1Button;
	}

	public void setCard1Button(JCardButton card1Button)
	{
		this.card1Button = card1Button;
	}

	public JCardButton getCard2Button()
	{
		return card2Button;
	}

	public void setCard2Button(JCardButton card2Button)
	{
		this.card2Button = card2Button;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}