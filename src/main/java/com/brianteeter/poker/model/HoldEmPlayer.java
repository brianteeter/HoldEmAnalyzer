package com.brianteeter.poker.model;

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

/**
 * This class represents a HoldEmPlayer.
 *
 * @author Brian Teeter
 */
public class HoldEmPlayer
{
    double bankroll = 0.0d;

    HoldEmHand hand = null;

    public double getBankroll()
    {
        return bankroll;
    }

    public void setBankroll(double bankroll)
    {
        this.bankroll = bankroll;
    }

    public HoldEmHand getHand()
    {
        return hand;
    }

    public void setHand(HoldEmHand hand)
    {
        this.hand = hand;
    }

    /**
     * Default Constructor
     */
    public HoldEmPlayer()
    {

    }

    /**
     * Constructor that takes in the starting player bankroll.
     *
     * @param bankroll
     */
    public HoldEmPlayer(double newBankroll)
    {
        setBankroll(newBankroll);
    }

    /**
     * Prints the HoldEmPlayer in a nice way:
     */
    public String toString()
    {
        String result = "";
        result += "Bankroll: " + bankroll + "\n";

        // If a hand has been created/populated:
        if (hand != null)
        {
            hand.rankHand();
            result += "Hole : " + hand.getHole1() + " " + hand.getHole2()
                    + "   ";
            result += "Made Hand : " + hand;
        }

        return result;
    }
}
