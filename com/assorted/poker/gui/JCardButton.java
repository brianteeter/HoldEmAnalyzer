package com.assorted.poker.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import com.assorted.poker.model.Card;
import com.assorted.poker.model.Suit;

public class JCardButton extends JButton
{

	Font cardFont = new Font("Verdana", Font.BOLD, 11);
	Card card = null;

	public Card getCard()
	{
		return card;
	}

	public void setCard(Card newCard)
	{
		this.card = newCard;

		// Assuming we have a valid card, set the suit icon correctly:
		if (card != null)
		{

			if (card.getRank() == Card.RANK_ACE)
			{
				this.setText("A");
			}
			else
			{
				if (card.getRank() == Card.RANK_KING)
				{
					this.setText("K");
				}
				else
				{
					if (card.getRank() == Card.RANK_QUEEN)
					{
						this.setText("Q");
					}
					else
					{
						if (card.getRank() == Card.RANK_JACK)
						{
							this.setText("J");
						}
						else
						{
							if (card.getRank() == 10)
							{
								this.setText("T");
							}
							else
							{	
								this.setText("" + card.getRank());
							}
						}
					}
				}
			}

			// 
			if (card.getSuit().getSuit() == Suit.HEARTS)
			{
				this.setIcon(new ImageIcon("hearts.gif"));
			}
			if (card.getSuit().getSuit() == Suit.CLUBS)
			{
				this.setIcon(new ImageIcon("clubs.gif"));
			}
			if (card.getSuit().getSuit() == Suit.SPADES)
			{
				this.setIcon(new ImageIcon("spades.gif"));
			}
			if (card.getSuit().getSuit() == Suit.DIAMONDS)
			{
				this.setIcon(new ImageIcon("diamonds.gif"));
			}
		}
		else
		{
			// The card is null, so clear the button:
			this.setText("");
			this.setIcon(null);
		}

		if (card != null)
		{
			this.setActionCommand(card.toString());
		}
		
		this.setFont(cardFont);
	}

	/**
	 * Default constructor - makes a blank button
	 * 
	 */
	public JCardButton()
	{
		init();
	}

	/**
	 * Default constructor - makes a blank button
	 * 
	 */
	public JCardButton(Card newCard)
	{
		init();
		this.setCard(newCard);
	}
	
	/**
	 * This method initializes the card button properly:
	 *
	 */
	public void init()
	{
		this.setBorder( new JRoundedButtonBorder());

		this.setVerticalTextPosition(SwingConstants.TOP);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setIconTextGap(2);
		
		// Desired Dimensions:
		Insets insets = new Insets(1, 1, 1, 1);
		Dimension dim = new Dimension(17, 34);
		
		// this.setMargin(insets);
		this.setMinimumSize(dim);
		this.setMaximumSize(dim);
		this.setPreferredSize(dim);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
