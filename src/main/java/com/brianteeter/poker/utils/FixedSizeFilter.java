package com.brianteeter.poker.utils;

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

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class FixedSizeFilter extends DocumentFilter
{
    int maxSize;

    // limit is the maximum number of characters allowed.
    public FixedSizeFilter(int limit)
    {
        maxSize = limit;
    }

    // This method is called when characters are inserted into the document
    public void insertString(DocumentFilter.FilterBypass fb, int offset,
                             String str, AttributeSet attr) throws BadLocationException
    {
        replace(fb, offset, 0, str, attr);
    }

    // This method is called when characters in the document are replace with
    // other characters
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length,
                        String str, AttributeSet attrs) throws BadLocationException
    {
        int newLength = fb.getDocument().getLength() - length + str.length();
        if (newLength <= maxSize)
        {
            fb.replace(offset, length, str, attrs);
        } else
        {
            throw new BadLocationException(
                    "New characters exceeds max size of document", offset);
        }
    }
}
