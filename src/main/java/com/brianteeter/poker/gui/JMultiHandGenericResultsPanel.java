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

import javax.swing.*;
import java.awt.*;

/**
 * Generic panel for multiple hand comparison results.
 *
 * @author Brian Teeter
 */
public class JMultiHandGenericResultsPanel extends JPanel
{
    protected Font defaultFont = new Font("Verdana", Font.PLAIN, 10);

    protected Font headerFont = new Font("Verdana", Font.BOLD, 12);

    protected Font chartHeaderFont = new Font("Verdana", Font.BOLD, 9);

    protected Font chartLabelFont = new Font("Verdana", Font.BOLD, 7);

    /**
     * Basic constructor
     */
    JMultiHandGenericResultsPanel()
    {


    }

    /**
     * Stub method that is implemented in extending classes.
     */
    public void insertResults(HoldEmHand h1, HoldEmHand h2, HoldEmHand h3,
                              HoldEmHand h4, HoldEmSimulationResults hand1,
                              HoldEmSimulationResults hand2, HoldEmSimulationResults hand3,
                              HoldEmSimulationResults hand4)
    {

    }

    /**
     * Stub method that is implemented in extending classes.
     */
    public void clearResults()
    {

    }
}
