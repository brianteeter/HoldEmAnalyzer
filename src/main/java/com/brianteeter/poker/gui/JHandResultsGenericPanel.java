package com.brianteeter.poker.gui;

import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JPanel;

import com.brianteeter.poker.results.HoldEmSimulationResults;

/**
 * This class is a superclass of the various Hand Results Panels that
 * are available to the user.
 * 
 * @author Brian Teeter
 * 
 */
public class JHandResultsGenericPanel extends JPanel
{

	protected Font resultsFont = new Font("Verdana", Font.BOLD, 10);
	HoldEmSimulationResults results = null;

	public HoldEmSimulationResults getResults()
	{
		return results;
	}
	
	/**
	 * When setting the results, if the results actually contain results, set
	 * the GUI to display them.
	 * 
	 * @param results
	 */
	public void setResults(HoldEmSimulationResults results)
	{
		this.results = results;
	}

	/**
	 * This function uses the result fields passed in to create a percent value
	 * as a String.
	 */
	public String formatResultField(int occured, int totals)
	{
		// If the result is guaranteed to be a 0, then no need
		// to calculate it:
		if ((occured <= 0) || (totals <= 0))
		{
			return "----";
		}
		
		DecimalFormat formatter = new DecimalFormat("#00.00");
		float percent = ((float) occured / (float) totals) * 100;
		if (percent < 0)
		{
			percent = 0;
		}
		String result = "" + formatter.format(percent) + "%";
	
		return result;
	}

}
