package com.assorted.poker.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.assorted.poker.results.HoldEmSimulationResults;


/**
 * This class is used to display the results of a simulation.
 * 
 * @author Brian Teeter
 * 
 */
public class JHandResultsPanel extends JHandResultsGenericPanel
{
	// These are the header
	JLabel handsAnalyzedLabel = null;

	JTextField handsAnalyzedCount = null;

	
	// These are the header
	JLabel handRankLabel = null;

	JLabel winLabel = null;

	JLabel splitLabel = null;

	JLabel lossLabel = null;

	// Rank Labels:
	JLabel royalFlushLabel = null;

	JLabel straightFlushLabel = null;

	JLabel quadsLabel = null;

	JLabel fullHouseLabel = null;

	JLabel flushLabel = null;

	JLabel straightLabel = null;

	JLabel tripsLabel = null;

	JLabel twoPairLabel = null;

	JLabel pairLabel = null;

	JLabel highCardLabel = null;

	JLabel totalsLabel = null;

	// Royal Flush Fields:
	JTextField winRoyalFlush = null;

	JTextField splitRoyalFlush = null;

	JTextField lossRoyalFlush = null;

	// Straight Flush Fields:
	JTextField winStraightFlush = null;

	JTextField splitStraightFlush = null;

	JTextField lossStraightFlush = null;

	// Quads Fields:
	JTextField winQuads = null;

	JTextField splitQuads = null;

	JTextField lossQuads = null;

	// Full House Fields:
	JTextField winFullHouse = null;

	JTextField splitFullHouse = null;

	JTextField lossFullHouse = null;

	// Flush Fields:
	JTextField winFlush = null;

	JTextField splitFlush = null;

	JTextField lossFlush = null;

	// Straight Fields:
	JTextField winStraight = null;

	JTextField splitStraight = null;

	JTextField lossStraight = null;

	// Trips Fields:
	JTextField winTrips = null;

	JTextField splitTrips = null;

	JTextField lossTrips = null;

	// Two Pair Fields:
	JTextField winTwoPair = null;

	JTextField splitTwoPair = null;

	JTextField lossTwoPair = null;

	// Pair Fields:
	JTextField winPair = null;

	JTextField splitPair = null;

	JTextField lossPair = null;

	// High Card Fields:
	JTextField winHighCard = null;

	JTextField splitHighCard = null;

	JTextField lossHighCard = null;

	// Totals Fields:
	JTextField winTotals = null;

	JTextField splitTotals = null;

	JTextField lossTotals = null;

	/**
	 * Default Constructor
	 * 
	 */
	public JHandResultsPanel()
	{
		// ---------------------------------------------------------------------
		// Set the layout of the panel to be large enough to accomidate the
		// results fields and totals:
		// ---------------------------------------------------------------------
		GridLayout gridLayout = new GridLayout(0, 4, 2, 1);
		// gridLayout.setRows(12);
		// gridLayout.setColumns(4);

		this.setLayout(gridLayout);

		// Set the border and size of the panel:
		this.setBorder(new TitledBorder("Expected Results"));
		Dimension panelSize = new Dimension(350, 300);
		this.setMaximumSize(panelSize);
		this.setPreferredSize(panelSize);
		this.setSize(panelSize);

		// ---------------------------------------------------------------------
		// Create the hand count / player count label/fields:
		// ---------------------------------------------------------------------
		handsAnalyzedLabel = new JLabel("Hands:");
		handsAnalyzedLabel.setFont(resultsFont);
		this.add(handsAnalyzedLabel);

		handsAnalyzedCount = new JTextField("");
		handsAnalyzedCount.setFont(resultsFont);
		this.add(handsAnalyzedCount);

		// Put 2 empty's in to fill the grid:
		this.add(new JLabel(""));
		this.add(new JLabel(""));

		// ---------------------------------------------------------------------
		// Create a row of empty Labels to fill the space:
		// ---------------------------------------------------------------------
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());

		// ---------------------------------------------------------------------
		// Create and add the rank labels to the panel:
		// ---------------------------------------------------------------------
		handRankLabel = new JLabel("");
		handRankLabel.setFont(resultsFont);
		this.add(handRankLabel);

		winLabel = new JLabel("Win %:");
		winLabel.setFont(resultsFont);
		this.add(winLabel);

		splitLabel = new JLabel("Split %:");
		splitLabel.setFont(resultsFont);
		this.add(splitLabel);

		lossLabel = new JLabel("Loss %:");
		lossLabel.setFont(resultsFont);
		this.add(lossLabel);

		// ---------------------------------------------------------------------
		// Royal Flush Data:
		// ---------------------------------------------------------------------
		royalFlushLabel = new JLabel("R. Flush:");
		royalFlushLabel.setFont(resultsFont);
		this.add(royalFlushLabel);

		winRoyalFlush = new JTextField("");
		winRoyalFlush.setFont(resultsFont);
		this.add(winRoyalFlush);

		splitRoyalFlush = new JTextField("");
		splitRoyalFlush.setFont(resultsFont);
		this.add(splitRoyalFlush);

		lossRoyalFlush = new JTextField("");
		lossRoyalFlush.setFont(resultsFont);
		this.add(lossRoyalFlush);

		// ---------------------------------------------------------------------
		// Straight Flush Data:
		// ---------------------------------------------------------------------
		straightFlushLabel = new JLabel("St Flush:");
		straightFlushLabel.setFont(resultsFont);
		this.add(straightFlushLabel);

		winStraightFlush = new JTextField("");
		winStraightFlush.setFont(resultsFont);
		this.add(winStraightFlush);

		splitStraightFlush = new JTextField("");
		splitStraightFlush.setFont(resultsFont);
		this.add(splitStraightFlush);

		lossStraightFlush = new JTextField("");
		lossStraightFlush.setFont(resultsFont);
		this.add(lossStraightFlush);

		// ---------------------------------------------------------------------
		// Quads Flush Data:
		// ---------------------------------------------------------------------
		quadsLabel = new JLabel("Quads:");
		quadsLabel.setFont(resultsFont);
		this.add(quadsLabel);

		winQuads = new JTextField("");
		winQuads.setFont(resultsFont);
		this.add(winQuads);

		splitQuads = new JTextField("");
		splitQuads.setFont(resultsFont);
		this.add(splitQuads);

		lossQuads = new JTextField("");
		lossQuads.setFont(resultsFont);
		this.add(lossQuads);

		// ---------------------------------------------------------------------
		// Full House Flush Data:
		// ---------------------------------------------------------------------
		fullHouseLabel = new JLabel("Full House:");
		fullHouseLabel.setFont(resultsFont);
		this.add(fullHouseLabel);

		winFullHouse = new JTextField("");
		winFullHouse.setFont(resultsFont);
		this.add(winFullHouse);

		splitFullHouse = new JTextField("");
		splitFullHouse.setFont(resultsFont);
		this.add(splitFullHouse);

		lossFullHouse = new JTextField("");
		lossFullHouse.setFont(resultsFont);
		this.add(lossFullHouse);

		// ---------------------------------------------------------------------
		// Flush Data:
		// ---------------------------------------------------------------------
		flushLabel = new JLabel("Flush:");
		flushLabel.setFont(resultsFont);
		this.add(flushLabel);

		winFlush = new JTextField("");
		winFlush.setFont(resultsFont);
		this.add(winFlush);

		splitFlush = new JTextField("");
		splitFlush.setFont(resultsFont);
		this.add(splitFlush);

		lossFlush = new JTextField("");
		lossFlush.setFont(resultsFont);
		this.add(lossFlush);

		// ---------------------------------------------------------------------
		// Straight Data:
		// ---------------------------------------------------------------------
		straightLabel = new JLabel("Straight:");
		straightLabel.setFont(resultsFont);
		this.add(straightLabel);

		winStraight = new JTextField("");
		winStraight.setFont(resultsFont);
		this.add(winStraight);

		splitStraight = new JTextField("");
		splitStraight.setFont(resultsFont);
		this.add(splitStraight);

		lossStraight = new JTextField("");
		lossStraight.setFont(resultsFont);
		this.add(lossStraight);

		// ---------------------------------------------------------------------
		// Trips Data:
		// ---------------------------------------------------------------------
		tripsLabel = new JLabel("Trips:");
		tripsLabel.setFont(resultsFont);
		this.add(tripsLabel);

		winTrips = new JTextField("");
		winTrips.setFont(resultsFont);
		this.add(winTrips);

		splitTrips = new JTextField("");
		splitTrips.setFont(resultsFont);
		this.add(splitTrips);

		lossTrips = new JTextField("");
		lossTrips.setFont(resultsFont);
		this.add(lossTrips);

		// ---------------------------------------------------------------------
		// Two Pair Data:
		// ---------------------------------------------------------------------
		twoPairLabel = new JLabel("Two Pair:");
		twoPairLabel.setFont(resultsFont);
		this.add(twoPairLabel);

		winTwoPair = new JTextField("");
		winTwoPair.setFont(resultsFont);
		this.add(winTwoPair);

		splitTwoPair = new JTextField("");
		splitTwoPair.setFont(resultsFont);
		this.add(splitTwoPair);

		lossTwoPair = new JTextField("");
		lossTwoPair.setFont(resultsFont);
		this.add(lossTwoPair);

		// ---------------------------------------------------------------------
		// Pair Data:
		// ---------------------------------------------------------------------
		pairLabel = new JLabel("Pair:");
		pairLabel.setFont(resultsFont);
		this.add(pairLabel);

		winPair = new JTextField("");
		winPair.setFont(resultsFont);
		this.add(winPair);

		splitPair = new JTextField("");
		splitPair.setFont(resultsFont);
		this.add(splitPair);

		lossPair = new JTextField("");
		lossPair.setFont(resultsFont);
		this.add(lossPair);

		// ---------------------------------------------------------------------
		// High Card Data:
		// ---------------------------------------------------------------------
		highCardLabel = new JLabel("High Card:");
		highCardLabel.setFont(resultsFont);
		this.add(highCardLabel);

		winHighCard = new JTextField("");
		winHighCard.setFont(resultsFont);
		this.add(winHighCard);

		splitHighCard = new JTextField("");
		splitHighCard.setFont(resultsFont);
		this.add(splitHighCard);

		lossHighCard = new JTextField("");
		lossHighCard.setFont(resultsFont);
		this.add(lossHighCard);

		// ---------------------------------------------------------------------
		// Totals:
		// ---------------------------------------------------------------------
		totalsLabel = new JLabel("Totals:");
		totalsLabel.setFont(resultsFont);
		this.add(totalsLabel);

		winTotals = new JTextField("");
		winTotals.setFont(resultsFont);
		this.add(winTotals);

		splitTotals = new JTextField("");
		splitTotals.setFont(resultsFont);
		this.add(splitTotals);

		lossTotals = new JTextField("");
		lossTotals.setFont(resultsFont);
		this.add(lossTotals);

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
	
		// If the results are non-null use them in the GUI:
		if (this.results != null)
		{
			// Set the count fields:
			this.handsAnalyzedCount.setText("" + this.results.getHandCount());
			
			this.splitRoyalFlush.setText(formatResultField(this.results
					.getSplitRoyalFlush(), this.results.getHandCount()));
	
			// Set the Royal Flush Fields:
			this.winRoyalFlush.setText(formatResultField(this.results
					.getWinRoyalFlush(), this.results.getHandCount()));
	
			this.splitRoyalFlush.setText(formatResultField(this.results
					.getSplitRoyalFlush(), this.results.getHandCount()));
	
			this.lossRoyalFlush.setText(formatResultField(this.results
					.getLoseRoyalFlush(), this.results.getHandCount()));
	
			// Set the Straight Flush Fields:
			this.winStraightFlush.setText(formatResultField(this.results
					.getWinStraightFlush(), this.results.getHandCount()));
	
			this.splitStraightFlush.setText(formatResultField(this.results
					.getSplitStraightFlush(), this.results.getHandCount()));
	
			this.lossStraightFlush.setText(formatResultField(this.results
					.getLoseStraightFlush(), this.results.getHandCount()));
	
			// Set the Quads Fields:
			this.winQuads.setText(formatResultField(this.results.getWinQuads(),
					this.results.getHandCount()));
	
			this.splitQuads.setText(formatResultField(this.results
					.getSplitQuads(), this.results.getHandCount()));
	
			this.lossQuads.setText(formatResultField(this.results
					.getLoseQuads(), this.results.getHandCount()));
	
			// Set the Quads Fields:
			this.winQuads.setText(formatResultField(this.results.getWinQuads(),
					this.results.getHandCount()));
	
			this.splitQuads.setText(formatResultField(this.results
					.getSplitQuads(), this.results.getHandCount()));
	
			this.lossQuads.setText(formatResultField(this.results
					.getLoseQuads(), this.results.getHandCount()));
	
			// Set the FullHouse Fields:
			this.winFullHouse.setText(formatResultField(this.results
					.getWinFullHouse(), this.results.getHandCount()));
	
			this.splitFullHouse.setText(formatResultField(this.results
					.getSplitFullHouse(), this.results.getHandCount()));
	
			this.lossFullHouse.setText(formatResultField(this.results
					.getLoseFullHouse(), this.results.getHandCount()));
	
			// Set the Flush Fields:
			this.winFlush.setText(formatResultField(this.results.getWinFlush(),
					this.results.getHandCount()));
	
			this.splitFlush.setText(formatResultField(this.results
					.getSplitFlush(), this.results.getHandCount()));
	
			this.lossFlush.setText(formatResultField(this.results
					.getLoseFlush(), this.results.getHandCount()));
	
			// Set the Straight Fields:
			this.winStraight.setText(formatResultField(this.results
					.getWinStraight(), this.results.getHandCount()));
	
			this.splitStraight.setText(formatResultField(this.results
					.getSplitStraight(), this.results.getHandCount()));
	
			this.lossStraight.setText(formatResultField(this.results
					.getLoseStraight(), this.results.getHandCount()));
	
			// Set the Trips Fields:
			this.winTrips.setText(formatResultField(this.results.getWinTrips(),
					this.results.getHandCount()));
	
			this.splitTrips.setText(formatResultField(this.results
					.getSplitTrips(), this.results.getHandCount()));
	
			this.lossTrips.setText(formatResultField(this.results
					.getLoseTrips(), this.results.getHandCount()));
	
			// Set the TwoPair Fields:
			this.winTwoPair.setText(formatResultField(this.results
					.getWinTwoPair(), this.results.getHandCount()));
	
			this.splitTwoPair.setText(formatResultField(this.results
					.getSplitTwoPair(), this.results.getHandCount()));
	
			this.lossTwoPair.setText(formatResultField(this.results
					.getLoseTwoPair(), this.results.getHandCount()));
	
			// Set the Pair Fields:
			this.winPair.setText(formatResultField(this.results.getWinPair(),
					this.results.getHandCount()));
	
			this.splitPair.setText(formatResultField(this.results
					.getSplitPair(), this.results.getHandCount()));
	
			this.lossPair.setText(formatResultField(this.results.getLosePair(),
					this.results.getHandCount()));
	
			// Set the HighCard Fields:
			this.winHighCard.setText(formatResultField(this.results
					.getWinHighCard(), this.results.getHandCount()));
	
			this.splitHighCard.setText(formatResultField(this.results
					.getSplitHighCard(), this.results.getHandCount()));
	
			this.lossHighCard.setText(formatResultField(this.results
					.getLoseHighCard(), this.results.getHandCount()));
	
			// Set the Totals Fields:
			this.winTotals.setText(formatResultField(this.results
					.getWinTotals(), this.results.getHandCount()));
	
			this.splitTotals.setText(formatResultField(this.results
					.getSplitTotals(), this.results.getHandCount()));
	
			this.lossTotals.setText(formatResultField(this.results
					.getLossTotals(), this.results.getHandCount()));
	
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
