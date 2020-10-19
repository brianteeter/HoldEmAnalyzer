package com.assorted.poker.gui;

import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.assorted.poker.results.HoldEmSimulationResults;

/**
 * This class uses a result object to calculate and display the current odds
 * that are being laid by the pot.  
 * 
 * @author Brian Teeter
 *
 */
public class JPotOddsPanel extends JPanel
{

	JLabel potOddsLabel = null; 
	JTextField potOddsField = null;
	
	/**
	 * Default Constructor
	 *
	 */
	public JPotOddsPanel()
	{
		// Initialize the Panel:
		this.setBorder(new TitledBorder("Pot Odds"));
		
		// Create the objects:
		potOddsLabel = new JLabel("Required Pot Odds:");
		this.add(potOddsLabel);
		
		potOddsField = new JTextField(15);
		
		this.add(potOddsField);
		
	}
	
	/**
	 * This method looks at the results object and uses it to calcualte
	 * 
	 * @param results
	 */
	public void updateOdds(HoldEmSimulationResults results)
	{
		double winPercent = ((double) results.getWinTotals() / (double) results.getHandCount());
		double rawOdds = 1/winPercent;
		double potOdds = (rawOdds - 1);
		
		// Format the results so it fits the field:
		DecimalFormat formatter = new DecimalFormat("00.00");
		
		this.potOddsField.setText(formatter.format(potOdds) + " to 1");
		
	}
	
}
