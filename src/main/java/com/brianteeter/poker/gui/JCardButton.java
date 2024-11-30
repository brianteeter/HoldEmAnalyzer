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

import com.brianteeter.poker.model.Card;
import com.brianteeter.poker.model.Suit;

import javax.swing.*;
import java.awt.*;

public class JCardButton extends JButton
{

    Font cardFont = new Font("Verdana", Font.BOLD, 11);
    Card card = null;

    public Card getCard()
    {
        return card;
    }

    public void setCard(Card newCard)
    {
        this.card = newCard;

        // Assuming we have a valid card, set the suit icon correctly:
        if (card != null)
        {

            if (card.getRank() == Card.RANK_ACE)
            {
                this.setText("A");
            } else
            {
                if (card.getRank() == Card.RANK_KING)
                {
                    this.setText("K");
                } else
                {
                    if (card.getRank() == Card.RANK_QUEEN)
                    {
                        this.setText("Q");
                    } else
                    {
                        if (card.getRank() == Card.RANK_JACK)
                        {
                            this.setText("J");
                        } else
                        {
                            if (card.getRank() == 10)
                            {
                                this.setText("T");
                            } else
                            {
                                this.setText("" + card.getRank());
                            }
                        }
                    }
                }
            }

            //
            if (card.getSuit().getSuit() == Suit.HEARTS)
            {
                this.setIcon(new ImageIcon(getClass().getResource("/hearts.gif")));
            }
            if (card.getSuit().getSuit() == Suit.CLUBS)
            {
                this.setIcon(new ImageIcon(getClass().getResource("/clubs.gif")));
            }
            if (card.getSuit().getSuit() == Suit.SPADES)
            {
                this.setIcon(new ImageIcon(getClass().getResource("/spades.gif")));
            }
            if (card.getSuit().getSuit() == Suit.DIAMONDS)
            {
                this.setIcon(new ImageIcon(getClass().getResource("/diamonds.gif")));
            }
        } else
        {
            // The card is null, so clear the button:
            this.setText("");
            this.setIcon(null);
        }

        if (card != null)
        {
            this.setActionCommand(card.toString());
        }

        this.setFont(cardFont);
    }

    /**
     * Default constructor - makes a blank button
     */
    public JCardButton()
    {
        init();
    }

    /**
     * Default constructor - makes a blank button
     */
    public JCardButton(Card newCard)
    {
        init();
        this.setCard(newCard);
    }

    /**
     * This method initializes the card button properly:
     */
    public void init()
    {
        this.setBorder(new JRoundedButtonBorder());

        this.setVerticalTextPosition(SwingConstants.TOP);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setIconTextGap(2);

        // Desired Dimensions:
        Insets insets = new Insets(1, 1, 1, 1);
        Dimension dim = new Dimension(17, 34);

        // this.setMargin(insets);
        this.setMinimumSize(dim);
        this.setMaximumSize(dim);
        this.setPreferredSize(dim);
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
