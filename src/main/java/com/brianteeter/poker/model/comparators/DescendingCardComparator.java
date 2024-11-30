package com.brianteeter.poker.model.comparators;

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

import java.util.Comparator;

/**
 * This object is used to descending sort cards in lists.
 *
 * @author Brian Teeter
 */
public class DescendingCardComparator implements Comparator
{

    public int compare(Object arg0, Object arg1)
    {
        // If we don't have 2 Card objects to compare then we cannot do
        // a comparison, so return 0:
        if ((arg0 == null) || (arg1 == null)
                || (!(arg0 instanceof Card))
                || (!(arg1 instanceof Card)))
        {
            return 0;
        }

        Card card0 = (Card) arg0;
        Card card1 = (Card) arg1;

        if (card0.getRank() > card1.getRank())
        {
            return -1;
        } else
        {
            if (card0.getRank() < card1.getRank())
            {
                return 1;
            } else
            {
                return 0;
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
