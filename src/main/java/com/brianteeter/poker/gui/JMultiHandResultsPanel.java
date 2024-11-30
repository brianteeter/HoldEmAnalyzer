package com.brianteeter.poker.gui;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.brianteeter.poker.model.HoldEmHand;
import com.brianteeter.poker.results.HoldEmSimulationResults;

/**
 * This class is used to display the results of a simulation comparing multiple
 * hands at one time.
 * 
 * @author Brian Teeter
 * 
 */
public class JMultiHandResultsPanel extends JMultiHandGenericResultsPanel
{
	
	/**
	 * For serialization:
	 */
	private static final long serialVersionUID = 3337104614829613671L;
	
	JTable resultsTable = null;

	/**
	 * Default Constructor
	 * 
	 */
	public JMultiHandResultsPanel()
	{
		clearResults();
	}

	/**
	 * Clear the results table.
	 * 
	 */
	public void clearResults()
	{
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Simulation Results"));

		Vector columnNames = new Vector();
		columnNames.add(" ");
		columnNames.add("Hand 1:");
		columnNames.add("Hand 2:");
		columnNames.add("Hand 3:");
		columnNames.add("Hand 4:");
		columnNames.add("Split:");

		Vector tableData = new Vector();

		Vector row1Data = new Vector();
		row1Data.add("Overall");
		row1Data.add("---");
		row1Data.add("---");
		row1Data.add("---");
		row1Data.add("---");
		row1Data.add("---");
		tableData.add(row1Data);

		Vector row2Data = new Vector();
		row2Data.add(" ");
		row2Data.add(" ");
		row2Data.add(" ");
		row2Data.add(" ");
		row2Data.add(" ");
		row2Data.add(" ");
		tableData.add(row2Data);

		Vector row3Data = new Vector();
		row3Data.add("Royal Flush:");
		row3Data.add(" ");
		row3Data.add(" ");
		row3Data.add(" ");
		row3Data.add(" ");
		row3Data.add(" ");
		tableData.add(row3Data);

		Vector row4Data = new Vector();
		row4Data.add("Straight Flush:");
		row4Data.add(" ");
		row4Data.add(" ");
		row4Data.add(" ");
		row4Data.add(" ");
		row4Data.add(" ");
		tableData.add(row4Data);

		Vector row5Data = new Vector();
		row5Data.add("Quads:");
		row5Data.add(" ");
		row5Data.add(" ");
		row5Data.add(" ");
		row5Data.add(" ");
		row5Data.add(" ");
		tableData.add(row5Data);

		Vector row6Data = new Vector();
		row6Data.add("Full House:");
		row6Data.add(" ");
		row6Data.add(" ");
		row6Data.add(" ");
		row6Data.add(" ");
		row6Data.add(" ");
		tableData.add(row6Data);

		Vector row7Data = new Vector();
		row7Data.add("Flush:");
		row7Data.add(" ");
		row7Data.add(" ");
		row7Data.add(" ");
		row7Data.add(" ");
		row7Data.add(" ");
		tableData.add(row7Data);

		Vector row8Data = new Vector();
		row8Data.add("Straight:");
		row8Data.add(" ");
		row8Data.add(" ");
		row8Data.add(" ");
		row8Data.add(" ");
		row8Data.add(" ");
		tableData.add(row8Data);

		Vector row9Data = new Vector();
		row9Data.add("Trips:");
		row9Data.add(" ");
		row9Data.add(" ");
		row9Data.add(" ");
		row9Data.add(" ");
		row9Data.add(" ");
		tableData.add(row9Data);

		Vector row10Data = new Vector();
		row10Data.add("Two Pair:");
		row10Data.add(" ");
		row10Data.add(" ");
		row10Data.add(" ");
		row10Data.add(" ");
		row10Data.add(" ");
		tableData.add(row10Data);

		Vector row11Data = new Vector();
		row11Data.add("Pair:");
		row11Data.add(" ");
		row11Data.add(" ");
		row11Data.add(" ");
		row11Data.add(" ");
		row11Data.add(" ");
		tableData.add(row11Data);

		Vector row12Data = new Vector();
		row12Data.add("High Card:");
		row12Data.add(" ");
		row12Data.add(" ");
		row12Data.add(" ");
		row12Data.add(" ");
		row12Data.add(" ");
		tableData.add(row12Data);

		resultsTable = new JTable();

		resultsTable.setModel(new DefaultTableModel(tableData, columnNames));
		resultsTable.setShowGrid(true);
		resultsTable.setFont(defaultFont);
		resultsTable.getTableHeader().setFont(headerFont);

		this.add(resultsTable.getTableHeader(), BorderLayout.PAGE_START);
		this.add(resultsTable, BorderLayout.CENTER);

		// Update the screen to show the new table:
		resultsTable.revalidate();
		resultsTable.updateUI();
	}

	public void insertResults(HoldEmHand h1, HoldEmHand h2, HoldEmHand h3,
                              HoldEmHand h4, HoldEmSimulationResults hand1,
                              HoldEmSimulationResults hand2, HoldEmSimulationResults hand3,
                              HoldEmSimulationResults hand4)
	{
		// Create the vector of Column Names:
		Vector columnNames = new Vector();
		columnNames.add("");
		columnNames.add("(" + h1.getHole1() + h1.getHole2() + ")");
		columnNames.add("(" + h2.getHole1() + h2.getHole2() + ")");

		if (hand3 != null)
		{
			columnNames.add("(" + h3.getHole1() + h3.getHole2() + ")");
		}
		if (hand4 != null)
		{
			columnNames.add("(" + h4.getHole1() + h4.getHole2() + ")");
		}
		
		columnNames.add("Splits");

		// Aggregate the hand result data into the Vector of Vectors:
		Vector tableData = new Vector();

		// The first Row in the table is the Totals Row:
		Vector totalResults = new Vector();
		totalResults.add("Totals: ");
		totalResults.add(formatResultField(hand1.getWinTotals(), hand1
				.getHandCount()));
		totalResults.add(formatResultField(hand2.getWinTotals(), hand2
				.getHandCount()));

		if (hand3 != null)
		{
			totalResults.add(formatResultField(hand3.getWinTotals(), hand3
					.getHandCount()));
		}
		if (hand4 != null)
		{
			totalResults.add(formatResultField(hand4.getWinTotals(), hand4
					.getHandCount()));
		}
		
		totalResults.add(formatResultField(hand2.getSplitTotals(), hand2
				.getHandCount()));

		tableData.add(totalResults);

		// The second Row in the table is all blank for GUI layout purposes:
		Vector blankRowResults = new Vector();
		blankRowResults.add("  ");
		blankRowResults.add("  ");
		blankRowResults.add("  ");

		if (hand3 != null)
		{
			blankRowResults.add("  ");
		}
		if (hand4 != null)
		{
			blankRowResults.add("  ");
		}
		
		blankRowResults.add("  ");
		tableData.add(blankRowResults);

		// The 3rd Row in the table is the Royal Flush Row:
		Vector royalFlushResults = new Vector();
		royalFlushResults.add("Royal Flush: ");
		royalFlushResults.add(formatResultField(hand1.getWinRoyalFlush(), hand1
				.getHandCount()));
		royalFlushResults.add(formatResultField(hand2.getWinRoyalFlush(), hand2
				.getHandCount()));

		if (hand3 != null)
		{
			royalFlushResults.add(formatResultField(hand3.getWinRoyalFlush(),
					hand3.getHandCount()));
		}
		if (hand4 != null)
		{
			royalFlushResults.add(formatResultField(hand4.getWinRoyalFlush(),
					hand4.getHandCount()));
		}
		
		royalFlushResults.add(formatResultField(hand2.getSplitRoyalFlush(),
				hand2.getHandCount()));
		
		tableData.add(royalFlushResults);

		// The 4rd Row in the table is the Straight Flush Row:
		Vector str8FlushResults = new Vector();
		str8FlushResults.add("Straight Flush: ");
		str8FlushResults.add(formatResultField(hand1.getWinStraightFlush(),
				hand1.getHandCount()));
		str8FlushResults.add(formatResultField(hand2.getWinStraightFlush(),
				hand2.getHandCount()));

		if (hand3 != null)
		{
			str8FlushResults.add(formatResultField(hand3.getWinStraightFlush(),
					hand3.getHandCount()));
		}
		if (hand4 != null)
		{
			str8FlushResults.add(formatResultField(hand4.getWinStraightFlush(),
					hand4.getHandCount()));
		}
		str8FlushResults.add(formatResultField(hand2.getSplitStraightFlush(),
				hand2.getHandCount()));
		
		tableData.add(str8FlushResults);

		// The 5th Row in the table is the Quads Row:
		Vector quadsResults = new Vector();
		quadsResults.add("Quads: ");
		quadsResults.add(formatResultField(hand1.getWinQuads(), hand1
				.getHandCount()));
		quadsResults.add(formatResultField(hand2.getWinQuads(), hand2
				.getHandCount()));

		if (hand3 != null)
		{
			quadsResults.add(formatResultField(hand3.getWinQuads(), hand3
					.getHandCount()));
		}
		if (hand4 != null)
		{
			quadsResults.add(formatResultField(hand4.getWinQuads(), hand4
					.getHandCount()));
		}
		
		quadsResults.add(formatResultField(hand2.getSplitQuads(), hand2
				.getHandCount()));
		
		tableData.add(quadsResults);

		// The 6th Row in the table is the Full House Row:
		Vector fullHouseResults = new Vector();
		fullHouseResults.add("Full House: ");
		fullHouseResults.add(formatResultField(hand1.getWinFullHouse(), hand1
				.getHandCount()));
		fullHouseResults.add(formatResultField(hand2.getWinFullHouse(), hand2
				.getHandCount()));

		if (hand3 != null)
		{
			fullHouseResults.add(formatResultField(hand3.getWinFullHouse(),
					hand3.getHandCount()));
		}
		if (hand4 != null)
		{
			fullHouseResults.add(formatResultField(hand4.getWinFullHouse(),
					hand4.getHandCount()));
		}
		fullHouseResults.add(formatResultField(hand2.getSplitFullHouse(), hand2
				.getHandCount()));
		
		tableData.add(fullHouseResults);

		// The 7th Row in the table is the Flush Row:
		Vector flushResults = new Vector();
		flushResults.add("Flush: ");
		flushResults.add(formatResultField(hand1.getWinFlush(), hand1
				.getHandCount()));
		flushResults.add(formatResultField(hand2.getWinFlush(), hand2
				.getHandCount()));

		if (hand3 != null)
		{
			flushResults.add(formatResultField(hand3.getWinFlush(), hand3
					.getHandCount()));
		}
		if (hand4 != null)
		{
			flushResults.add(formatResultField(hand4.getWinFlush(), hand4
					.getHandCount()));
		}
		flushResults.add(formatResultField(hand2.getSplitFlush(), hand2
				.getHandCount()));
		
		tableData.add(flushResults);

		// The 8th Row in the table is the Straight Row:
		Vector straightResults = new Vector();
		straightResults.add("Straight: ");
		straightResults.add(formatResultField(hand1.getWinStraight(), hand1
				.getHandCount()));
		straightResults.add(formatResultField(hand2.getWinStraight(), hand2
				.getHandCount()));

		if (hand3 != null)
		{
			straightResults.add(formatResultField(hand3.getWinStraight(), hand3
					.getHandCount()));
		}
		if (hand4 != null)
		{
			straightResults.add(formatResultField(hand4.getWinStraight(), hand4
					.getHandCount()));
		}
		straightResults.add(formatResultField(hand2.getSplitStraight(), hand2
				.getHandCount()));
		
		tableData.add(straightResults);

		// The 9th Row in the table is the Trips Row:
		Vector tripsResults = new Vector();
		tripsResults.add("Trips: ");
		tripsResults.add(formatResultField(hand1.getWinTrips(), hand1
				.getHandCount()));
		tripsResults.add(formatResultField(hand2.getWinTrips(), hand2
				.getHandCount()));

		if (hand3 != null)
		{
			tripsResults.add(formatResultField(hand3.getWinTrips(), hand3
					.getHandCount()));
		}
		if (hand4 != null)
		{
			tripsResults.add(formatResultField(hand4.getWinTrips(), hand4
					.getHandCount()));
		}
		tripsResults.add(formatResultField(hand2.getSplitTrips(), hand2
				.getHandCount()));
		
		tableData.add(tripsResults);

		// The 10th Row in the table is the Two Pair Row:
		Vector twoPairResults = new Vector();
		twoPairResults.add("Two Pair: ");
		twoPairResults.add(formatResultField(hand1.getWinTwoPair(), hand1
				.getHandCount()));
		twoPairResults.add(formatResultField(hand2.getWinTwoPair(), hand2
				.getHandCount()));

		if (hand3 != null)
		{
			twoPairResults.add(formatResultField(hand3.getWinTwoPair(), hand3
					.getHandCount()));
		}
		if (hand4 != null)
		{
			twoPairResults.add(formatResultField(hand4.getWinTwoPair(), hand4
					.getHandCount()));
		}
		
		twoPairResults.add(formatResultField(hand2.getSplitTwoPair(), hand2
				.getHandCount()));
		
		tableData.add(twoPairResults);

		// The 11th Row in the table is the Two Pair Row:
		Vector pairResults = new Vector();
		pairResults.add("Pair: ");
		pairResults.add(formatResultField(hand1.getWinPair(), hand1
				.getHandCount()));
		pairResults.add(formatResultField(hand2.getWinPair(), hand2
				.getHandCount()));

		if (hand3 != null)
		{
			pairResults.add(formatResultField(hand3.getWinPair(), hand3
					.getHandCount()));
		}
		if (hand4 != null)
		{
			pairResults.add(formatResultField(hand4.getWinPair(), hand4
					.getHandCount()));
		}
		
		pairResults.add(formatResultField(hand2.getSplitPair(), hand2
				.getHandCount()));
		
		tableData.add(pairResults);

		// The 12th Row in the table is the Two Pair Row:
		Vector highCardResults = new Vector();
		highCardResults.add("High Card: ");
		highCardResults.add(formatResultField(hand1.getWinHighCard(), hand1
				.getHandCount()));
		highCardResults.add(formatResultField(hand2.getWinHighCard(), hand2
				.getHandCount()));

		if (hand3 != null)
		{
			highCardResults.add(formatResultField(hand3.getWinHighCard(), hand3
					.getHandCount()));
		}
		if (hand4 != null)
		{
			highCardResults.add(formatResultField(hand4.getWinHighCard(), hand4
					.getHandCount()));
		}
		highCardResults.add(formatResultField(hand2.getSplitHighCard(), hand2
				.getHandCount()));
		
		tableData.add(highCardResults);

		// Remove and then re-add the results table to the panel:
		this.remove(resultsTable.getTableHeader());
		this.remove(resultsTable);

		// Update the screen to show the new table:
		resultsTable.setModel(new DefaultTableModel(tableData, columnNames));
		this.add(resultsTable.getTableHeader(), BorderLayout.PAGE_START);
		this.add(resultsTable, BorderLayout.CENTER);
		resultsTable.setFont(defaultFont);
		resultsTable.getTableHeader().setFont(headerFont);

		// Configure the table so it doesn't look like crap:
		resultsTable.setShowGrid(true);

		resultsTable.revalidate();
		resultsTable.updateUI();
		
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
