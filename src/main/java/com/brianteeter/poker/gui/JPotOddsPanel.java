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

import com.brianteeter.poker.results.HoldEmSimulationResults;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.text.DecimalFormat;

/**
 * This class uses a result object to calculate and display the current odds
 * that are being laid by the pot.
 *
 * @author Brian Teeter
 */
public class JPotOddsPanel extends JPanel
{

    JLabel potOddsLabel = null;
    JTextField potOddsField = null;

    /**
     * Default Constructor
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
        double rawOdds = 1 / winPercent;
        double potOdds = (rawOdds - 1);

        // Format the results so it fits the field:
        DecimalFormat formatter = new DecimalFormat("00.00");

        this.potOddsField.setText(formatter.format(potOdds) + " to 1");

    }

}
