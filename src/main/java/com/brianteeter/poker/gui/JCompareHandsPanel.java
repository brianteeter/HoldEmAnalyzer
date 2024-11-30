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

import com.brianteeter.poker.engine.HoldEmSimulationEngine;
import com.brianteeter.poker.model.Card;
import com.brianteeter.poker.results.HoldEmSimulationResults;
import com.brianteeter.poker.utils.HoldEmAnalyzerConstants;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class puts together the Compare Hands Panel.
 *
 * @author Brian Teeter
 */
public class JCompareHandsPanel extends JPanel implements ActionListener,
        ItemListener

{
    Font defaultFont = new Font("Verdana", Font.BOLD, 10);

    Font evenSpacedFont = new Font("Courier", Font.PLAIN, 11);

    JLabel playerCountLabel = null;

    JComboBox playerCountDropDown = null;

    JHandSpecificationPanel hand1 = null;

    JHandSpecificationPanel hand2 = null;

    JHandSpecificationPanel hand3 = null;

    JHandSpecificationPanel hand4 = null;

    JAllCardsPanel cardPanel = null;

    JButton runSimulationButton = null;

    JButton clearButton = null;

    JMultiHandGenericResultsPanel multiHandResults = null;

    JPanel boardCardsPanel = null;

    JCardButton flopCard1 = null;

    JCardButton flopCard2 = null;

    JCardButton flopCard3 = null;

    JCardButton turnCard = null;

    JCardButton riverCard = null;

    public JPanel getBoardCardsPanel()
    {
        return boardCardsPanel;
    }

    public void setBoardCardsPanel(JPanel boardCardsPanel)
    {
        this.boardCardsPanel = boardCardsPanel;
    }

    public JAllCardsPanel getCardPanel()
    {
        return cardPanel;
    }

    public void setCardPanel(JAllCardsPanel cardPanel)
    {
        this.cardPanel = cardPanel;
    }

    public Font getDefaultFont()
    {
        return defaultFont;
    }

    public void setDefaultFont(Font defaultFont)
    {
        this.defaultFont = defaultFont;
    }

    public Font getEvenSpacedFont()
    {
        return evenSpacedFont;
    }

    public void setEvenSpacedFont(Font evenSpacedFont)
    {
        this.evenSpacedFont = evenSpacedFont;
    }

    public JCardButton getFlopCard1()
    {
        return flopCard1;
    }

    public void setFlopCard1(JCardButton flopCard1)
    {
        this.flopCard1 = flopCard1;
    }

    public JCardButton getFlopCard2()
    {
        return flopCard2;
    }

    public void setFlopCard2(JCardButton flopCard2)
    {
        this.flopCard2 = flopCard2;
    }

    public JCardButton getFlopCard3()
    {
        return flopCard3;
    }

    public void setFlopCard3(JCardButton flopCard3)
    {
        this.flopCard3 = flopCard3;
    }

    public JComboBox getPlayerCountDropDown()
    {
        return playerCountDropDown;
    }

    public void setPlayerCountDropDown(JComboBox playerCountDropDown)
    {
        this.playerCountDropDown = playerCountDropDown;
    }

    public JLabel getPlayerCountLabel()
    {
        return playerCountLabel;
    }

    public void setPlayerCountLabel(JLabel playerCountLabel)
    {
        this.playerCountLabel = playerCountLabel;
    }

    public JCardButton getRiverCard()
    {
        return riverCard;
    }

    public void setRiverCard(JCardButton riverCard)
    {
        this.riverCard = riverCard;
    }

    public JCardButton getTurnCard()
    {
        return turnCard;
    }

    public void setTurnCard(JCardButton turnCard)
    {
        this.turnCard = turnCard;
    }

    public JMultiHandGenericResultsPanel getMultiHandResults()
    {
        return multiHandResults;
    }

    public void setMultiHandResults(JMultiHandResultsPanel multiHandResults)
    {
        this.multiHandResults = multiHandResults;
    }

    public JButton getClearButton()
    {
        return clearButton;
    }

    public void setClearButton(JButton clearButton)
    {
        this.clearButton = clearButton;
    }

    public JHandSpecificationPanel getHand1()
    {
        return hand1;
    }

    public void setHand1(JHandSpecificationPanel hand1)
    {
        this.hand1 = hand1;
    }

    public JHandSpecificationPanel getHand2()
    {
        return hand2;
    }

    public void setHand2(JHandSpecificationPanel hand2)
    {
        this.hand2 = hand2;
    }

    public JHandSpecificationPanel getHand3()
    {
        return hand3;
    }

    public void setHand3(JHandSpecificationPanel hand3)
    {
        this.hand3 = hand3;
    }

    public JHandSpecificationPanel getHand4()
    {
        return hand4;
    }

    public void setHand4(JHandSpecificationPanel hand4)
    {
        this.hand4 = hand4;
    }

    public JButton getRunSimulationButton()
    {
        return runSimulationButton;
    }

    public void setRunSimulationButton(JButton runSimulationButton)
    {
        this.runSimulationButton = runSimulationButton;
    }

    /**
     * Create and arrange the panel:
     */
    public JCompareHandsPanel()
    {
        this.setLayout(null);

        playerCountLabel = new JLabel("Players: ");
        playerCountLabel.setSize(60, 20);
        playerCountLabel.setLocation(20, 10);
        this.add(playerCountLabel);

        playerCountDropDown = new JComboBox();
        playerCountDropDown.addItem("2");
        playerCountDropDown.addItem("3");
        playerCountDropDown.addItem("4");

        playerCountDropDown.setSize(50, 20);
        playerCountDropDown.setLocation(80, 10);
        playerCountDropDown.addItemListener(this);
        this.add(playerCountDropDown);

        hand1 = new JHandSpecificationPanel("Hand 1");
        hand1.setSize(120, 70);
        hand1.setLocation(10, 40);

        hand2 = new JHandSpecificationPanel("Hand 2");
        hand2.setSize(120, 70);
        hand2.setLocation(10, 115);

        hand3 = new JHandSpecificationPanel("Hand 3");
        hand3.setSize(120, 70);
        hand3.setLocation(10, 190);

        hand4 = new JHandSpecificationPanel("Hand 4");
        hand4.setSize(120, 70);
        hand4.setLocation(10, 265);

        // Create the board cards panel and the cards on the panel:
        boardCardsPanel = new JPanel();
        boardCardsPanel.setSize(175, 70);
        boardCardsPanel.setLocation(140, 10);
        boardCardsPanel.setBorder(new TitledBorder("Board Cards:"));
        this.add(boardCardsPanel);

        flopCard1 = new JCardButton();
        flopCard1.setSize(17, 34);
        flopCard1.setLocation(10, 10);
        boardCardsPanel.add(flopCard1);

        flopCard2 = new JCardButton();
        flopCard2.setSize(17, 34);
        flopCard2.setLocation(37, 10);
        boardCardsPanel.add(flopCard2);

        flopCard3 = new JCardButton();
        flopCard3.setSize(17, 34);
        flopCard3.setLocation(64, 10);
        boardCardsPanel.add(flopCard3);

        turnCard = new JCardButton();
        turnCard.setSize(17, 34);
        turnCard.setLocation(91, 10);
        boardCardsPanel.add(turnCard);

        riverCard = new JCardButton();
        riverCard.setSize(17, 34);
        riverCard.setLocation(118, 10);
        boardCardsPanel.add(riverCard);

        cardPanel = new JAllCardsPanel();
        cardPanel.setSize(260, 160);
        cardPanel.setLocation(140, 90);
        cardPanel.setCardButtonActionListener(this);

        runSimulationButton = new JButton("Run Simulation");
        runSimulationButton.setSize(120, 20);
        runSimulationButton.setLocation(150, 300);
        runSimulationButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.setSize(90, 20);
        clearButton.setLocation(300, 300);
        clearButton.addActionListener(this);

        this.add(cardPanel);
        this.add(hand1);
        this.add(hand2);
        this.add(hand3);
        this.add(hand4);
        this.add(runSimulationButton);
        this.add(clearButton);

        // Create the MultiHandResultsPanel
        multiHandResults = new JMultiHandPieChartResultsPanel();
        multiHandResults.setSize(370, 250);
        multiHandResults.setLocation(410, 10);
        this.add(multiHandResults);

    }

    /**
     * This method handles actions performed on the panel itself.
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e)
    {

        // ========================================================================
        // If the action is a JCardButton action, see where we need to put the
        // next card:
        // ========================================================================
        if (e.getSource().getClass().toString().indexOf(
                "com.brianteeter.poker.gui.JCardButton") > 0)
        {
            Card newCard = new Card(e.getActionCommand());
            JCardButton source = (JCardButton) e.getSource();
            source.setVisible(false);

            int playerCount = Integer.parseInt((String) this
                    .getPlayerCountDropDown().getSelectedItem());

            // If the Hand 1, Card 1 card is missing then put the card there:
            if (this.getHand1().getCard1Button().getCard() == null)
            {
                this.getHand1().getCard1Button().setCard(newCard);
            } else
            {
                if (this.getHand1().getCard2Button().getCard() == null)
                {
                    this.getHand1().getCard2Button().setCard(newCard);
                } else
                {

                    if (this.getHand2().getCard1Button().getCard() == null)
                    {
                        this.getHand2().getCard1Button().setCard(newCard);
                    } else
                    {
                        if (this.getHand2().getCard2Button().getCard() == null)
                        {
                            this.getHand2().getCard2Button().setCard(newCard);
                        } else
                        {
                            // We only proceed here if we're looking at 3 or
                            // more players:
                            if (playerCount >= 3)
                            {

                                if (this.getHand3().getCard1Button().getCard() == null)
                                {
                                    this.getHand3().getCard1Button().setCard(
                                            newCard);
                                } else
                                {
                                    if (this.getHand3().getCard2Button()
                                            .getCard() == null)
                                    {
                                        this.getHand3().getCard2Button()
                                                .setCard(newCard);
                                    } else
                                    {
                                        // We only proceed here if we're looking
                                        // at 3 or more players:
                                        if (playerCount >= 4)
                                        {

                                            if (this.getHand4()
                                                    .getCard1Button().getCard() == null)
                                            {
                                                this.getHand4()
                                                        .getCard1Button()
                                                        .setCard(newCard);
                                            } else
                                            {
                                                if (this.getHand4()
                                                        .getCard2Button()
                                                        .getCard() == null)
                                                {
                                                    this.getHand4()
                                                            .getCard2Button()
                                                            .setCard(newCard);
                                                } else
                                                {
                                                    this
                                                            .setNextBoardCard(newCard);
                                                }
                                            }
                                        } else
                                        {
                                            // Player Count is == 3 - so put the
                                            // next cards into the board:
                                            this.setNextBoardCard(newCard);
                                        }
                                    }
                                }
                            } else
                            {
                                // Player Count is == 2 - so put the next cards
                                // into the board:
                                this.setNextBoardCard(newCard);
                            }
                        }
                    }
                }
            }
        }

        // ===============================================================
        // If the user hits run simulation, run it:
        // ===============================================================
        if (e.getSource() == this.runSimulationButton)
        {

            // ===============================================================
            // Run the simulation:
            // ===============================================================
            HoldEmSimulationEngine engine = new HoldEmSimulationEngine();
            ArrayList resultObjects = engine.simulateHandsHeadsUp(hand1
                            .getHand(), hand2.getHand(), hand3.getHand(), hand4
                            .getHand(), flopCard1.getCard(), flopCard2.getCard(),
                    flopCard3.getCard(), turnCard.getCard(), riverCard
                            .getCard());

            if (resultObjects != null)
            {
                HoldEmSimulationResults result1 = (HoldEmSimulationResults) resultObjects
                        .get(0);
                HoldEmSimulationResults result2 = (HoldEmSimulationResults) resultObjects
                        .get(1);
                HoldEmSimulationResults result3 = null;
                HoldEmSimulationResults result4 = null;

                if (resultObjects.size() > 2)
                {
                    result3 = (HoldEmSimulationResults) resultObjects.get(2);
                }
                if (resultObjects.size() > 3)
                {
                    result4 = (HoldEmSimulationResults) resultObjects.get(3);
                }

                // Insert Results into the Table:
                this.multiHandResults.insertResults(hand1.getHand(), hand2
                                .getHand(), hand3.getHand(), hand4.getHand(), result1,
                        result2, result3, result4);

            } else
            {
                // this.messages.setText("ERROR: Unable to compare hands. Check
                // to ensure at least 2 hands are properly entered.");
            }

            // ----------------------------------------------------------------
            // If this is the trial version, occasionally open up
            // the Nag Screen:
            // ----------------------------------------------------------------
            if (HoldEmAnalyzerConstants.APPLICATION_TRIAL)
            {
                Random random = new Random();

                if (random.nextInt(5) <= 0)
                {
                    JNagScreen nag = new JNagScreen(null, true);
                    nag.setVisible(true);
                }
            }

        }

        // ===============================================================
        // If the user hits clear, then do so:
        // ===============================================================
        if (e.getSource() == this.clearButton)
        {
            this.clearPanel();
        }

    }

    /**
     * This function puts the clicked/entered card into the next available board
     * card location.
     *
     * @param nextCard
     */
    public void setNextBoardCard(Card nextCard)
    {
        if (nextCard != null)
        {
            // ========================================================
            // Start at the Flop and enter cards in order:
            // ========================================================
            if (this.getFlopCard1().getCard() == null)
            {
                this.getFlopCard1().setCard(nextCard);
            } else
            {
                if (this.getFlopCard2().getCard() == null)
                {
                    this.getFlopCard2().setCard(nextCard);
                } else
                {
                    if (this.getFlopCard3().getCard() == null)
                    {
                        this.getFlopCard3().setCard(nextCard);
                    } else
                    {
                        if (this.getTurnCard().getCard() == null)
                        {
                            this.getTurnCard().setCard(nextCard);
                        } else
                        {
                            this.getRiverCard().setCard(nextCard);
                        }
                    }
                }
            }
        }
    }

    /**
     * This method handles changes in Drop Downs:
     *
     * @param e
     */
    public void itemStateChanged(ItemEvent e)
    {
        // ========================================================================
        // If the user changes the player count, it will clear the fields
        // on the screen:
        // ========================================================================
        if (e.getSource() == this.getPlayerCountDropDown())
        {
            this.clearPanel();
        }

    }

    /**
     * This method clears the panel's components:
     */
    public void clearPanel()
    {
        // Reset the Card selector:
        cardPanel.setAllVisible();

        // Clear the hands
        hand1.clear();
        hand2.clear();
        hand3.clear();
        hand4.clear();

        // Clear the board cards:
        flopCard1.setCard(null);
        flopCard2.setCard(null);
        flopCard3.setCard(null);
        turnCard.setCard(null);
        riverCard.setCard(null);

        // Clear the results too:
        multiHandResults.clearResults();

        // Clear the output
        // this.messages.setText("");

    }
}
