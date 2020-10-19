package com.assorted.poker.gui;

import java.awt.Font;

import javax.swing.JPanel;

import com.assorted.poker.model.HoldEmHand;
import com.assorted.poker.results.HoldEmSimulationResults;

/**
 * Generic panel for multiple hand comparison results.
 * 
 * @author Brian Teeter
 *
 */
public class JMultiHandGenericResultsPanel extends JPanel
{
	protected Font defaultFont = new Font("Verdana", Font.PLAIN, 10);

	protected Font headerFont = new Font("Verdana", Font.BOLD, 12);
	
	protected Font chartHeaderFont = new Font("Verdana", Font.BOLD, 9);

	protected Font chartLabelFont = new Font("Verdana", Font.BOLD, 7);

	/**
	 * Basic constructor
	 *
	 */
	JMultiHandGenericResultsPanel()
	{
		
		
	}
	
	/**
	 * Stub method that is implemented in extending classes.
	 *
	 */
	public void insertResults(HoldEmHand h1, HoldEmHand h2, HoldEmHand h3,
			HoldEmHand h4, HoldEmSimulationResults hand1,
			HoldEmSimulationResults hand2, HoldEmSimulationResults hand3,
			HoldEmSimulationResults hand4)
	{
	
	}
	
	/**
	 * Stub method that is implemented in extending classes.
	 *
	 */
	public void clearResults()
	{
		
	}
}
