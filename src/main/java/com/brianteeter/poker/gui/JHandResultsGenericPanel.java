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
import java.awt.*;
import java.text.DecimalFormat;

/**
 * This class is a superclass of the various Hand Results Panels that
 * are available to the user.
 *
 * @author Brian Teeter
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
        String result = formatter.format(percent) + "%";

        return result;
    }

}
