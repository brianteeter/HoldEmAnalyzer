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
 * This class represents one of the 4 suits of cards, or a joker, considered a
 * 5th suit.
 *
 * @author Brian Teeter
 */
public class Suit
{
    public static int SPADES = 1;

    public static int HEARTS = 2;

    public static int CLUBS = 3;

    public static int DIAMONDS = 4;

    public static int JOKER = 99;

    int suit = 0;

    /**
     * Default Suit constructor.
     *
     * @param newSuit
     */
    public Suit()
    {

    }

    /**
     * Parameterized Suit constructor.
     *
     * @param newSuit
     */
    public Suit(int newSuit)
    {
        setSuit(newSuit);
    }

    public int getSuit()
    {
        return suit;
    }

    public void setSuit(int suit)
    {
        this.suit = suit;
    }
}
