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

import com.brianteeter.poker.model.StandardDeck;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class JAllCardsPanel extends JPanel
{

    StandardDeck newDeck = null;

    /**
     * Create a new JAllCardsPanel and populate it with cards.
     */
    public JAllCardsPanel()
    {
        // Create the cards that will populate this panel:
        newDeck = new StandardDeck();

        // Set the layout to be 4x13, one row per suit:
        this.setLayout(new GridLayout(4, 13, 2, 2));

        /**
         * Add each card as a button on the panel:
         */
        while (newDeck != null && (newDeck.getDeck() != null)
                && (newDeck.getDeck().size() > 0))
        {
            this.add(new JCardButton(newDeck.pullCard()));
        }

        // Set the border:
        this.setBorder(new TitledBorder("Card Selection"));
        Dimension dim = new Dimension((20 * 13), (30 * 4));
        this.setMaximumSize(dim);

    }

    /**
     * @param newListener
     */
    public void setCardButtonActionListener(ActionListener newListener)
    {
        Component[] cardButtons = this.getComponents();

        if (cardButtons != null)
        {
            ArrayList cardButtonList = new ArrayList(Arrays.asList((cardButtons)));

            while (!cardButtonList.isEmpty())
            {
                ((JCardButton) cardButtonList.get(0)).addActionListener(newListener);
                cardButtonList.remove(0);
            }

        }
    }

    /**
     * This method sets all buttons visible once again.
     */
    public void setAllVisible()
    {
        Component[] cardButtons = this.getComponents();

        if (cardButtons != null)
        {
            ArrayList cardButtonList = new ArrayList(Arrays.asList((cardButtons)));

            while (!cardButtonList.isEmpty())
            {
                ((JCardButton) cardButtonList.get(0)).setVisible(true);
                cardButtonList.remove(0);
            }
        }
    }
}
