package com.brianteeter.poker.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.brianteeter.poker.model.StandardDeck;

public class JAllCardsPanel extends JPanel
{

	StandardDeck newDeck = null;

	/**
	 * Create a new JAllCardsPanel and populate it with cards.
	 * 
	 */
	public JAllCardsPanel()
	{
		// Create the cards that will populate this panel:
		newDeck = new StandardDeck();

		// Set the layout to be 4x13, one row per suit:
		this.setLayout(new GridLayout(4, 13, 2, 2));

		/**
		 * Add each card as a button on the panel:
		 */
		while (newDeck != null && (newDeck.getDeck() != null)
				&& (newDeck.getDeck().size() > 0))
		{
			this.add(new JCardButton(newDeck.pullCard()));
		}

		// Set the border:
		this.setBorder(new TitledBorder("Card Selection"));
		Dimension dim = new Dimension((20*13), (30*4));
		this.setMaximumSize(dim);
	
	}
	
	/**
	 * 
	 * @param newListener
	 */
	public void setCardButtonActionListener(ActionListener newListener)
	{
		Component[] cardButtons = this.getComponents();
		
		if (cardButtons != null)
		{
			ArrayList cardButtonList = new ArrayList(Arrays.asList((cardButtons)));
			
			while (cardButtonList.isEmpty() == false)
			{
				((JCardButton)cardButtonList.get(0)).addActionListener(newListener);
				cardButtonList.remove(0);
			}
			
		}
	}
	
	/**
	 * This method sets all buttons visible once again.
	 */
	public void setAllVisible()
	{
		Component[] cardButtons = this.getComponents();
		
		if (cardButtons != null)
		{
			ArrayList cardButtonList = new ArrayList(Arrays.asList((cardButtons)));
			
			while (cardButtonList.isEmpty() == false)
			{
				((JCardButton)cardButtonList.get(0)).setVisible(true);
				cardButtonList.remove(0);
			}	
		}
	}
}
