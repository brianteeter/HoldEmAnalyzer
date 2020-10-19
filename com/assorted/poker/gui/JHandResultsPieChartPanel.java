package com.assorted.poker.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.assorted.poker.model.HoldEmHand;
import com.assorted.poker.results.HoldEmSimulationResults;

/**
 * This class is a JPanel class that displays the user's chances to win using
 * graphics.
 * 
 * @author Brian Teeter
 * 
 */
public class JHandResultsPieChartPanel extends JHandResultsGenericPanel
{

	protected Font chartHeaderFont = new Font("Verdana", Font.BOLD, 9);

	protected Font chartLabelFont = new Font("Verdana", Font.BOLD, 7);

	ChartPanel winLossChartPanel = null;

	ChartPanel improvementChartPanel = null;

	/**
	 * For serialization
	 */
	private static final long serialVersionUID = -4203068624163835254L;

	public ChartPanel getWinLossChartPanel()
	{
		return winLossChartPanel;
	}

	public void setWinLossChartPanel(ChartPanel winLossChartPanel)
	{
		this.winLossChartPanel = winLossChartPanel;
	}

	/**
	 * Constructor method creates and sets up the panel for use:
	 * 
	 */
	public JHandResultsPieChartPanel()
	{
		// ---------------------------------------------------------------------
		// Set the layout of the panel to be large enough to accomidate the
		// results fields and totals:
		// ---------------------------------------------------------------------
		GridLayout gridLayout = new GridLayout(0, 1, 2, 1);
		// gridLayout.setRows(12);
		// gridLayout.setColumns(4);

		this.setLayout(gridLayout);

		// Set the border and size of the panel:
		this.setBorder(new TitledBorder("Expected Results"));
		Dimension panelSize = new Dimension(475, 500);
		this.setMaximumSize(panelSize);
		this.setPreferredSize(panelSize);
		this.setSize(panelSize);

		// Add the Win Loss Chart to the panel:
		winLossChartPanel = new ChartPanel(null);

		this.add(winLossChartPanel);

		// Add the Improvement Chart to the panel:
		improvementChartPanel = new ChartPanel(null);

		this.add(improvementChartPanel);

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

		// ----------------------------------------------------------------
		// We cannot update the GUI, if we have invalid results, so clear
		// the GUI instead
		// ----------------------------------------------------------------
		if ((results == null) || (results.getHandCount() <= 1))
		{
			// Clear the GUI:
			this.removeAll();
			
			// Redraw the panel so the graphs actually show:
			this.repaint();
			this.updateUI();
			return;
		}
		else
		{
			updateGraphs();
		}
	}

	/**
	 * This method updates the graphs on the interface:
	 * 
	 */
	public void updateGraphs()
	{
		addWinLossGraph();
		addImprovementPctGraph();

		// Redraw the panel so the graphs actually show:
		this.repaint();
		this.updateUI();
	}

	/**
	 * This method is used to update the Win/Loss Pie Graph:
	 * 
	 */
	public void addWinLossGraph()
	{
		// ----------------------------------------------------------------
		// Get the current % to win, tie and lose and use it to create
		// the dataset for the first pie chart.
		// ----------------------------------------------------------------
		DefaultPieDataset winLossPieData = new DefaultPieDataset();

		winLossPieData.setValue("Win", results.getWinTotals());
		winLossPieData.setValue("Tie", results.getSplitTotals());
		winLossPieData.setValue("Lose", results.getLossTotals());

		// Create the chart object
		JFreeChart winLossChart = ChartFactory.createPieChart(
				"Win / Lose % (over " + results.getHandCount() + " hands)", // Title
				winLossPieData, false, // Legend
				true, // Tooltips
				false); // URL

		// ----------------------------------------------------------------
		// Setup the colors for the Pie Chart:
		// ----------------------------------------------------------------
		PiePlot winLossPiePlot = (PiePlot) winLossChart.getPlot();

		winLossPiePlot.setSectionPaint(0, new Color(20, 255, 20)); // Green
		winLossPiePlot.setSectionPaint(1, new Color(128, 128, 128)); // Grey
		winLossPiePlot.setSectionPaint(2, new Color(255, 20, 20)); // Red

		// ----------------------------------------------------------------
		// Turn on the border lines:
		// ----------------------------------------------------------------
		winLossPiePlot.setSectionOutlinesVisible(true);

		// ----------------------------------------------------------------
		// Set up the section labels to include the % values:
		// ----------------------------------------------------------------
		winLossPiePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0} {2}", new DecimalFormat(), new DecimalFormat("00.00%")));

		// ----------------------------------------------------------------
		// Set the section label font to be large enough to read:
		// ----------------------------------------------------------------
		winLossPiePlot.setLabelFont(chartHeaderFont);
		// winLossPiePlot.set

		// ----------------------------------------------------------------
		// Ignore any zero or null values:
		// ----------------------------------------------------------------
		winLossPiePlot.setIgnoreZeroValues(true);
		winLossPiePlot.setIgnoreNullValues(true);

		// Render the chart:
		this.remove(winLossChartPanel);

		winLossChartPanel = new ChartPanel(winLossChart);

		this.add(winLossChartPanel);
	}

	/**
	 * This method is used to update the Percent to Improve Pie Graph:
	 * 
	 */
	public void addImprovementPctGraph()
	{
		// ----------------------------------------------------------------
		// Get the current % to win, tie and lose and use it to create
		// the dataset for the first pie chart.
		// ----------------------------------------------------------------
		DefaultPieDataset improvementData = new DefaultPieDataset();

		// ----------------------------------------------------------------
		// Get the current hand rank, and use it to determine what % of the
		// time we will improve to win:
		// ----------------------------------------------------------------
		results.getTheHand().rankHand();
		int handRank = results.getTheHand().getHandRank();
		int improvedHands = 0;

		// ----------------------------------------------------------------
		// Get the current hand rank, and use it to determine what % of the
		// time we will improve to win:
		// ----------------------------------------------------------------
		if (handRank < HoldEmHand.RANK_ROYAL_FLUSH)
		{
			int royalFlushHands = (results.getWinRoyalFlush()
					+ results.getSplitRoyalFlush() + results
					.getLoseRoyalFlush());

			improvedHands += royalFlushHands;
			improvementData.setValue("Royal Flush", royalFlushHands);
		}
		if (handRank < HoldEmHand.RANK_STRAIGHT_FLUSH)
		{
			// ----------------------------------------------------------------
			// We can possibly improve to this rank. Add the hands
			// where we improve to this rank to the total:
			// ----------------------------------------------------------------
			int straightFlushHands = (results.getWinStraightFlush()
					+ results.getSplitStraightFlush() + results
					.getLoseStraightFlush());

			improvedHands += straightFlushHands;
			improvementData.setValue("Straight Flush", straightFlushHands);

		}
		if (handRank < HoldEmHand.RANK_QUADS)
		{
			// ----------------------------------------------------------------
			// We can possibly improve to this rank. Add the hands
			// where we improve to this rank to the total:
			// ----------------------------------------------------------------
			int quadsHands = (results.getWinQuads() + results.getSplitQuads() + results
					.getLoseQuads());

			improvedHands += quadsHands;
			improvementData.setValue("Quads", quadsHands);
		}
		if (handRank < HoldEmHand.RANK_FULL_HOUSE)
		{
			// ----------------------------------------------------------------
			// We can possibly improve to this rank. Add the hands
			// where we improve to this rank to the total:
			// ----------------------------------------------------------------
			int fullHouseHands = (results.getWinFullHouse()
					+ results.getSplitFullHouse() + results.getLoseFullHouse());

			improvedHands += fullHouseHands;
			improvementData.setValue("Full House", fullHouseHands);
		}
		if (handRank < HoldEmHand.RANK_FLUSH)
		{
			// ----------------------------------------------------------------
			// We can possibly improve to this rank. Add the hands
			// where we improve to this rank to the total:
			// ----------------------------------------------------------------
			int flushHands = (results.getWinFlush() + results.getSplitFlush() + results
					.getLoseFlush());

			improvedHands += flushHands;
			improvementData.setValue("Flush", flushHands);
		}
		if (handRank < HoldEmHand.RANK_STRAIGHT)
		{
			// ----------------------------------------------------------------
			// We can possibly improve to this rank. Add the hands
			// where we improve to this rank to the total:
			// ----------------------------------------------------------------
			int straightHands = (results.getWinStraight()
					+ results.getSplitStraight() + results.getLoseStraight());

			improvedHands += straightHands;
			improvementData.setValue("Straight", straightHands);
		}
		if (handRank < HoldEmHand.RANK_TRIPS)
		{
			// ----------------------------------------------------------------
			// We can possibly improve to this rank. Add the hands
			// where we improve to this rank to the total:
			// ----------------------------------------------------------------
			int tripsHands = (results.getWinTrips() + results.getSplitTrips() + results
					.getLoseTrips());

			improvedHands += tripsHands;
			improvementData.setValue("Trips", tripsHands);
		}
		if (handRank < HoldEmHand.RANK_TWO_PAIR)
		{
			// ----------------------------------------------------------------
			// We can possibly improve to this rank. Add the hands
			// where we improve to this rank to the total:
			// ----------------------------------------------------------------
			int twoPairHands = (results.getWinTwoPair()
					+ results.getSplitTwoPair() + results.getLoseTwoPair());

			improvedHands += twoPairHands;
			improvementData.setValue("Two Pair", twoPairHands);
		}
		if (handRank < HoldEmHand.RANK_PAIR)
		{
			// ----------------------------------------------------------------
			// We can possibly improve to this rank. Add the hands
			// where we improve to this rank to the total:
			// ----------------------------------------------------------------
			int pairHands = (results.getWinPair() + results.getSplitPair() + results
					.getLosePair());

			improvedHands += pairHands;
			improvementData.setValue("Pair", pairHands);
		}

		// ----------------------------------------------------------------
		// NOTE: High Card hands are not an improvement on anything.
		// ----------------------------------------------------------------
		improvementData.setValue("No Improvement",
				(results.getHandCount() - improvedHands));

		// Create the chart object
		JFreeChart improvementChart = ChartFactory
				.createPieChart("% to Improve Hand (over "
						+ results.getHandCount() + " hands)", // Title
						improvementData, false, // Legend
						true, // Tooltips
						false); // URL

		// ----------------------------------------------------------------
		// Setup the colors for the Pie Chart:
		// ----------------------------------------------------------------
		PiePlot improvementPiePlot = (PiePlot) improvementChart.getPlot();

		// ----------------------------------------------------------------
		// Turn on the border lines:
		// ----------------------------------------------------------------
		improvementPiePlot.setSectionOutlinesVisible(true);

		// ----------------------------------------------------------------
		// Turn on the border lines:
		// ----------------------------------------------------------------
		improvementPiePlot.setSectionOutlinesVisible(true);

		// ----------------------------------------------------------------
		// Set up the section labels to include the % values:
		// ----------------------------------------------------------------
		improvementPiePlot
				.setLabelGenerator(new StandardPieSectionLabelGenerator(
						"{0} {2}", new DecimalFormat(), new DecimalFormat(
								"00.00%")));

		// ----------------------------------------------------------------
		// Set the section label font to be large enough to read:
		// ----------------------------------------------------------------
		improvementPiePlot.setLabelFont(chartHeaderFont);
		// winLossPiePlot.set

		// ----------------------------------------------------------------
		// Ignore any zero or null values:
		// ----------------------------------------------------------------
		improvementPiePlot.setIgnoreZeroValues(true);
		improvementPiePlot.setIgnoreNullValues(true);

		// Render the chart:
		this.remove(improvementChartPanel);

		improvementChartPanel = new ChartPanel(improvementChart);

		this.add(improvementChartPanel);

	}
}
