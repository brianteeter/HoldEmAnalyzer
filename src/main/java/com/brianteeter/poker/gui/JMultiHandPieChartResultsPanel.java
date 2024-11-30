package com.brianteeter.poker.gui;

/*-
 * #%L
 * HoldEmAnalyzer
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2004 - 2024 Brian Teeter
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.brianteeter.poker.model.HoldEmHand;
import com.brianteeter.poker.results.HoldEmSimulationResults;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.border.TitledBorder;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * This class displays the results comparing up to 4 hands on a pie chart.
 *
 * @author Brian Teeter
 */
public class JMultiHandPieChartResultsPanel extends
        JMultiHandGenericResultsPanel
{

    ChartPanel handComparisonPanel = null;

    /**
     * Default Constructor
     */
    public JMultiHandPieChartResultsPanel()
    {
        // ---------------------------------------------------------------------
        // Set the layout of the panel to be large enough to accomidate the
        // results fields and totals:
        // ---------------------------------------------------------------------
        GridLayout gridLayout = new GridLayout(0, 1, 2, 1);

        this.setLayout(gridLayout);

        // Set the border and size of the panel:
        this.setBorder(new TitledBorder("Expected Results"));
        Dimension panelSize = new Dimension(500, 500);
        this.setMaximumSize(panelSize);
        this.setPreferredSize(panelSize);
        this.setSize(panelSize);

        // Add the Win Loss Chart to the panel:
        handComparisonPanel = new ChartPanel(null);

        this.add(handComparisonPanel);
    }

    /**
     * Clear the results table.
     */
    public void clearResults()
    {
        this.setLayout(new BorderLayout());
        this.setBorder(new TitledBorder("Expected Results"));

        // Clear the GUI:
        this.removeAll();

        // Redraw the panel so the graphs actually show:
        this.repaint();
        this.updateUI();
    }

    /**
     * This function is what is used to set the results into the pie chart.
     *
     * @param h1
     * @param h2
     * @param h3
     * @param h4
     * @param hand1
     * @param hand2
     * @param hand3
     * @param hand4
     */
    public void insertResults(HoldEmHand h1, HoldEmHand h2, HoldEmHand h3,
                              HoldEmHand h4, HoldEmSimulationResults hand1,
                              HoldEmSimulationResults hand2, HoldEmSimulationResults hand3,
                              HoldEmSimulationResults hand4)
    {
        this.setLayout(new BorderLayout());
        this.setBorder(new TitledBorder("Expected Results"));

        // ----------------------------------------------------------------
        // Get the current win data for each hand that was passed in and
        // add it to the pie dataset:
        // ----------------------------------------------------------------
        DefaultPieDataset compareHandsPieData = new DefaultPieDataset();

        int totalHandCount = 0;

        // ----------------------------------------------------------------
        // Make sure we have at least 2 hands to compare:
        // ----------------------------------------------------------------
        if ((h1 != null) && (h2 != null) && (hand1 != null) && (hand2 != null))
        {
            compareHandsPieData.setValue(h1.toString(), hand1.getWinTotals());
            compareHandsPieData.setValue(h2.toString(), hand2.getWinTotals());

            totalHandCount += hand1.getWinTotals() + hand2.getWinTotals();
        } else
        {
            return;
        }

        // ----------------------------------------------------------------
        // If we have a hand 3 to compare, add it as well:
        // ----------------------------------------------------------------
        if ((h3 != null) && (hand3 != null))
        {
            compareHandsPieData.setValue(h3.toString(), hand3.getWinTotals());

            totalHandCount += hand3.getSplitTotals();
        }

        // ----------------------------------------------------------------
        // If we have a hand 4 to compare, add it as well:
        // ----------------------------------------------------------------
        if ((h4 != null) && (hand4 != null))
        {
            compareHandsPieData.setValue(h4.toString(), hand4.getWinTotals());

            totalHandCount += hand4.getSplitTotals();
        }

        // Create the chart object
        JFreeChart compareHandsChart = ChartFactory.createPieChart(
                "Hand Comparison (over " + totalHandCount + " hands)", // Title
                compareHandsPieData, false, // Legend
                true, // Tooltips
                false); // URL

        // ----------------------------------------------------------------
        // Turn on the border lines:
        // ----------------------------------------------------------------
        PiePlot comparePiePlot = (PiePlot) compareHandsChart.getPlot();
        comparePiePlot.setSectionOutlinesVisible(true);

        // ----------------------------------------------------------------
        // Set up the section labels to include the % values:
        // ----------------------------------------------------------------
        comparePiePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(
                "{0} {2}", new DecimalFormat(), new DecimalFormat("00.00%")));

        // ----------------------------------------------------------------
        // Set the section label font to be large enough to read:
        // ----------------------------------------------------------------
        comparePiePlot.setLabelFont(chartHeaderFont);
        // winLossPiePlot.set

        // ----------------------------------------------------------------
        // Ignore any zero or null values:
        // ----------------------------------------------------------------
        comparePiePlot.setIgnoreZeroValues(true);
        comparePiePlot.setIgnoreNullValues(true);

        // Render the chart:
        this.remove(handComparisonPanel);

        handComparisonPanel = new ChartPanel(compareHandsChart);

        this.add(handComparisonPanel);

        // Redraw the panel so the graphs actually show:
        this.repaint();
        this.updateUI();

    }

}
